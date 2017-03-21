public class Boid implements Body{

    private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    private int countOfNeighbors;
    private double sumOfNeighborsX;
    private double sumOfNeighborsY; 
    private double changeInXVelocity;
    private double changeInYVelocity; 
    private double sumOfNeighborsVelX;
    private double sumOfNeighborsVelY;
    private double sumOfXDistToThis;
    private double sumOfYDistToThis;
    private double radius;
    private int[] rgb; 
    
    public Boid(double xCoord, double yCoord, double xVel, double yVel, double rad, int red, int green, int blue){
        xCoordinate = xCoord;
        yCoordinate = yCoord;
        xVelocity = xVel;
        yVelocity = yVel;
	radius = rad;
	rgb = new int[]{red, green, blue};
    }

    /**
     * Gets the x-coordinate of the two dimensional boid. This method is useful
     * for visualizing the simluation.
     * 
     * @return the x-coordinate of the two dimensional boid.
     */
    public double getXCoord(){
        return xCoordinate;
    }

    /**
     * Gets the y-coordinate of the two dimensional boid. This method is useful
     * for visualizing the simulation.
     *
     * @return the y-coordinate of the two dimensional boid.
     */
    public double getYCoord(){
        return yCoordinate;
    }

    /**
     * Gets the x component of the velocity of the dimensional boid.
     * 
     * @return the x component of the velocity of the two dimensional boid.
     */
    public double getXVel(){
        return xVelocity;
    }

    /**
     * Gets the y component of the velocity  of the two dimensional boid. 
     *
     * @return the y component of the velocity of the two dimensional boid.
     */
    public double getYVel(){
        return yVelocity;
    }

    /**
     * Gets the radius of the two dimensional boid. This method is useful for
     * visualizing the simulation.
     *
     * @return the radius of the two dimensional boid.
     */
    public double getRadius(){
	return radius;
    }

    /**
     * Gets the color (red, green, and blue values on a 0-255 scale) of the
     * boid. This method is useful for visualizing the simulation.
     *
     * @return an array of length 3 representing the color of the boid; the
     *         value at 0th index represents red on a 0-255 scale, the value
     *         at the 1st green on a 0-255 scale, and the value at 2nd blue
     *         on a 0-255 scale 
     */
    public int[] getRGB(){
	return rgb;
    }

    /**
     * Gets the mass of two dimensional boid.
     *
     * @return the mass of the two dimensional boid.
     */
    public double getMass(){
	return -1; 
    }

    /**
     * Calculates the force exterted on this two dimensional boid by another
     * two dimensional boid.
     *
     * @param otherBody the {@link TwoDimBody} exterting a force on this two
     *        two dimensional boid
     */
    public void addForceFrom(Body otherBoid){
	if(radius >= calcDistance(otherBoid)){
	    addCohesionForceFrom(otherBoid);
	    addAlignmentForceFrom(otherBoid);
	    addSeparationForceFrom(otherBoid);
	    countOfNeighbors++;
	}
    }

    /**
      * Calculates the cohesion force excerted on this two dimenional boid by another 
      * two dimensional boid.
      *
      *
      */
    public void addCohesionForceFrom(Body otherBoid){
	sumOfNeighborsX = sumOfNeighborsX + otherBoid.getXCoord();
        sumOfNeighborsY = sumOfNeighborsY + otherBoid.getYCoord();
    }

    public void addAlignmentForceFrom(Body otherBoid){
	sumOfNeighborsVelX = sumOfNeighborsVelX + otherBoid.getXVel();
        sumOfNeighborsVelY = sumOfNeighborsVelY + otherBoid.getYVel();	
    }

    public void addSeparationForceFrom(Body otherBoid){
	double calcXDistToThis = (xCoordinate - otherBoid.getXCoord()) / Math.pow(calcDistance(otherBoid), 2);
        sumOfXDistToThis = sumOfXDistToThis + (calcXDistToThis);

        double calcYDistToThis = (yCoordinate - otherBoid.getYCoord()) / Math.pow(calcDistance(otherBoid), 2);
        sumOfYDistToThis = sumOfYDistToThis + (calcYDistToThis);
    }

    /**
     * Based on the forces exterted on this two dimensional boid and the 
     * existing position of the two dimensional boid, determines the new
     * position of the boid after moving for the provided amount of time.
     * Also should reset the forces on the {@link Body} to 0.
     *
     * @param timeDelta the amount of time the body moves
     */
    public void move(double timeDelta){
	changeInXVelocity = (getCurXCohesionForce() + getCurXAlignmentForce() + getCurXSeparationForce()) / 3;
	changeInYVelocity = (getCurYCohesionForce() + getCurYAlignmentForce() + getCurYSeparationForce()) / 3;
	xVelocity = xVelocity + changeInXVelocity; 
	yVelocity = yVelocity + changeInYVelocity;
	xCoordinate = xCoordinate + (xVelocity * timeDelta);
	yCoordinate = yCoordinate + (yVelocity * timeDelta);
	changeInXVelocity = 0;
	changeInYVelocity = 0;
	sumOfXDistToThis = 0;
	sumOfYDistToThis = 0;
	sumOfNeighborsVelX = 0;
	sumOfNeighborsVelY = 0;
	sumOfNeighborsX = 0;
	sumOfNeighborsY = 0;
    }

    /**
     * Returns the sumOfNeighbors X
     *
     */
    public double getSumOfNeighborsX(){
	return sumOfNeighborsX; 
    }
    
    /**
     * Returens the sumOfNeighbors Y
     *
     */
    public double getSumOfNeighborsY(){
	return sumOfNeighborsY;
    }

    public double getCountOfNeighbors(){
	return countOfNeighbors;
    }

    /**
     * Calculates the x coordinate of the center of the neighbors
     *
     */
    public double calcXNeighborsCenter(){
	return (sumOfNeighborsX / countOfNeighbors) - xCoordinate;
    }

    /**
     * Calculates the y coordinate of the center of the neighbors
     *
     */ 
    public double calcYNeighborsCenter(){
	return (sumOfNeighborsY / countOfNeighbors) - yCoordinate; 
    }

    /**
     * Gets the change in  x component of the velocity of the dimensional body.
     *
     * @return the change in x component of the velocity of the two dimensional body.   
     *
     */
    public double getChangeInXVelocity(){
	return changeInXVelocity;
    }

    /**
     * Gets the change in  y component of the velocity of the dimensional body.
     * 
     * @return the change in y component of the velocity of the two dimensional body.
     *    
     */
    public double getChangeInYVelocity(){
	return changeInYVelocity;
    }

    public double getSumOfNeighborsVelX(){
	return sumOfNeighborsVelX;
    }

    public double getSumOfNeighborsVelY(){
	return sumOfNeighborsVelY;
    }

    public double calcDistance(Body otherBoid){
	double distance =  Math.sqrt((Math.pow((otherBoid.getXCoord() - this.xCoordinate), 2)) + (Math.pow((otherBoid.getYCoord() - this.yCoordinate), 2)));
	return distance;
    }

    public double getSumOfXDistToThis(){
	return sumOfXDistToThis;
    }
    
    public double getSumOfYDistToThis(){
	return sumOfYDistToThis; 
    }
    
    public double getCurXCohesionForce(){
	if(countOfNeighbors == 0.0){
            return 0.0;
	}
	return (sumOfNeighborsX / countOfNeighbors) - this.xCoordinate;
    }

    public double getCurYCohesionForce(){
	if(countOfNeighbors == 0.0){
            return 0.0;
	}
	return (sumOfNeighborsY / countOfNeighbors) - this.yCoordinate;
    }

    public double getCurXSeparationForce(){
	if(countOfNeighbors == 0.0){
            return 0.0;
        }
	return sumOfXDistToThis / countOfNeighbors;
    }
    
    public double getCurYSeparationForce(){
	if(countOfNeighbors == 0.0){
            return 0.0;
        }	
	return sumOfYDistToThis / countOfNeighbors;
    }
    
    public double getCurXAlignmentForce(){
	if(countOfNeighbors == 0.0){
            return 0.0;
        }
	return sumOfNeighborsVelX / countOfNeighbors;
    }

    public double getCurYAlignmentForce(){
	if(countOfNeighbors == 0.0){
            return 0.0;
        }
	return sumOfNeighborsVelY / countOfNeighbors;
    }

    public String toString(){
        return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + " XVeloc: " + xVelocity + " YVeloc: " + yVelocity;
    }

}