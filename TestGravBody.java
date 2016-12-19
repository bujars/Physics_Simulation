import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGravBody {
    
    @Test
    public void testGetXCoord() {
	GravBody gb = new GravBody(); // TODO: Replace null w/ call to GravBody cons

	// It is NEVER a good idea to check if floating point numbers are
        // ==. To represent floating point numbers using binary, the
	// computer must ROUND when it does math. 
	// For example, System.out.println(0.7 + 0.1 == 0.9 - 0.1);
	// will print false.
	//
	// Instead, it's a good idea to see if floating point numbers are
	// really really CLOSE. So we need to specify how close they should
        // be to basically count as equal. That's this number below:
	double delta = 0.00001;

	assertEquals(1986.1203, gb.getXCoord(), delta);
    }


    @Test
    public void testGetYCoord() {
	GravBody gb = new GravBody(); // TODO: Replace null with call to GravBody
	                    // constructor that sets the y-value to you like

	double delta = 0.00001;

	// TODO: assert that gb.getYCoord() returns the y-value you picked in
	// the constructor. This is exactly like testGetXCoord() above.
	assertEquals(1986.1203, gb.getYCoord(),delta);
    }

    // TODO: Add a test for getXVel
    @Test
    public void testGetXVel() {
	//Basic Implementation that I added - BUBU
	GravBody gb = new GravBody();
	double delta = 0.00001;
	assertEquals(1986.1203, gb.getXVel(), delta);
    }

    // TODO: Add a test for getYVel
    @Test
    public void testGetYVel() {
        //Basic Implementation that I added - BUBU                              
        GravBody gb = new GravBody();
        double delta = 0.00001;
        assertEquals(1986.1203, gb.getYVel(), delta);
    }

    // TODO: Add a test for getRadius
    @Test
    public void testGetRadius() {
        //Basic Implementation that I added - BUBU                              
        GravBody gb = new GravBody();
        double delta = 0.00001;
        assertEquals(1986.1203, gb.getRadius(), delta);
    }

    // TODO: Add a test for getRGB
    @Test
    public void testGetRGB() {
        //Basic Implementation that I added - BUBU                              
        GravBody gb = new GravBody();
        //double delta = 0.00001;
        int r = 1;
	int g = 2;
	int b = 3;
	int[] ex = new int[3];
	int[] what = {1,2,3};
	assertEquals(what, gb.getRGB());
    }
    
    // TODO: Add a test for getMass
    @Test
    public void testGetMass() {
	    //Basic Implementation that I added - BUBU                              
	    GravBody gb = new GravBody();
	    double delta = 0.00001;
	    assertEquals(1986.1203, gb.getMass(), delta);
	}
   
    @Test
    public void testAddForceFrom(){
	// HINT: The physics coursework/homework you did is helpful here

	GravBody gbA = new GravBody(); // TODO: Replace null w/ call to GravBody cons
	GravBody gbB = new GravBody(); // TODO: Replace null w/ a call to GravBody cons
	GravBody gbC = new GravBody(); // TODO: Replace null w/ a call to GravBody cons
	              

	// TODO: Assert that the x and y component of force on gbA are 0
	// HINT: There's no method on the Body to get the forces--but gbA is
	// a GravBody. So you can add methods to gravBody that isnt' on the
	// interface to get the forces you need solely for testing purposes.

	gbA.addForceFrom(gbB);
	gbA.addForceFrom(gbC);

	// TODO: Assert that the x and y components of force on gbA are correct


	// TODO: Assert that the x and y components of force on gbB are 0

	gbB.addForceFrom(gbA);
	gbB.addForceFrom(gbC);

	// TODO: Assert that x and y components of force on gbB are correct

	
	// TODO: Write test ensuring that forces can be calculated correctly
	// for gbC
	// HINT: It's the same as the last two test cases you wrote.
    }

    @Test
    public void testMove(){
	// HINT: The physics coursework/homework you did her is helpful.

	// TODO: Create 3 GravBody objects

	// TODO: For each GravBody object, add force from other two
	
	// TODO: Move each GravBody object for some time delta

	// TODO: For each GravBody object, assert that new x and y coordinates
	// are correct after movement

	// TODO: For each GravBody object, assert that x and y components of
	// force are now 0

	
	// TODO: Repeat the above process on the same 3 GravBody objects once
	// more.
    }

    
}