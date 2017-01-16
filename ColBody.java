public class ColBody implements Body{

    private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    private double radius;
    private int[] rgb;
    private double mass;
    private double xForce;
    private double yForce;


    public ColBody(double xCoord, double yCoord, double xVel, double yVel, double m, double r, int red, int green, int blue){
	xCoordinate = xCoord;
	yCoordinate = yCoord;
	xVelocity = xVel;
	yVelocity = yVel;
	mass = m;
	radius = r;
	rgb = new int[]{red, green, blue};
    }

    public double getXCoord(){
	return xCoordinate;
    }

    public double getYCoord(){
	return yCoordinate;
    }

    public double getXVel(){
	return xVelocity;
    }

    public double getYVel(){
	return yVelocity;
    }

    public double getRadius(){
	return radius;
    }

    public int[] getRGB(){
	int[] rgb = new int[]{0, 0, 0};
	return rgb;
    }

    public double getMass(){
	return mass;
    }

    public void addForceFrom(Body otherBody){
	xForce = xForce + this.calculateXForce(otherBody);
        yForce = yForce + this.calculateYForce(otherBody);
	if(areBodiesTouching(otherBody) && areBodiesMoving(otherBody)){
	    xVelocity = xVelocity + calculateXVelocity(otherBody);
	    yVelocity = yVelocity + calculateYVelocity(otherBody); 
	}
    }

    public void move(double timeDelta){
	xVelocity = xVelocity + (timeDelta * calculateXAccel()); 
	yVelocity = yVelocity + (timeDelta * calculateYAccel());
	xCoordinate = xCoordinate + (timeDelta * xVelocity);
	yCoordinate = yCoordinate + (timeDelta * yVelocity);
	xForce = 0;
	yForce = 0;
    }
    
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

    public double getDistance(Body b){
        return Math.hypot(b.getXCoord() - this.xCoordinate, b.getYCoord() - this.yCoordinate);
    }

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

    public boolean areBodiesTouching(Body otherBody){
	boolean touching = false;
	if((getDistance(otherBody) <= (this.radius + otherBody.getRadius()))){
	    touching = true; 
	    }  
	return touching;
    }
    
    public boolean areBodiesMoving(Body otherBody){
	boolean moving = false;
	if(calculateDotProduct(otherBody) < 0){
	    moving = true;
	}//the dot product of the relative difference in the bodies' positions and the relative difference in the bodies' velocities is negative.
	return moving; 
    }
    
    public double calculateDotProduct(Body otherBody){
	double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
	double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
	double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
	double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
	return ((deltaXPosition) * (deltaXVelocity))+ ((deltaYPosition) * (deltaYVelocity));
    }

    public double calculateXVelocity(Body otherBody){
	double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
	double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
	double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
	double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
	return ( (2 * (otherBody.getMass())) / ((this.mass) + (otherBody.getMass()) ) ) * (deltaXPosition) * ( (calculateDotProduct(otherBody))/ (((deltaXPosition) * (deltaXPosition)) + ((deltaYPosition) * (deltaYPosition)) ));
    }

    public double calculateYVelocity(Body otherBody){
        double deltaXPosition = otherBody.getXCoord() - this.xCoordinate;
        double deltaYPosition = otherBody.getYCoord() - this.yCoordinate;
        double deltaXVelocity = otherBody.getXVel() - this.xVelocity;
        double deltaYVelocity = otherBody.getYVel() - this.yVelocity;
	return ( (2 * (otherBody.getMass())) / ((this.mass) + (otherBody.getMass()) ) ) * (deltaYPosition) * ( (calculateDotProduct(otherBody))/ (((deltaXPosition) * (deltaXPosition)) + ((deltaYPosition) * (deltaYPosition)) ));
    }

    public String toString(){
        return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + " Mass: " + mass + " Radius: " + radius +  " RGB: " + rgb[0] + " " + rgb[1] + " " + rgb[2];
    }
}