/**
 * Class for representating two dimensional circular bodies for
 * physics simulations
 * @author Bujar Sefa
 * @version 1.0
 */
public class GravBody implements Body{

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
	return -1;
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
	xVelocity = xVelocity + (timeDelta * calculateXAccel());
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
	if(this.mass == 0){
	    return 0;
	}
	return (this.xForce/this.mass);
    }

    public double calculateYAccel(){
	if(this.mass == 0){
            return 0;
	}
	return (this.yForce/this.mass);
    }

    public String toString(){
	return "XCoord: " + xCoordinate +" YCoord: " + yCoordinate + " XVeloc: " + xVelocity + " YVeloc: " + yVelocity + " Mass: " + mass + " RGB: " + rgb[0] + " " + rgb[1] + " " + rgb[2];
    }
}