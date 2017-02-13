import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class TestColBody{

    /**
     * For the purposes of redoing the project, the test cases that we focus on are C1, C2, C3, C4, C5
     * C1 is the test case where I am looking for C2/C3/C4/C5 to add its force (if applacable) to it.
     * C2 is used to test NOT touching or moving towards each other (with C1) 
     * C3 is used to test touching but NOT moving towards each other (with C1)
     * C4 is used to test touching and moving towards each other 
     * C5 is used with C4 to test touching and moving towards each other
     * C6 is used with C0 and C1 to test both touching and moving towards each other
     * 
     */


    @Test
	public void testGetXCoord(){
	double delta = 0.00001;

	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	assertEquals(1.0, ca.getXCoord(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(0.0, M.getXCoord(), delta);
	assertEquals(4.0, M1.getXCoord(), delta);

	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
	ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
	ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	assertEquals(0, C1.getXCoord(), delta);
	assertEquals(4, C2.getXCoord(), delta);
	assertEquals(1, C3.getXCoord(), delta);
	assertEquals(1, C4.getXCoord(), delta);
	assertEquals(0, C5.getXCoord(), delta);


    }
    
    @Test
	public void testGetYCoord(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getYCoord(), delta);

	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(0.0, M.getYCoord(), delta);
	assertEquals(4.0, M1.getYCoord(), delta);

	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
	ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

        assertEquals(0, C1.getYCoord(), delta);
        assertEquals(4, C2.getYCoord(), delta);
	assertEquals(1, C3.getYCoord(), delta);
	assertEquals(1, C4.getYCoord(), delta);
	assertEquals(0, C5.getYCoord(), delta);

    }
    
    @Test
	public void testGetXVel(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getXVel(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(0.0, M.getXVel(), delta);
	assertEquals(-1.0, M1.getXVel(), delta);

	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
	ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
	ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	assertEquals(-1, C1.getXVel(), delta);
        assertEquals(1, C2.getXVel(), delta);
	assertEquals(1, C3.getXVel(), delta);
	assertEquals(-1, C4.getXVel(), delta);
	assertEquals(1, C5.getXVel(), delta);

    }
    
    @Test
	public void testGetYVel(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getYVel(), delta);

	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(0.0, M.getYVel(), delta);
	assertEquals(-1.0, M1.getYVel(), delta);


	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

        assertEquals(-1, C1.getYVel(), delta);
        assertEquals(1, C2.getYVel(), delta);
	assertEquals(1, C3.getYVel(), delta);
	assertEquals(-1, C4.getYVel(), delta);
	assertEquals(1, C5.getYVel(), delta);

	
    }
    
    @Test
	public void testGetMass(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, 0.01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getMass(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(100, M.getMass(), delta);
	assertEquals(100, M1.getMass(), delta);
	

	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
	ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);


	assertEquals(10, C1.getMass(), delta);
        assertEquals(10, C2.getMass(), delta);
	assertEquals(10, C3.getMass(), delta);
	assertEquals(10, C4.getMass(), delta);
	assertEquals(10, C5.getMass(), delta);


    }

    @Test
	public void testGetRadius(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, 0.01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(0.01, ca.getRadius(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(3.0, M.getRadius(), delta);
	assertEquals(3.0, M1.getRadius(), delta);
	

	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
	ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	assertEquals(1, C1.getRadius(), delta);
        assertEquals(1, C2.getRadius(), delta);
	assertEquals(1, C3.getRadius(), delta);
	assertEquals(1, C4.getRadius(), delta);
	assertEquals(1, C5.getRadius(), delta);


    }
    
    @Test
	public void testGetRGB(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	int gbr = 0;
	int gbg = 0;
	int gbb = 0;
	int[] rgb = {gbr,gbg,gbb};
	assertArrayEquals(rgb, M.getRGB());
	assertArrayEquals(rgb, M1.getRGB());
    }
    
    @Test
	public void testAddForceFrom(){
	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
	ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	double delta = 0.00001;


	//Testing Not moving towards each other or touching
	assertEquals(-1, C1.getXVel(), delta);
	assertEquals(-1, C1.getYVel(), delta);
	assertEquals(1, C2.getXVel(), delta);
	assertEquals(1, C2.getYVel(), delta);

	C1.addForceFrom(C2);

	assertEquals(0, C1.getChangeInXVelocity(), delta);
	assertEquals(0, C1.getChangeInYVelocity(), delta);


	//Testing Touching BUT NOT moving towards each other
	assertEquals(-1, C1.getXVel(), delta);
	assertEquals(-1, C1.getYVel(), delta);
	assertEquals(1, C3.getXVel(), delta);
	assertEquals(1, C3.getYVel(), delta);
	
	C1.addForceFrom(C3);
	
	assertEquals(0, C1.getChangeInXVelocity(), delta);
        assertEquals(0, C1.getChangeInYVelocity(), delta);



	//Testing Touching and Moving towards each other
	assertEquals(-1, C4.getXVel(), delta);
	assertEquals(-1, C4.getYVel(), delta);
	assertEquals(1, C5.getXVel(), delta);
	assertEquals(1, C5.getYVel(), delta);
	C5.addForceFrom(C4);
	assertEquals(-2, C5.getChangeInXVelocity(), delta);
	assertEquals(-2, C5.getChangeInYVelocity(), delta);


	//Testing Touching and Moving towards each other with 2 bodies acting on 1


	}

    @Test
	public void testMove(){
	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
        ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
	ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	double delta = 0.00001;
	double time = 1;

	//Testing Touching and Moving towards each other                                                                                                                        
        assertEquals(-1, C4.getXVel(), delta);
        assertEquals(-1, C4.getYVel(), delta);
        assertEquals(1, C5.getXVel(), delta);
        assertEquals(1, C5.getYVel(), delta);
        

	C5.addForceFrom(C4);
	C4.addForceFrom(C5);

	assertEquals(-2, C5.getChangeInXVelocity(), delta);
        assertEquals(-2, C5.getChangeInYVelocity(), delta);
	

	C5.move(time);
	C4.move(time);

	assertEquals(-1, C5.getXVel(), delta);                                                                                                                                
        assertEquals(-1, C5.getYVel(), delta);
	assertEquals(1, C4.getXVel(), delta);                                                                                                                                  
        assertEquals(1, C4.getYVel(), delta);


	/*ColBody cbM1 = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
	ColBody cbM = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
	ColBody cbM2 = new ColBody(5, 1, 0, 0, 75, 0.01, 0, 0, 0);
	double time = 1;
	double delta = 1E-11;
	cbM.addForceFrom(cbM1);
	cbM.addForceFrom(cbM2);
	cbM.move(time);
	cbM1.move(time);
	cbM2.move(time);
	assertEquals(1.45976912E-10, cbM.getXCoord(), delta);
	delta = 1E-12;
	assertEquals(6.61938856843E-11, cbM.getYCoord(), delta);
	assertEquals(0, cbM.getXForce(), delta);
	assertEquals(0, cbM.getYForce(), delta);
	assertEquals(0, cbM1.getXForce(), delta);
	assertEquals(0, cbM2.getYForce(), delta);
	assertEquals(0, cbM1.getXForce(), delta);
	assertEquals(0, cbM1.getYForce(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	time = 0.1;
	M.addForceFrom(M1);
	M.move(time);
	delta = 0.001;
	assertEquals(-0.09999999998, M.getXCoord(), delta);
	assertEquals(-0.09999999998, M.getYCoord(), delta);
	assertEquals(0, M.getXForce(), delta);
	assertEquals(0, M.getYForce(), delta);
	assertEquals(0, M1.getXForce(), delta);
	assertEquals(0, M1.getYForce(), delta);*/
    }
    
    @Test
	public void testCalculateDistance(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.01;
	assertEquals(5.65685424949, M.calculateDistance(M1), delta);


	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
        ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
        ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	assertEquals(Math.sqrt(2), C5.calculateDistance(C4), delta);


    }
    @Test
	   public void testIsTouching(){
	   ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	   ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	   assertEquals(true, M.isTouching(M1));

	   ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
	   ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
	   ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
	   ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
	   ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	   ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	   ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	   assertEquals(true, C5.isTouching(C4));

       }
    
    @Test
	public void testIsMovingTowards(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(true, M.isMovingTowards(M1));



	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
        ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
        ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	assertEquals(true, C5.isMovingTowards(C4));
	

    }
    
    @Test
	public void testCalculateDotProduct(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.001;
	assertEquals(-8, M.calculateDotProduct(M1), delta);


	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
        ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
        ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	
	assertEquals(-4, C5.calculateDotProduct(C4), delta);


    }
    
    @Test
	public void testCalculateXVelocity(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.001;
	assertEquals(-1, M.calculateXVelocity(M1), delta);



	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
        ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
        ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	assertEquals(-2, C5.calculateXVelocity(C4), delta);


    }
    
    @Test
	public void testCalculateYVelocity(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.001;
	assertEquals(-1, M.calculateYVelocity(M1), delta);

	ColBody C1 = new ColBody(0, 0, -1, -1, 10, 1, 0, 0, 255);
        ColBody C2 = new ColBody(4, 4, 1, 1, 10, 1, 0, 0, 255);
        ColBody C3 = new ColBody(1, 1, 1, 1, 10, 1, 0, 0, 255);
        ColBody C4 = new ColBody(1, 1, -1, -1, 10, 1, 0, 0, 255);
        ColBody C5 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);
	ColBody C6 = new ColBody(-1, -1, 1, 1, 10, 1, 0, 0, 255);
	ColBody C0 = new ColBody(0, 0, 1, 1, 10, 1, 0, 0, 255);

	assertEquals(-2, C5.calculateYVelocity(C4), delta);


    }
}