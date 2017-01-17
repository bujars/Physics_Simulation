import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


//Make sure that delta is always one less that the actual value if its E-

public class TestColBody{

    public void testGetXCoord(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getXCoord(), delta);
    }

    public void testGetYCoord(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getYCoord(), delta);
    }
    
    public void testGetXVel(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getXVel(), delta);
    }

    public void testGetYVel(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getYVel(), delta);
    }
    
    public void testGetMass(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getMass(), delta);
    }

    public void testGetRadius(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(0.1, ca.getRadius(), delta);
    }
    
    public void testGetRGB(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
        double delta = 0.00001;
	int[] rgb = new int[]{ca[6], ca[7], ca[8]};
	assertArrayEqauals(rgb, ca.getRGB());
    }
    
    public void testAddForceFrom(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	ColBody cb = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
        double delta = 0.00001;
        ca.addForceFrom(cb);
	assertEquals(0, ca.getXForce(), delta);
	assertEquals(0, ca.getYForce(), delta);
    }

    public void testMove(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	ColBody cb = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
        double delta = 0.00001;
	ca.addForceFrom(cb);
	ca.move(1);
	cb.move(1);
	assertEquals(0, ca.getXForce(), delta);
	assertEquals(0, ca.getYForce(), delta);
    }
    
    public void testGetXForce(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	
    }
    
    public void testGetYForce(){

    }
    
    public void testCalculateTotalForce(){

    }
    
    public void testGetDistance(){

    }

    public void testAngle(){

    }
    
    public void testCalculateXForce(){

    }

    public void testCalculateYForce(){

    }

    public void testCalculateXAccel(){

    }

    public void testCalculateYAccel(){

    }

    public void testAreBodiesTouching(){

    }
    
    public void testAreBodiesMoving(){

    }
    
    public void testCalculateDotProduct(){

    }

    public void testCalculateXVelocity(){

    }

    public void testCalculateYVelocity(){

    }
}