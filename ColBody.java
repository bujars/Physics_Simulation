public class ColBody implements Body{

    private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    private double radius;
    private int[] rgb;
    private double mass;
    private double changeInXVelocity;
    private double changeInYVelocity;

    public ColBody(double xCoord, double yCoord, double xVel, double yVel, double m, double r, int red, int green, int blue){
        xCoordinate = xCoord;
        yCoordinate = yCoord;
        xVelocity = xVel;
        yVelocity = yVel;
        mass = m;
        radius = r;
        rgb = new int[]{red, green, blue};
    }

    /**
      * Gets the x-coordinate of the two dimensional body. This method is useful
      * for visualizing the simluation.
      * 
      * @return the x-coordinate of the two dimensional body.
      */
    public double getXCoord(){
        return xCoordinate;
    }

    /**
      * Gets the y-coordinate of the two dimensional body. This method is useful
      * for visualizing the simulation.
      *
      * @return the y-coordinate of the two dimensional body.
      */
    public double getYCoord(){
        return yCoordinate;
    }

    /**
      * Gets the x component of the velocity of the dimensional body.
      * 
     * @return the x component of the velocity of the two dimensional body.
     */
    public double getXVel(){
        return xVelocity;
    }

    /**
      * Gets the y component of the velocity  of the two dimensional body. 
      *
      * @return the y component of the velocity of the two dimensional body.
      */
    public double getYVel(){
        return yVelocity;
    }

    /**
      * Gets the radius of the two dimensional body. This method is useful for
      * visualizing the simulation.
      *
      * @return the radius of the two dimensional body.
      */
    public double getRadius(){
        return radius;
    }

    /**
      * Gets the color (red, green, and blue values on a 0-255 scale) of the
      * body. This method is useful for visualizing the simulation.
      *
      * @return an array of length 3 representing the color of the body; the
      *         value at 0th index represents red on a 0-255 scale, the value
      *         at the 1st green on a 0-255 scale, and the value at 2nd blue
      *         on a 0-255 scale 
      */
    public int[] getRGB(){
        return rgb;
    }

    /**
      * Gets the mass of two dimensional body.
      *
      * @return the mass of the two dimensional body.
      */
    public double getMass(){
        return mass;
    }

    /**
      * Calculates the force exterted on this two dimensional body by another
      * two dimensional body.
      *
      * @param otherBody the {@link TwoDimBody} exterting a force on this two
      *        two dimensional body
      */
    public void addForceFrom(Body otherBody){
	if(areBodiesTouching(otherBody) && areBodiesMoving(otherBody)){
	    changeInXVelocity = changeInXVelocity + this.calculateXVelocity(otherBody);
	    changeInYVelocity = changeInYVelocity + this.calculateYVelocity(otherBody);
        }
	else{
	    changeInXVelocity = 0;
	    changeInYVelocity = 0;
	}
    }

    /**
      * Based on the forces exterted on this two dimensional body and the 
      * existing position of the two dimensional body, determines the new
      * position of the body after moving for the provided amount of time.
      * Also should reset the forces on the {@link Body} to 0.
      *
      * @param timeDelta the amount of time the body moves
      */
    public void move(double timeDelta){
	xVelocity = (xVelocity + changeInXVelocity);
	yVelocity = (yVelocity + changeInYVelocity);
	xCoordinate = xCoordinate + (timeDelta * (xVelocity));
        yCoordinate = yCoordinate + (timeDelta * (yVelocity));
	changeInXVelocity = 0;
	changeInYVelocity = 0;
    }

    /**
     * Calculates the distnace between the centers of two dimensional bodies.
     *
     *
     * @return the distance between the centers of two bodies in decmial format. 
     *
     */
     public double getDistance(Body b){
        return Math.hypot(b.getXCoord() - this.xCoordinate, b.getYCoord() - this.yCoordinate);
    }


    /**
     * Checks to see if two Bodies are touching one another - that being,
     * the sum of the radiuses of the two dimensional bodies are greater than or requal to the distance between the centers of the two dimensional bodies
     *
     * @param otherBody is the 
     */
    public boolean areBodiesTouching(Body otherBody){
        return (this.getDistance(otherBody) <= (this.radius + otherBody.getRadius()));
    }


    /**
     * Checks to see if the Dot Product of two, two dimensional bodies, is less than zero.
     *
     * @return if the dot product is less than zero or not
     */
    public boolean areBodiesMoving(Body otherBody){
        return (this.calculateDotProduct(otherBody) < 0);

    }

    /**
     * Calculates the Dot product of two, two dimensional, bodies. 
     *
     * @return the dot product of the two bodies
     */
    public double calculateDotProduct(Body otherBody){
        double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
        double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
        double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
        double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
        return (deltaXPosition * deltaXVelocity) + (deltaYPosition * deltaYVelocity);
    }

    /**
     * Calcuates the change in x velocity when two bodies that excert forces on each other in perfectly ellastic collision
     *
     * @return the change in x velocity
     */
    public double calculateXVelocity(Body otherBody){
        double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
        double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
        double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
        double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
        double calc =  ((2*otherBody.getMass())/(this.mass + otherBody.getMass())) * (deltaXPosition) * (calculateDotProduct(otherBody)/((deltaXPosition*deltaXPosition) + (deltaYPosition*deltaYPosition)));
	changeInXVelocity = calc;
	return calc; 

    }

    public double calculateYVelocity(Body otherBody){
        double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
        double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
        double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
        double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
        double calc =  ((2*otherBody.getMass())/(this.mass+otherBody.getMass())) * (deltaYPosition) * (calculateDotProduct(otherBody)/((deltaXPosition*deltaXPosition)+(deltaYPosition*deltaYPosition)));
	changeInYVelocity = calc;
	return calc;
    }

    public double getChangeInXVelocity(){
	return changeInXVelocity;
    }
    
    public double getChangeInYVelocity(){
	return changeInYVelocity;
    }

    /**
     * Gets a ColBody and returns it information into a string. 
     * @returns a string representation of a ColBody in the format of XCoord, YCoord, XVeloc, YVeloc, Mass, Radius, RGB  
     *
     */
    public String toString(){
        return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + " Mass: " + mass + " Radius: " + radius +  " RGB: " + rgb[0] + " " + rgb[1] + " " + rgb[2];
    }
}