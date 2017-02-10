public class ColBody implements Body{

    private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    private double radius;
    private int[] rgb;
    private double mass;
    //private double xForce;
    //private double yForce;
    private double changeXVelocity;
    private double changeYVelocity;

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
        /*xForce = xForce + this.calculateXForce(otherBody);
	  yForce = yForce + this.calculateYForce(otherBody);*/
	changeXVelocity = 0;
	changeYVelocity = 0;
	if(areBodiesTouching(otherBody) && areBodiesMoving(otherBody)){
	    changeXVelocity = this.calculateXVelocity(otherBody);
	    changeYVelocity = this.calculateYVelocity(otherBody);
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
	//xVelocity = xVelocity + (timeDelta * calculateXAccel() + changeXVelocity);
	//yVelocity = yVelocity + (timeDelta * calculateYAccel() + changeYVelocity);
        xVelocity = (xVelocity + changeXVelocity);
	yVelocity = (yVelocity + changeYVelocity);
	xCoordinate = xCoordinate + (timeDelta * (xVelocity));
        yCoordinate = yCoordinate + (timeDelta * (yVelocity));
	changeXVelocity = 0;
	changeYVelocity = 0;
        /*xForce = 0;
        yForce = 0;*/
    }

    /*
    public double getXForce(){
        return xForce;
    }

    public double getYForce(){
        return yForce;
    }
    public double calculateTotalForce(Body b){
        if(getDistance(b) == 0){
            return 0;
        }
        double g = 6.67E-11;
        double fg = ((g)*(b.getMass())*(this.getMass()))/((getDistance(b))*(getDistance(b)));
        return fg;
    }
    */
    public double getDistance(Body b){
        return Math.hypot(b.getXCoord() - this.xCoordinate, b.getYCoord() - this.yCoordinate);
    }
    /*
    public double getAngle(Body b){
        return Math.atan2((b.getYCoord() - this.yCoordinate), (b.getXCoord() - this.xCoordinate));
    }
    
    public double calculateXForce(Body b){
        xForce = (calculateTotalForce(b) * Math.cos(getAngle(b)));
        return xForce;
    }

    public double calculateYForce(Body b){
        yForce = (calculateTotalForce(b) * Math.sin(getAngle(b)));
        return yForce;
    }

    public double calculateXAccel(){
        if(getMass() == 0){
            return 0;
        }
        return (xForce/getMass());
    }

    public double calculateYAccel(){
        if(getMass() == 0){
            return 0;
        }
        return (yForce/getMass());
    }
    */
    public boolean areBodiesTouching(Body otherBody){
        return (this.getDistance(otherBody) <= (this.radius + otherBody.getRadius()));
    }

    public boolean areBodiesMoving(Body otherBody){
        return (this.calculateDotProduct(otherBody) < 0);

    }

    public double calculateDotProduct(Body otherBody){
        double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
        double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
        double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
        double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
        return (deltaXPosition * deltaXVelocity) + (deltaYPosition * deltaYVelocity);
    }

    public double calculateXVelocity(Body otherBody){
        double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
        double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
        double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
        double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
        return ((2*otherBody.getMass())/(this.mass + otherBody.getMass())) * (deltaXPosition) * (calculateDotProduct(otherBody)/((deltaXPosition*deltaXPosition) + (deltaYPosition*deltaYPosition)));
    }

    public double calculateYVelocity(Body otherBody){
        double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
        double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
        double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
        double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
        return ((2*otherBody.getMass())/(this.mass+otherBody.getMass())) * (deltaYPosition) * (calculateDotProduct(otherBody)/((deltaXPosition*deltaXPosition)+(deltaYPosition*deltaYPosition)));
    }

    public String toString(){
        return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + " Mass: " + mass + " Radius: " + radius +  " RGB: " + rgb[0] + " " + rgb[1] + " " + rgb[2];
    }
}