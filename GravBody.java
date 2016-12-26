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
	//return new int[]{0,0,0};
	return rgb;
    }
    public double getMass()
    {
	return mass; 
    }
    public void addForceFrom(Body otherBody)
    {

    }
    public void move(double timeDelta)
    {

    }
    /*public double getForce()
    {
	force = 0;
	return 0; 
    }
    public double getDistance(GravBody b)
    {
	int distance = Math.sqrt((b.getYCoord() - this. getYCoord())+(b.getXCoord() - this.getXCoord()));
	return distance; 
	}*/
    // TODO: Implment any additional methods for testing (i.e. methods
    // not listed on the Body interface). Look at TestGravBody for ideas
    // of helper methods you might need.
}