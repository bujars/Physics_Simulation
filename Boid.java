public class Boid{

    private Vector2D position;
    private Vector2D velocity;
    private int countOfNeighbors;
    private Vector2D sumOfNeighborsPosition;
    private Vector2D sumOfNeighborsVelocities;
    private Vector2D sumOfDistanceToThis;
    private double radius;
    private double universeRadius;
    private int[] rgb; 
    
    public Boid(double xCoord, double yCoord, double xVel, double yVel, 
		double rad, int red, int green, int blue){
        
	position = new Vector2D(xCoord, yCoord);
	velocity = new Vector2D(xVel, yVel);
	radius = rad;
	universeRadius = 100; 
	rgb = new int[]{red, green, blue};
	sumOfNeighborsPosition = new Vector2D(0.0, 0.0);
	sumOfNeighborsVelocities = new Vector2D(0.0, 0.0);
	sumOfDistanceToThis = new Vector2D(0.0, 0.0);
    
    }
    
    public Boid(double xCoord, double yCoord, double xVel, double yVel,
                double rad, int red, int green, int blue, double uniRad){

        position = new Vector2D(xCoord, yCoord);
        velocity = new Vector2D(xVel, yVel);
        radius = rad;
	universeRadius = uniRad;
        rgb = new int[]{red, green, blue};
        sumOfNeighborsPosition = new Vector2D(0.0, 0.0);
        sumOfNeighborsVelocities = new Vector2D(0.0, 0.0);
        sumOfDistanceToThis = new Vector2D(0.0, 0.0);

	}


    public Vector2D getPosition(){
	return position;
    }

    public Vector2D getVelocity(){
	return velocity;
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
    public void addForceFrom(Boid otherBoid){
	if(radius > calcDistance(otherBoid)){
	    addCohesionForceFrom(otherBoid);
	    addAlignmentForceFrom(otherBoid);
	    addSeparationForceFrom(otherBoid);
	    countOfNeighbors++;
	    System.out.println(countOfNeighbors);
	}
    }

    /**
      * Calculates the cohesion force excerted on this two dimenional boid 
      * by another two dimensional boid.
      *
      *
      */
    public void addCohesionForceFrom(Boid otherBoid){
	sumOfNeighborsPosition = sumOfNeighborsPosition.getSum(otherBoid.getPosition());
    }

    public void addAlignmentForceFrom(Boid otherBoid){
	sumOfNeighborsVelocities = sumOfNeighborsVelocities.getSum(otherBoid.getVelocity());
    }

    public void addSeparationForceFrom(Boid otherBoid){
	Vector2D calcDistToThis = position.getDiff(otherBoid.getPosition());
	Vector2D calcDistToThisDivision = calcDistToThis.getScaling(Math.pow(1.0/calcDistToThis.getMagnitude(), 2));

	sumOfDistanceToThis = sumOfDistanceToThis.getSum(calcDistToThisDivision); 
    }

    /**
     * Based on the forces exterted on this two dimensional boid and the 
     * existing position of the two dimensional boid, determines the new
     * position of the boid after moving for the provided amount of time.
     * Also should reset the forces on the {@link Body} to 0.
     *
     * @param timeDelta the amount of time the body moves
     */
    public void move(double timeDelta){//Check is xcomp is positive or negative and how it would be affected by radius.
	Vector2D changeInVelocity = ((getCurCohesionForce().getSum(getCurAlignmentForce())).getSum(getCurSeparationForce()));
	velocity = velocity.getSum(changeInVelocity);
	Vector2D positionBeforeWrapping = position.getSum(velocity.getScaling(timeDelta));
	if(positionBeforeWrapping.getXComp() > universeRadius){
	    positionBeforeWrapping = new Vector2D(positionBeforeWrapping.getXComp() + (-universeRadius * 2), positionBeforeWrapping.getYComp());
	}
	else if(positionBeforeWrapping.getXComp() < -universeRadius){
            positionBeforeWrapping = new Vector2D(positionBeforeWrapping.getXComp() + (universeRadius * 2), positionBeforeWrapping.getYComp());
        }
	if(positionBeforeWrapping.getYComp() > universeRadius){
	    positionBeforeWrapping = new Vector2D(positionBeforeWrapping.getXComp(), (-universeRadius*2) + (positionBeforeWrapping.getYComp()));
	}
	else if(positionBeforeWrapping.getYComp() < -universeRadius){
            positionBeforeWrapping = new Vector2D(positionBeforeWrapping.getXComp(), (universeRadius*2) + (positionBeforeWrapping.getYComp()));
        }
	position = positionBeforeWrapping; 
	sumOfDistanceToThis = new Vector2D(0.0, 0.0);
	sumOfNeighborsPosition = new Vector2D(0.0, 0.0);
	sumOfNeighborsVelocities = new Vector2D(0.0, 0.0);
	countOfNeighbors = 0;
    }


    public double calcDistance(Boid otherBoid){
	return (((otherBoid.getPosition()).getDiff(position)).getMagnitude());
    }

    public Vector2D getSumOfNeighborsPosition(){
	return sumOfNeighborsPosition;
    }

    public double getCountOfNeighbors(){
	return countOfNeighbors;
    }

    public Vector2D getSumOfNeighborsVelocities(){
	return sumOfNeighborsVelocities;
    }

    public Vector2D getSumOfDistanceToThis(){
	return sumOfDistanceToThis;
    }
    
    public Vector2D getCurCohesionForce(){
	if(countOfNeighbors == 0){
	    return new Vector2D(0.0, 0.0);
	}
	return ((sumOfNeighborsPosition.getScaling(1.0/countOfNeighbors)).getDiff(position)).getDiff(velocity);
    }

    public Vector2D getCurSeparationForce(){
	if(countOfNeighbors == 0){
	    return new Vector2D(0.0, 0.0);
	}
	return sumOfDistanceToThis.getScaling(1.0/countOfNeighbors);
    }
  
    public Vector2D getCurAlignmentForce(){
	if(countOfNeighbors == 0){
	    return new Vector2D(0.0, 0.0);
	}
	return (sumOfNeighborsVelocities.getScaling(1.0/countOfNeighbors)).getDiff(velocity);
    }

    public Vector2D calcRotatedVector2D(double degree){
	double rotX = (this.getVelocity().getXComp() * Math.cos(degree)) - 
	    (this.getVelocity().getYComp() * Math.sin(degree));
	double rotY = (this.getVelocity().getXComp() * Math.sin(degree)) + 
	    (this.getVelocity().getYComp() * Math.cos(degree));
	return new Vector2D(rotX, rotY);
    }

    public Vector2D[] getVerticies(){
        double verDis = universeRadius/5;
        Vector2D tip = velocity.getCappedVersion(verDis, verDis);
        Vector2D left = tip.calcRotatedVector2D(120.0);
        Vector2D right = tip.calcRotatedVector2D(240.0);
        Vector2D[] ret = new Vector2D[]{tip, left, right};
        return ret;
    }



    /*public String toString(){
        return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + 
	    " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + 
	    " Radius: " + radius + " RGB: " + rgb[0] + " " + 
	    rgb[1] + " " + rgb[2];
    }*/

	
	
}
