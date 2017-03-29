import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestBoid {

    /*@Test
    public void testGetXCoord(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
	Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
	Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
	Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1; 

	assertEquals(0, b0.getXCoord(), delta);
	assertEquals(3, b1.getXCoord(), delta);
	assertEquals(1, b2.getXCoord(), delta);
	assertEquals(-1, b3.getXCoord(), delta);

    }

    @Test
	public void testGetYCoord() {
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;
 
	assertEquals(0, b0.getYCoord(), delta);
	assertEquals(2, b1.getYCoord(), delta);
	assertEquals(4, b2.getYCoord(), delta);
	assertEquals(2, b3.getYCoord(), delta);
	}*/


    @Test
	public void testGetPosition(){
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
	Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
	Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
	Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0); 
	double delta = 0.1; 

	Vector2D b00 = new Vector2D(0.0, 0.0);
	Vector2D b01 = new Vector2D(3.0, 2.0);
	Vector2D actual0 = b0.getPosition();
	Vector2D expect0 = b00;
	Vector2D actual1 = b1.getPosition();
	Vector2D expect1 = b01;
	
	String msg0 = "Actual: " + actual0 + "\n" + "is not close to\n" + "Expected: " + expect0;
	String msg1 = "Actual: " + actual1 + "\n" + "is not close to\n" + "Expected: " + expect1;
	assertTrue(msg0, actual0.isCloseTo(expect0, 1E-10));
	assertTrue(msg1, actual1.isCloseTo(expect1, 1E-10));



	/*	    assertEquals(b00, b0.getPosition());
	assertEquals(b01, b1.getPosition());*/

    }

    /* @Test
	public void testGetXVel() {
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;
	
	assertEquals(0, b0.getXVel(), delta);
	assertEquals(-2, b1.getXVel(), delta);
	assertEquals(-3, b2.getXVel(), delta);
	assertEquals(-1, b3.getXVel(), delta);
    }

    @Test
	public void testGetYVel() {
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;
    
	assertEquals(1, b0.getYVel(), delta);
	assertEquals(0, b1.getYVel(), delta);
	assertEquals(-3, b2.getYVel(), delta);
	assertEquals(1, b3.getYVel(), delta);

	}*/

    @Test
	public void testGetVelocity(){
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
        double delta = 0.1;

        Vector2D b00 = new Vector2D(0.0, 1.0);
        Vector2D b01 = new Vector2D(-2.0, 0.0);
        Vector2D actual0 = b0.getVelocity();
        Vector2D expect0 = b00;
        Vector2D actual1 = b1.getVelocity();
        Vector2D expect1 = b01;

        String msg0 = "Actual: " + actual0 + "\n" + "is not close to\n" + "Expected: " + expect0;
        String msg1 = "Actual: " + actual1 + "\n" + "is not close to\n" + "Expected: " + expect1;
        assertTrue(msg0, actual0.isCloseTo(expect0, 1E-10));
        assertTrue(msg1, actual1.isCloseTo(expect1, 1E-10));
    }


    /*
    @Test
	public void testGetRadius() {
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;
	
	assertEquals(5, b0.getRadius(), delta);
	assertEquals(4.1, b1.getRadius(), delta);
	assertEquals(5, b2.getRadius(), delta);
	assertEquals(5, b3.getRadius(), delta);
    }

    @Test
	public void testGetRGB() {
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;

	int gbr = 255;
	int gbg = 255;
	int gbb = 255;
	int[] rgb = new int[]{gbr, gbg, gbb};
	assertArrayEquals(rgb, b0.getRGB());
	gbr = 0;
	gbg = 0;
	rgb = new int[]{gbr, gbg, gbb};
	assertArrayEquals(rgb, b1.getRGB());
	gbr = 255;
	gbb = 0;
	rgb = new int[]{gbr, gbg, gbb};
	assertArrayEquals(rgb, b2.getRGB());
	gbr = 0;
	gbg = 255;
	rgb = new int[]{gbr, gbg, gbb};
	assertArrayEquals(rgb, b3.getRGB());
    }
    
    
    @Test
	public void testGetMass() {
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;
	}*/
    
    @Test
	public void testAddForceFrom(){
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
        double delta = 1E-4;

	Vector2D expCo = null;
	Vector2D expSep = null;
	Vector2D expAli = null;

	b0.addForceFrom(b1);
	expCo = new Vector2D(3.0, 2.0);
	expSep = new Vector2D(-0.23077, -0.15385);
	expAli = new Vector2D(-2.0, 0.0);
	String msgCo0 = "Actual: " + b0.getCurCohesionForce() + "\n" + "is not close to\n" + "Expected: " + expCo;
	String msgSep0 = "Actual: " + b0.getCurSeparationForce() + "\n" + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgCo0, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep0, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	/*assertTrue(msg, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b2);
	expCo = new Vector2D(2.0, 3.0);
	expSep = new Vector2D(-0.14480, -0.19457);
	expAli = new Vector2D(-2.5, -1.5);
	assertTrue(msg, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msg, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msg, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b3);
	expCo = new Vector2D(1.0, 2.66667);
	expSep = new Vector2D(-0.02986, -0.26305);
	expAli = new Vector2D(-2.0, -0.66667);
	assertTrue(msg, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msg, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msg, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	*/
    }



    /*
    @Test
	public void testAddForceFrom(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;


	b0.addForceFrom(b1);
	delta = 0.1;
	assertEquals(3.0, b0.getCurXCohesionForce(), delta);
	delta = 0.1;
	assertEquals(2.0, b0.getCurYCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(-0.23077, b0.getCurXSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(-0.15385, b0.getCurYSeparationForce(), delta);
	delta = 0.1;
	assertEquals(-2.0, b0.getCurXAlignmentForce(), delta);
	delta = 0.1;
	assertEquals(0.0, b0.getCurYAlignmentForce(), delta);

	b0.addForceFrom(b2);
	delta = 0.1;
	assertEquals(2.0, b0.getCurXCohesionForce(), delta);
	delta = 0.1;
	assertEquals(3.0, b0.getCurYCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(-0.14480, b0.getCurXSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(-0.19457, b0.getCurYSeparationForce(), delta);
	delta = 0.1;
	assertEquals(-2.5, b0.getCurXAlignmentForce(), delta);
	delta = 0.1;
	assertEquals(-1.5, b0.getCurYAlignmentForce(), delta);

	b0.addForceFrom(b3);
	delta = 0.1;
	assertEquals(1.0, b0.getCurXCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(2.66667, b0.getCurYCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(-0.02986, b0.getCurXSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(-0.26305, b0.getCurYSeparationForce(), delta);
	delta = 0.1;
	assertEquals(-2.0, b0.getCurXAlignmentForce(), delta);
	delta = 0.00001;
	assertEquals(-0.66667, b0.getCurYAlignmentForce(), delta);
	

	b1.addForceFrom(b0);
	delta = 0.1;
	assertEquals(-3.0, b1.getCurXCohesionForce(), delta);
	delta = 0.1;
	assertEquals(-2.0, b1.getCurYCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(0.23077, b1.getCurXSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(0.15385, b1.getCurYSeparationForce(), delta);
	delta = 0.1;
	assertEquals(0.0, b1.getCurXAlignmentForce(), delta);
	delta = 0.1;
	assertEquals(1.0, b1.getCurYAlignmentForce(), delta);
	
	b1.addForceFrom(b2);
	delta = 0.1;
	assertEquals(-2.5, b1.getCurXCohesionForce(), delta);
	delta = 0.1;
	assertEquals(0.0, b1.getCurYCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(0.24038, b1.getCurXSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(-0.04808, b1.getCurYSeparationForce(), delta);
	delta = 0.1;
	assertEquals(-1.5, b1.getCurXAlignmentForce(), delta);
	delta = 0.1;
	assertEquals(-1.0, b1.getCurYAlignmentForce(), delta);

	b1.addForceFrom(b3);
	delta = 0.1;
	assertEquals(-3.0, b1.getCurXCohesionForce(), delta);
	delta = 0.1;
	assertEquals(0.0, b1.getCurYCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(0.24359, b1.getCurXSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(-0.03205, b1.getCurYSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(-1.33333, b1.getCurXAlignmentForce(), delta);
	delta = 0.00001; 
	assertEquals(-0.33333, b1.getCurYAlignmentForce(), delta);




	b0 = new Boid(0, 0, 0, 1, 2, 255, 255, 255);
	b1 = new Boid(3, 2, -2, 0, 2, 0, 0, 255);
	b2 = new Boid(1, 4, -3, -3, 2, 255, 0, 0);
	b3 = new Boid(-1, 2, -1, 1, 2, 0, 255, 0);
	
	
	b0.addForceFrom(b1);
	assertEquals(0.0, b0.getCurXCohesionForce(), delta);
	assertEquals(0.0, b0.getCurYCohesionForce(), delta);
	assertEquals(0.0, b0.getCurXSeparationForce(), delta);
	assertEquals(0.0, b0.getCurYSeparationForce(), delta);
	assertEquals(0.0, b0.getCurXAlignmentForce(), delta);
	assertEquals(0.0, b0.getCurYAlignmentForce(), delta);

	b0.addForceFrom(b2);
	assertEquals(0.0, b0.getCurXCohesionForce(), delta);
	assertEquals(0.0, b0.getCurYCohesionForce(), delta);
	assertEquals(0.0, b0.getCurXSeparationForce(), delta);
	assertEquals(0.0, b0.getCurYSeparationForce(), delta);
	assertEquals(0.0, b0.getCurXAlignmentForce(), delta);
	assertEquals(0.0, b0.getCurYAlignmentForce(), delta);

	b0.addForceFrom(b3);
	assertEquals(0.0, b0.getCurXCohesionForce(), delta);
	assertEquals(0.0, b0.getCurYCohesionForce(), delta);
	assertEquals(0.0, b0.getCurXSeparationForce(), delta);
	assertEquals(0.0, b0.getCurYSeparationForce(), delta);
	assertEquals(0.0, b0.getCurXAlignmentForce(), delta);
	assertEquals(0.0, b0.getCurYAlignmentForce(), delta);
	
	
	b1.addForceFrom(b0);
	assertEquals(0.0, b1.getCurXCohesionForce(), delta);
	assertEquals(0.0, b1.getCurYCohesionForce(), delta);
	assertEquals(0.0, b1.getCurXSeparationForce(), delta);
	assertEquals(0.0, b1.getCurYSeparationForce(), delta);
	assertEquals(0.0, b1.getCurXAlignmentForce(), delta);
	assertEquals(0.0, b1.getCurYAlignmentForce(), delta);
	
	b1.addForceFrom(b2);
	assertEquals(0.0, b1.getCurXCohesionForce(), delta);
	assertEquals(0.0, b1.getCurYCohesionForce(), delta);
	assertEquals(0.0, b1.getCurXSeparationForce(), delta);
	assertEquals(0.0, b1.getCurYSeparationForce(), delta);
	assertEquals(0.0, b1.getCurXAlignmentForce(), delta);
	assertEquals(0.0, b1.getCurYAlignmentForce(), delta);
	
	b1.addForceFrom(b3);
	assertEquals(0.0, b1.getCurXCohesionForce(), delta);
	assertEquals(0.0, b1.getCurYCohesionForce(), delta);
	assertEquals(0.0, b1.getCurXSeparationForce(), delta);
	assertEquals(0.0, b1.getCurYSeparationForce(), delta);
	assertEquals(0.0, b1.getCurXAlignmentForce(), delta);
	assertEquals(0.0, b1.getCurYAlignmentForce(), delta);

    }

   @Test
       public void testAddCohesionForceFrom(){
       Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
       Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
       Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
       Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
       double delta = 0.1;


       b0.addCohesionForceFrom(b1);
       b0.addCohesionForceFrom(b2);
       b0.addCohesionForceFrom(b3);

       assertEquals(3, b0.getSumOfNeighborsX(), delta);
       assertEquals(8, b0.getSumOfNeighborsY(), delta);


   }
    
    @Test
	public void testMove(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.0001;
	double timeDelta = 10;
	
	b0.addForceFrom(b1);
	b0.addForceFrom(b2);
	b0.addForceFrom(b3);

	b1.addForceFrom(b0);
	b1.addForceFrom(b2);
	b1.addForceFrom(b3);

	//Big Radii
	b0.move(timeDelta);
	b1.move(timeDelta);

	//b0
	assertEquals(-0.3432, b0.getXVel(), delta);
	assertEquals(1.5789, b0.getYVel(), delta);
	
	assertEquals(-3.4328, b0.getXCoord(), delta);
	assertEquals(15.7898, b0.getYCoord(), delta);
    
	//b1
	assertEquals(-3.3632, b1.getXVel(), delta);
	assertEquals(-0.1217, b1.getYVel(), delta);
	
	assertEquals(-30.6324, b1.getXCoord(), delta);
	assertEquals(0.7820, b1.getYCoord(), delta);


	b0 = new Boid(0, 0, 0, 1, 2, 255, 255, 255);
	b1 = new Boid(3, 2, -2, 0, 2, 0, 0, 255);
        b2 = new Boid(1, 4, -3, -3, 2, 255, 0, 0);
        b3 = new Boid(-1, 2, -1, 1, 2, 0, 255, 0);

	b0.addForceFrom(b1);
        b0.addForceFrom(b2);
        b0.addForceFrom(b3);

        b1.addForceFrom(b0);
        b1.addForceFrom(b2);
        b1.addForceFrom(b3);
	
	
	//Small Radii
	b0.move(timeDelta);
	b1.move(timeDelta);

	//b0
	assertEquals(0, b0.getXVel(), delta);
	assertEquals(1, b0.getYVel(), delta);

	assertEquals(0, b0.getXCoord(), delta);
	assertEquals(10, b0.getYCoord(), delta);

	//b1
	assertEquals(-2, b1.getXVel(), delta);
	assertEquals(0, b1.getYVel(), delta);
	
	assertEquals(-17, b1.getXCoord(), delta);
	assertEquals(2, b1.getYCoord(), delta);


    }

    @Test
	public void testGetSumOfNeighborsX(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.0001;

	//Since we didnt add anything, sum should be zero
	assertEquals(0, b0.getSumOfNeighborsX(), delta);
    }
    
    @Test
	public void testGetSumOfNeighborsY(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.0001;

	//Since we didnt add anything, sum should be zero                                               
        assertEquals(0, b0.getSumOfNeighborsY(), delta);
    }

    @Test
	public void testGetSumOfXVelocities(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.0001;
    
	//Nothing added to variable   
	assertEquals(0, b0.getSumOfNeighborsVelX(), delta);
    }
    
    @Test
	public void testGetSumOfYVelocities(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.0001;

	//Nothing added to variable
	assertEquals(0, b0.getSumOfNeighborsVelY(), delta);
    }
    
    @Test
	public void testAddAlignmentForceFrom(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.0001;

	b0.addAlignmentForceFrom(b1);
	b0.addAlignmentForceFrom(b2);
	b0.addAlignmentForceFrom(b3);
	
	assertEquals(-6, b0.getSumOfNeighborsVelX(), delta);
	assertEquals(-2, b0.getSumOfNeighborsVelY(), delta);
    }

    @Test 
	public void testAddSeparationForceFrom(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.00001;
   
	b0.addSeparationForceFrom(b1);
	assertEquals(-0.23077, b0.getSumOfXDistToThis(), delta);
	assertEquals(-0.15385, b0.getSumOfYDistToThis(), delta);
    }

  @Test
      public void testCalcDistance(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.0001;

      double distance = b0.calcDistance(b1);
      assertEquals(3.6055, distance, delta);
      distance = b0.calcDistance(b2);
      assertEquals(4.1231, distance, delta);
      distance = b0.calcDistance(b3);
      assertEquals(2.23606, distance, delta);
  }


  @Test
      public void testGetSumOfXDistToThis(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.0001;


      b0.addSeparationForceFrom(b1);
      assertEquals(-0.23077, b0.getSumOfXDistToThis(), delta);
      b0.addSeparationForceFrom(b2);
      assertEquals(-0.28959, b0.getSumOfXDistToThis(), delta);
      b0.addSeparationForceFrom(b3);
      assertEquals(-0.08959, b0.getSumOfXDistToThis(), delta);
      
  }

  @Test
      public void testGetSumOfYDistToThis(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.0001;

      b0.addSeparationForceFrom(b1);
      assertEquals(-0.1538, b0.getSumOfYDistToThis(), delta);
      b0.addSeparationForceFrom(b2);
      assertEquals(-0.38914, b0.getSumOfYDistToThis(), delta);
      b0.addSeparationForceFrom(b3);
      assertEquals(-0.78914, b0.getSumOfYDistToThis(), delta);




  }
    
    @Test 
	public void testGetCurXCohesionForce(){
	Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
        Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
        Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
	double delta = 0.1;
	
	b1.addForceFrom(b0);
	assertEquals(-3.0, b1.getCurXCohesionForce(), delta);
	b1.addForceFrom(b2);
	assertEquals(-2.5, b1.getCurXCohesionForce(), delta);
	b1.addForceFrom(b3);
	assertEquals(-3.0, b1.getCurXCohesionForce(), delta);

    }
    
  @Test
      public void testGetCurYCohesionForce(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.1;
      
      b1.addForceFrom(b0);
      assertEquals(-2.0, b1.getCurYCohesionForce(), delta);
      b1.addForceFrom(b2);
      assertEquals(0.0, b1.getCurYCohesionForce(), delta);
      b1.addForceFrom(b3);
      assertEquals(0.0, b1.getCurYCohesionForce(), delta);
  }

  @Test
      public void testGetCurXSeparationForce(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.00001;
      
      b1.addForceFrom(b0);
      assertEquals(0.23077, b1.getCurXSeparationForce(), delta);
      b1.addForceFrom(b2);
      assertEquals(0.24038, b1.getCurXSeparationForce(), delta);
      b1.addForceFrom(b3);
      assertEquals(0.24359, b1.getCurXSeparationForce(), delta);

  }

  @Test
      public void testGetCurYSeparationForce(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.00001;

      b1.addForceFrom(b0);
      assertEquals(0.15385, b1.getCurYSeparationForce(), delta);
      b1.addForceFrom(b2);
      assertEquals(-0.04808, b1.getCurYSeparationForce(), delta);
      b1.addForceFrom(b3);
      assertEquals(-0.03205, b1.getCurYSeparationForce(), delta);

  }

  @Test
      public void testGetCurXAlignmentForce(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.1;

      b1.addForceFrom(b0);
      assertEquals(0.0, b1.getCurXAlignmentForce(), delta);
      b1.addForceFrom(b2);
      assertEquals(-1.5, b1.getCurXAlignmentForce(), delta);
      b1.addForceFrom(b3);
      delta = 0.00001;
      assertEquals(-1.33333, b1.getCurXAlignmentForce(), delta);
  }

  @Test
      public void testGetCurYAlignmentForce(){
      Boid b0 = new Boid(0, 0, 0, 1, 5, 255, 255, 255);
      Boid b1 = new Boid(3, 2, -2, 0, 4.1, 0, 0, 255);
      Boid b2 = new Boid(1, 4, -3, -3, 5, 255, 0, 0);
      Boid b3 = new Boid(-1, 2, -1, 1, 5, 0, 255, 0);
      double delta = 0.0001;

      b1.addForceFrom(b0);
      assertEquals(1.0, b1.getCurYAlignmentForce(), delta);
      b1.addForceFrom(b2);
      assertEquals(-1.0, b1.getCurYAlignmentForce(), delta);
      b1.addForceFrom(b3);
      delta = 0.00001;
      assertEquals(-0.33333, b1.getCurYAlignmentForce(), delta);
  }
    */
}
