public class CohBoid implements Body{

    private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    private int countOfNeighbors;
    private double sumOfNeighborsX;
    private double sumOfNeighborsY; 
    private double changeInXVelocity;
    private double changeInYVelocity; 

    public CohBoid(double xCoord, double yCoord, double xVel, double yVel){
        xCoordinate = xCoord;
        yCoordinate = yCoord;
        xVelocity = xVel;
        yVelocity = yVel;
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

    public double getRadius(){
	return -1;
    }

    public int[] getRGB(){
	int[] rgb = new int[]{0, 0, 0};
	return rgb;
    }

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
        recordNeighborsPosition(otherBoid);
	double xCenter = this.calcXNeighborsCenter();
	double yCenter = this.calcYNeighborsCenter();
	double xCohesionForce = calcXCohesionForce(xCenter);
	double yCohesionForce = calcYCohesionForce(yCenter);
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

    }



    /**
     * Stores the otherBoids x/y position on the instance variable, added to "this" boid. 
     *
     *
     */
    public void recordNeighborsPosition(Body otherBoid){
	sumOfNeighborsX = sumOfNeighborsX + otherBoid.getXCoord();
	sumOfNeighborsY = sumOfNeighborsY + otherBoid.getYCoord();
	countOfNeighbors++;
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
	return sumOfNeighborsX / countOfNeighbors;
    }

    /**
     * Calculates the y coordinate of the center of the neighbors
     *
     */ 
    public double calcYNeighborsCenter(){
	return sumOfNeighborsY / countOfNeighbors; 
    }

    /**
     * Calaulcates the Cohesion Force of this boid: 
     * 
     * UPDATE IT
     */
    public double calcXCohesionForce(Double xCenter){
	changeInXVelocity = xCenter - this.xCoordinate;
	return changeInXVelocity;
    }


    /**
     * Calculates the Cohesion force of this boid.
     * 
     * UPDATE IT
     */
    public double calcYCohesionForce(Double yCenter){
	changeInYVelocity = yCenter - this.yCoordinate; 
	return changeInYVelocity;
    }

    public double getChangeInXVelocity(){
	return changeInXVelocity;
    }

    public double getChangeInYVelocity(){
	return changeInYVelocity;
    }

}