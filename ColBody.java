public class ColBody implements Body{

    private double xCoordinate;
    private double yCoordinate;
    private double xVelocity;
    private double yVelocity;
    private double radius;
    private int[] rgb;
    private double mass;

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

    }
    public void move(double timeDelta){

    }

}