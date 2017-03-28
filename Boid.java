public class Boid{

    /*private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    */
    private Vector2D position;
    private Vector2D velocity;

    private int countOfNeighbors;
 
    /*private double sumOfNeighborsX;
    private double sumOfNeighborsY;  
    */

    private Vector2D sumOfNeighborsPosition;

    /*private double sumOfNeighborsVelX;
    private double sumOfNeighborsVelY;*/
    
    private Vector2D sumOfNeighborsVelocities;

    /*private double sumOfXDistToThis;
    private double sumOfYDistToThis;*/
    
    private Vector2D sumOfDistanceToThis;
    
    private double radius;
    private int[] rgb; 
    
    public Boid(double xCoord, double yCoord, double xVel, double yVel, 
		double rad, int red, int green, int blue){
        
	position = new Vector2D(xCoord, yCoord);
	velocities = new Vector2D(xVel, yVel);

	/*xCoordinate = xCoord;
        yCoordinate = yCoord;
        xVelocity = xVel;
        yVelocity = yVel;
	*/
	radius = rad;
	rgb = new int[]{red, green, blue};
	sumOfNeighborsPosition = new Vector2D(0.0, 0.0);
	sumOfNeighborsVelocities = new Vector2D(0.0, 0.0);
	sumOfDistanceToThis = new Vector2D(0.0, 0.0);
    
    }

    /*
     /**
     * Gets the x-coordinate of the two dimensional boid. This method is useful
     * for visualizing the simluation.
     * 
     * @return the x-coordinate of the two dimensional boid.
     *
    public double getXCoord(){
        return xCoordinate;
    }

    /**
     * Gets the y-coordinate of the two dimensional boid. This method is useful
     * for visualizing the simulation.
     *
     * @return the y-coordinate of the two dimensional boid.
     *
    public double getYCoord(){
        return yCoordinate;
    }

    /**
     * Gets the x component of the velocity of the dimensional boid.
     * 
     * @return the x component of the velocity of the two dimensional boid.
     *
    public double getXVel(){
        return xVelocity;
    }

    /**
     * Gets the y component of the velocity  of the two dimensional boid. 
     *
     * @return the y component of the velocity of the two dimensional boid.
     *
    public double getYVel(){
        return yVelocity;
    }
    */


    /*public double getXPosition(){
	return position.getXComp();
    }

    public double getYPosition(){
	return position.getYComp();
    }*/

    public Vector2D getPosition(){
	return position;
    }


    public Vector2D getVelocity(){
	return velocity;
    }
    
    /*public double getXVelocity(){
	return velocity.getXComp();
    }
    
    public double getYVelocity(){
	return velocity.getYComp();
	}*/
    
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
	if(radius >= calcDistance(otherBoid)){
	    addCohesionForceFrom(otherBoid);
	    addAlignmentForceFrom(otherBoid);
	    addSeparationForceFrom(otherBoid);
	    countOfNeighbors++;
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

	/*sumOfNeighborsX = sumOfNeighborsX + otherBoid.getXCoord();
	  sumOfNeighborsY = sumOfNeighborsY + otherBoid.getYCoord();*/
    }

    public void addAlignmentForceFrom(Boid otherBoid){

	sumOfNeighborsVelocities = sumOfNeighborsVelocites.getSum(otherBoid.getVelocity());

	/*sumOfNeighborsVelX = sumOfNeighborsVelX + otherBoid.getXVel();
	  sumOfNeighborsVelY = sumOfNeighborsVelY + otherBoid.getYVel();	*/
    }

    public void addSeparationForceFrom(Boid otherBoid){
	Vector2D calcDistToThis = position.getDiff(otherBoid.getPosition());
	Vector2D calcDistToThisDivision = calcDistToThis.getScaling(Math.pow(1/getMagnitude(), 2));

	sumOfDistanceToThis = sumOfDistanceToThis.getSum(calcDistToThisDivision); 
	

	/*	double calcXDistToThis = (xCoordinate - otherBoid.getXCoord()) /
	    Math.pow(calcDistance(otherBoid), 2);
        sumOfXDistToThis = sumOfXDistToThis + (calcXDistToThis);

        double calcYDistToThis = (yCoordinate - otherBoid.getYCoord()) / 
	    Math.pow(calcDistance(otherBoid), 2);
        sumOfYDistToThis = sumOfYDistToThis + (calcYDistToThis);
	*/
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
	/*double changeInXVelocity = (getCurXCohesionForce() + 
				    getCurXAlignmentForce() + 
				    getCurXSeparationForce()) / 3;
	double changeInYVelocity = (getCurYCohesionForce() + 
				    getCurYAlignmentForce() + 
				    getCurYSeparationForce()) / 3;
	*/
	Vector2D changeInVelocity = getCurCohesionForce.getSum(getCurAlignmentForce()).getSum(getCurSeparationForce()).getScaling(1/3);

	/*xVelocity = xVelocity + changeInXVelocity; 
	yVelocity = yVelocity + changeInYVelocity;
	*/

	velocity = velocity.getSum(changeInVelocity);
	/*xCoordinate = xCoordinate + (xVelocity * timeDelta);
	yCoordinate = yCoordinate + (yVelocity * timeDelta);*/
	
	position = position.getSum(velocity.getScaling(timeDelta));

	/*sumOfXDistToThis = 0;
	sumOfYDistToThis = 0;
	sumOfNeighborsVelX = 0;
	sumOfNeighborsVelY = 0;
	sumOfNeighborsX = 0;
	sumOfNeighborsY = 0;
	*/
	
	sumOfDistanceToThis = new Vector2D(0.0, 0.0);
	sumOfNeighborsPosition = new Vector2D(0.0, 0.0);
	sumOfNeighborsVelocities = new Vector2D(0.0, 0.0);

	countOfNeighbors = 0;
    }


    public double calcDistance(Boid otherBoid){
	/*return Math.sqrt((Math.pow((otherBoid.getXComp() - 
				    getXComp()), 2)) + 
			 (Math.pow((otherBoid.getYComp() - 
			 getYComp()), 2)));*/

	return Math.sqrt(position.getDiff(otherBoid).getMagnitude());
    }


    /**
     * Returns the sumOfNeighbors X
     *
     */
    /*    public double getSumOfNeighborsX(){
	return sumOfNeighborsX; 
	}*/
    
    /**
     * Returens the sumOfNeighbors Y
     *
     */
    /*    public double getSumOfNeighborsY(){
	return sumOfNeighborsY;
    }*/


    public Vector2D getSumOfNeighborsPosition(){
	return sumOfNeighborsPosition;
    }


    public double getCountOfNeighbors(){
	return countOfNeighbors;
    }

    /*public double getSumOfNeighborsVelX(){
	return sumOfNeighborsVelX;
    }

    public double getSumOfNeighborsVelY(){
	return sumOfNeighborsVelY;
	}*/

    public Vector2D getSumOfNeighborsVelocities(){
	return sumOfNeighborsVelocities;
    }


    /*    public double getSumOfXDistToThis(){
	return sumOfXDistToThis;
    }
    
    public double getSumOfYDistToThis(){
	return sumOfYDistToThis; 
	}*/


    public Vector2D getSumOfDistanceToThis(){
	return sumOfDistanceToThis;
    }
    


    /*   public double getCurXCohesionForce(){
	if(countOfNeighbors == 0){
            return 0;
	}
	return (sumOfNeighborsX / countOfNeighbors) - this.xCoordinate;
    }

    public double getCurYCohesionForce(){
	if(countOfNeighbors == 0){
            return 0;
	}
	return (sumOfNeighborsY / countOfNeighbors) - this.yCoordinate;
	}*/

    public Vector2D getCurCohesionForce(){
	if(countOfNeighbors == 0){
	    return new Vector2D(0.0, 0.0);
	}
	return sumOfNeighborsPosition.getScaling(1/countOfNeighbors).getDiff(position);
    }

    /*    public double getCurXSeparationForce(){
	if(countOfNeighbors == 0){
            return 0;
        }
	return sumOfXDistToThis / countOfNeighbors;
    }
    
    public double getCurYSeparationForce(){
	if(countOfNeighbors == 0){
            return 0;
        }	
	return sumOfYDistToThis / countOfNeighbors;
	}*/

    public Vector2D getCurSeparationForce(){
	if(countOfNeighbors == 0){
	    return new Vector2D(0.0, 0.0);
	}
	return sumOfDistanceToThis.getScaling(1/countOfNeighbors);
    }
  
    /*public double getCurXAlignmentForce(){
	if(countOfNeighbors == 0){
            return 0;
        }
	return sumOfNeighborsVelX / countOfNeighbors;
    }

    public double getCurYAlignmentForce(){
	if(countOfNeighbors == 0){
            return 0;
        }
	return sumOfNeighborsVelY / countOfNeighbors;
	}*/

    public Vector2D getCurAlignmentForce(){
	if(countOfNeighbors == 0){
	    return new Vector2D(0.0, 0.0);
	}
	return sumOfNeighborsVelocities.getScaling(1/countOfNeighbors);
    }

    public String toString(){
        return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + 
	    " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + 
	    " Radius: " + radius + " RGB: " + rgb[0] + " " + 
	    rgb[1] + " " + rgb[2];
    }

}