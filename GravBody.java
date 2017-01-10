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
    private double totalforce; 
    private double yForce;
    private double xForce;
    private int redC;
    private int blueC;
    private int greenC;

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
	redC = red;
	blueC = blue;
	greenC = green;
    }
    
    // TODO: Implement all methods to satisfy interface
    public double getXCoord() {
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
	return 100;
    }

    public int[] getRGB(){
	return rgb;
    }
    
    public int getRed(){
	return redC;
    }
    
    public int getBlue(){
	return blueC;
    }

    public int getGreen(){
	return greenC; 
    }

    public double getMass(){
	return mass; 
    }

    public void addForceFrom(Body otherBody){
	xForce = xForce + this.calculateXForce(otherBody);
	yForce = yForce + this.calculateYForce(otherBody);
    }
    
    public double getXForce(){
	return xForce; 
    }
    
    public double getYForce(){
	return yForce;
    }

    public void move(double timeDelta){
	xVelocity = xVelocity + (timeDelta * calculateXAccel()); //this calculates the new velocity not coordinate but calculate that here since we have time. Then use that and take time and multiple and store in xCoord
	//Use force and get Velocity to move the cordinate.
	yVelocity = yVelocity + (timeDelta * calculateYAccel());
	xCoordinate = xCoordinate + (timeDelta * xVelocity);
	yCoordinate = yCoordinate + (timeDelta * yVelocity);
	xForce = 0;                                                                                                                       
        yForce = 0;
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
	if((b.getXCoord() == this.xCoordinate) && this.xCoordinate >= 0){
		return 0;
	}
	return Math.atan(Math.abs(b.getYCoord() - this.yCoordinate)/ Math.abs(b.getXCoord() - this.xCoordinate));
    }

    public double calculateXForce(Body b){
	int direction = 1;
	if(b.getXCoord() < this.getXCoord()){
	    direction = -1;
	}
	xForce = direction * (calculateTotalForce(b) * Math.cos(getAngle(b))); //Change Name
	return xForce; 
    }//Use instance variable of xForce same for y, that way you call it for acceleration
 
   public double calculateYForce(Body b){
       int direction = 1;
       if(b.getYCoord() < this.getYCoord()){
	   direction = -1;
       }

       yForce = direction * (calculateTotalForce(b) * Math.sin(getAngle(b))); //Change
       return yForce; 
   }

    public double calculateXAccel(){
	if(getMass() == 0){
	    return 0;//check getXForce!!!
	}
	return (xForce/getMass());
    }

    public double calculateYAccel(){
	if(getMass() == 0){
            return 0;
	}
	return (yForce/getMass());
    }

    /*  public double changeVelocity(Body b){
	xVelocity = getVelocity()+ ///this is what you were trying to do above. You do not need it ! remove it! 
    }*/


    public String toString(){
	return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + " RGB: " + rgb[0] + " " + rgb[1] + " " + rgb[2];
    }
    // TODO: Implment any additional methods for testing (i.e. methods
    // not listed on the Body interface). Look at TestGravBody for ideas
    // of helper methods you might need.
}