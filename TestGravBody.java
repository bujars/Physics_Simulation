import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TestGravBody {
    
    @Test
    public void testGetXCoord() {
	GravBody gb = new GravBody(1.0, 1.0, 1.0, 1.0, 1.0, 1, 1, 1);
 	GravBody gc = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
	GravBody gd = new GravBody(2.95365, 1.52308, -3.24931, 6.34897, 5.96676, 255, 255, 0);
        GravBody ge = new GravBody(-1.0, -1.0, -1.0, -1.0, -1.0, -1, -1, -1);
	GravBody gf = new GravBody(100.0, 100.0, 100.0, 100.0, 100.0, 100, 100, 100);

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

	assertEquals(1, gb.getXCoord(), delta);
	assertEquals(0, gc.getXCoord(), delta);
	assertEquals(2.95365, gd.getXCoord(), delta);
	assertEquals(-1.0, ge.getXCoord(), delta);
	assertEquals(100, gf.getXCoord(), delta);
    }


    @Test
	public void testGetYCoord() {
	GravBody gb = new GravBody(1.0, 1.0, 1.0, 1.0, 1.0, 1, 1, 1);
        GravBody gc = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        GravBody gd = new GravBody(2.95365, 1.52308, -3.24931, 6.34897, 5.96676, 255, 255, 0);
        GravBody ge = new GravBody(-1.0, -1.0, -1.0, -1.0, -1.0, -1, -1, -1);
        GravBody gf = new GravBody(100.0, 100.0, 100.0, 100.0, 100.0, 100, 100, 100);
        // constructor that sets the y-value to you like
	
	double delta = 0.00001;
	// TODO: assert that gb.getYCoord() returns the y-value you picked in
	// the constructor. This is exactly like testGetXCoord() above.
	
	assertEquals(1, gb.getYCoord(), delta);
        assertEquals(0, gc.getYCoord(), delta);
        assertEquals(1.52308, gd.getYCoord(), delta);
        assertEquals(-1, ge.getYCoord(), delta);
        assertEquals(100, gf.getYCoord(), delta);
    }

    // TODO: Add a test for getXVel
    @Test
	public void testGetXVel() {
	//Basic Implementation that I added - BUBU
	GravBody gb = new GravBody(1, 1, 1, 1, 1, 1, 1, 1);
        GravBody gc = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        GravBody gd = new GravBody(2.95365, 1.52308, -3.24931, 6.34897, 5.96676, 255, 255, 0);
        GravBody ge = new GravBody(-1, -1, -1, -1, -1, -1, -1, -1);
        GravBody gf = new GravBody(100, 100, 100, 100, 100, 100, 100, 100);
	
	double delta = 0.00001;
	
	assertEquals(1, gb.getXVel(), delta);
	assertEquals(0, gc.getXVel(), delta);
	assertEquals(-3.24931, gd.getXVel(), delta);
        assertEquals(-1, ge.getXVel(), delta);
	assertEquals(100, gf.getXVel(), delta);
    }

    // TODO: Add a test for getYVel
    @Test
	public void testGetYVel() {
        //Basic Implementation that I added - BUBU                              
	GravBody gb = new GravBody(1, 1, 1, 1, 1, 1, 1, 1);
        GravBody gc = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        GravBody gd = new GravBody(2.95365, 1.52308, -3.24931, 6.34897, 5.96676, 255, 255, 0);
        GravBody ge = new GravBody(-1, -1, -1, -1, -1, -1, -1, -1);
        GravBody gf = new GravBody(100, 100, 100, 100, 100, 100, 100, 100);
        
	double delta = 0.00001;
	
	assertEquals(1, gb.getYVel(), delta);
        assertEquals(0, gc.getYVel(), delta);
        assertEquals(6.34897, gd.getYVel(), delta);
        assertEquals(-1, ge.getYVel(), delta);
        assertEquals(100, gf.getYVel(), delta);


    }

    
    // TODO: Add a test for getRadius
    @Test
    public void testGetRadius() {
        //Basic Implementation that I added - BUBU
        GravBody gb = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        double delta = 0.00001;
        assertEquals(0, gb.getRadius(), delta);

    }
    /*    
    // TODO: Add a test for getRGB
    @Test
    public void testGetRGB() {                              
        //**Pull out each value, and then check if those values are equal//
	GravBody gb = new GravBody(1, 1, 1, 1, 1, 1, 1, 1);
        GravBody gc = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        GravBody gd = new GravBody(2.95365, 1.52308, -3.24931, 6.34897, 5.96676, 255, 255, 0);
        GravBody ge = new GravBody(-1, -1, -1, -1, -1, -1, -1, -1);
        GravBody gf = new GravBody(100, 100, 100, 100, 100, 100, 100, 100);
        //double delta = 0.00001;


    }*/
    
    // TODO: Add a test for getMass
    @Test
	public void testGetMass() {
	//Basic Implementation that I added - BUBU                              
	GravBody gb = new GravBody(1, 1, 1, 1, 1, 1, 1, 1);
        GravBody gc = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        GravBody gd = new GravBody(2.95365, 1.52308, -3.24931, 6.34897, 5.96676, 255, 255, 0);
        GravBody ge = new GravBody(-1, -1, -1, -1, -1, -1, -1, -1);
        GravBody gf = new GravBody(100, 100, 100, 100, 100, 100, 100, 100);

	double delta = 0.00001;

	assertEquals(1, gb.getMass(), delta);
	assertEquals(0, gc.getMass(), delta);
	assertEquals(5.96676, gd.getMass(), delta);
        assertEquals(-1, ge.getMass(), delta);
	assertEquals(100, gf.getMass(), delta);

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