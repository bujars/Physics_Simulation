/**
 * Class for representating two dimensional circular bodies for
 * physics simulations
 * @author Sean Stern
 * @version 1.0
 */
public class GravBody implements Body{

    // TODO: Add appropriate instance variables
    private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    private int[] rgb;
    private double mass;
    private double force; 

    // TODO: Add a constructor to initialize instance variables
    public GravBody(){
	xCoordinate = 0;
	yCoordinate = 0;
	xVelocity = 0;
	yVelocity = 0; 
	rgb = new int[]{0, 0, 0};
	mass = 0;
    }
    public GravBody(double xCoord, double yCoord, double xVel, double yVel, double m, int red, int green, int blue){
	xCoordinate = xCoord;
	yCoordinate = yCoord;
	xVelocity = xVel;
	yVelocity = yVel;
	mass = m;
	rgb = new int[]{red, green, blue};	
	//NEED TO IMPLEMENT THESE INTO INSTANCE VARIABLES POSSIBLY
    }
    
    // TODO: Implement all methods to satisfy interface
    public double getXCoord()
    {
	return xCoordinate;
    }
    public double getYCoord()
    {
	return yCoordinate;
    }
    public double getXVel()
    {
	return xVelocity;
    }
    public double getYVel()
    {
	return yVelocity;
    }
    public double getRadius()
    {
	return 0;
    }
    public int[] getRGB()
    {
	return rgb;
    }
    public double getMass()
    {
	return mass; 
    }
    public void addForceFrom(Body otherBody)
    {
	xVelocity = xVelocity + getXAccel(otherBody);
	yVelocity = yVelocity + getYAccel(otherBody);
    }
    public void move(double timeDelta)
    {
	xCoordinate = xCoordinate + (timeDelta * xVelocity);
	yCoordinate = yCoordinate + (timeDelta * yVelocity);
    }
    public double getForce(Body b)
    {
	if(getDistance(b) == 0)
	    {
		return 0; 
	    }
	double g = 6.67E-11;
	double fg = ((g)*(b.getMass())*(this.getMass()))/((getDistance(b))*(getDistance(b)));
	return fg; 
    }
    public double getDistance(Body b)
    {
	double distance = Math.hypot(b.getXCoord() - this.getXCoord(), b.getYCoord() - this.getYCoord());
	return distance; 
    }
    public double getAngle(Body b)
    {
	if((b.getYCoord() == this.getYCoord()) && this.getYCoord() >= 0)
	    {
		return 0;
	    }
	double angle = Math.atan((b.getXCoord() - this.getXCoord())/ (b.getYCoord() - this.getYCoord()));
	return angle; 
    }
    public double getXForce(Body b)
    {
	double xf = getForce(b) * Math.cos(getAngle(b));
	return xf;
    }
    public double getYForce(Body b)
    {
	double yf = getForce(b) * Math.sin(getAngle(b));
	return yf;
    }
    public double getXAccel(Body b)
    {
	if(getMass() == 0){
	    return 0;
	}
	return (getXForce(b)/getMass());
    }
    public double getYAccel(Body b)
    {
	if(getMass() == 0){
            return 0;
	}
	return (getYForce(b)/getMass());
    }

    public String toString()
    {
	return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + " RGB: " + rgb[0] + " " + rgb[1] + " " + rgb[2];
    }
    // TODO: Implment any additional methods for testing (i.e. methods
    // not listed on the Body interface). Look at TestGravBody for ideas
    // of helper methods you might need.
}