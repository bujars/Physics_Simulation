import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestBoid {

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
    }

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
    
    @Test
	public void testGetRadius() {
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
	double delta = 0.1;
	
	assertEquals(5, b0.getRadius(), delta);
	assertEquals(4.1, b1.getRadius(), delta);
	assertEquals(5, b2.getRadius(), delta);
	assertEquals(5, b3.getRadius(), delta);
    }
    
    @Test
	public void testGetRGB() {
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
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
	expCo = new Vector2D(3.0, 1.0);
	expSep = new Vector2D(-0.23077, -0.15385);
	expAli = new Vector2D(-2.0, -1.0);
	String msgCo01 = "Actual: " + b0.getCurCohesionForce() + "\n" 
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep01 = "Actual: " + b0.getCurSeparationForce() + "\n" 
	    + "is not close to\n" + "Expected: " + expSep;
	String msgAli01 = "Actual: " + b0.getCurAlignmentForce() + "\n"
	    + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo01, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep01, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli01, b0.getCurAlignmentForce().isCloseTo(expAli, delta));
	
	b0.addForceFrom(b2);
	expCo = new Vector2D(2.0, 2.0);
	expSep = new Vector2D(-0.14480, -0.19457);
	expAli = new Vector2D(-2.5, -2.5);
	String msgCo02 = "Actual: " + b0.getCurCohesionForce() + "\n"
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep02 = "Actual: " + b0.getCurSeparationForce() + "\n"
	    + "is not close to\n" + "Expected: " + expSep;
	String msgAli02 = "Actual: " + b0.getCurAlignmentForce() + "\n"
	    + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo02, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep02, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli02, b0.getCurAlignmentForce().isCloseTo(expAli, delta));
	
	b0.addForceFrom(b3);
	expCo = new Vector2D(1.0, 1.66667);
	expSep = new Vector2D(-0.02986, -0.26305);
	expAli = new Vector2D(-2.0, -1.66667);
	String msgCo03 = "Actual: " + b0.getCurCohesionForce() + "\n"
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep03 = "Actual: " + b0.getCurSeparationForce() + "\n"
	    + "is not close to\n" + "Expected: " + expSep;
	String msgAli03 = "Actual: " + b0.getCurAlignmentForce() + "\n"
	    + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo03, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep03, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli03, b0.getCurAlignmentForce().isCloseTo(expAli, delta));
	
	b1.addForceFrom(b0);
	expCo = new Vector2D(-1.0, -2.0);
	expSep = new Vector2D(0.23077, 0.15385);
	expAli = new Vector2D(2.0, 1.0);
	String msgCo10 = "Actual: " + b1.getCurCohesionForce() + "\n"
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep10 = "Actual: " + b1.getCurSeparationForce() + "\n"
	    + "is not close to\n" + "Expected: " + expSep;
	String msgAli10 = "Actual: " + b1.getCurAlignmentForce() + "\n"
	    + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo10, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep10, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli10, b1.getCurAlignmentForce().isCloseTo(expAli, delta));
	
	b1.addForceFrom(b2);
	expCo = new Vector2D(-0.5, 0.0);
	expSep = new Vector2D(0.24038, -0.04808);
	expAli = new Vector2D(0.5, -1.0);
	String msgCo11 = "Actual: " + b1.getCurCohesionForce() + "\n"
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep11 = "Actual: " + b1.getCurSeparationForce() + "\n"
	    + "is not close to\n" + "Expected: " + expSep;
	String msgAli11 = "Actual: " + b1.getCurAlignmentForce() + "\n"
	    + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo11, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep11, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli11, b1.getCurAlignmentForce().isCloseTo(expAli, delta));
	
	b1.addForceFrom(b3);
	expCo = new Vector2D(-1.0, 0.0);
	expSep = new Vector2D(0.24359, -0.03205);
	expAli = new Vector2D(0.66667, -0.33333);
	String msgCo12 = "Actual: " + b1.getCurCohesionForce() + "\n"
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep12 = "Actual: " + b1.getCurSeparationForce() + "\n"
	    + "is not close to\n" + "Expected: " + expSep;
	String msgAli12 = "Actual: " + b1.getCurAlignmentForce() + "\n"
	    + "is not close to\n" + "Expected: " + expAli;
	
	assertTrue(msgCo12, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep12, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli12, b1.getCurAlignmentForce().isCloseTo(expAli, delta));
	

	/*
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
        double delta = 1E-4;

	Vector2D expCo = null;
	Vector2D expSep = null;
	Vector2D expAli = null;
		
	//Testing B0 with radius that takes all
	b0.addForceFrom(b1);
	expCo = new Vector2D(3.0, 2.0);
	expSep = new Vector2D(-0.23077, -0.15385);
	expAli = new Vector2D(-2.0, 0.0);
	String msgCo01 = "Actual: " + b0.getCurCohesionForce() + "\n" 
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep01 = "Actual: " + b0.getCurSeparationForce() + "\n" 
	    + "is not close to\n" + "Expected: " + expSep;
	String msgAli01 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo01, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep01, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli01, b0.getCurAlignmentForce().isCloseTo(expAli, delta));
	

	
	b0.addForceFrom(b2);
	expCo = new Vector2D(2.0, 3.0);
	expSep = new Vector2D(-0.14480, -0.19457);
	expAli = new Vector2D(-2.5, -1.5);
	String msgCo02 = "Actual: " + b0.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
	String msgSep02 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli02 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo02, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep02, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli02, b0.getCurAlignmentForce().isCloseTo(expAli, delta));
	
	b0.addForceFrom(b3);
	expCo = new Vector2D(1.0, 2.66667);
	expSep = new Vector2D(-0.02986, -0.26305);
	expAli = new Vector2D(-2.0, -0.66667);
	String msgCo03 = "Actual: " + b0.getCurCohesionForce() + "\n"
	    + "is not close to\n" + "Expected: " + expCo;
	String msgSep03 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli03 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo03, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep03, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli03, b0.getCurAlignmentForce().isCloseTo(expAli, delta));
	
	
	//Testing B1 with radius that takes all
	b1.addForceFrom(b0);
	expCo = new Vector2D(-3.0, -2.0);
	expSep = new Vector2D(0.23077, 0.15385);
	expAli = new Vector2D(0.0, 1.0);
	String msgCo10 = "Actual: " + b1.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep10 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli10 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;

	assertTrue(msgCo10, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep10, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli10, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b2);
	expCo = new Vector2D(-2.5, 0.0);
	expSep = new Vector2D(0.24038, -0.04808);
	expAli = new Vector2D(-1.5, -1.0);
	String msgCo11 = "Actual: " + b1.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep11 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli11 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo11, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep11, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli11, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b3);
	expCo = new Vector2D(-3.0, 0.0);
	expSep = new Vector2D(0.24359, -0.03205);
	expAli = new Vector2D(-1.33333, -0.33333);
	String msgCo12 = "Actual: " + b1.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep12 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli12 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo12, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep12, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli12, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	*/

	b0 = new Boid(0.0, 0.0, 0.0, 1.0, 2.0, 255, 255, 255);
	b1 = new Boid(3.0, 2.0, -2.0, 0.0, 2.0, 0, 0, 255);
	b2 = new Boid(1.0, 4.0, -3.0, -3.0, 2.0, 255, 0, 0);
	b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 2.0, 0, 255, 0);              

	
	//Testing B0 with small radius

	b0.addForceFrom(b1);
	expCo = new Vector2D(1.5, 1.5);
	expSep = new Vector2D(-0.08009049773755658, -0.23574660633484162);
	expAli = new Vector2D(-2.0, -1.5);
	String msgCo001 = "Actual: " + b0.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep001 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli001 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;

	assertTrue(msgCo001, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep001, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli001, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b2);
	expCo = new Vector2D(1.4000000000000001, 1.8000000000000003);
	expSep = new Vector2D(-0.07583710407239821, -0.23565610859728509);
	expAli = new Vector2D(-2.2, -2.0);
	String msgCo002 = "Actual: " + b0.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep002 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli002 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;


	assertTrue(msgCo002, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep002, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli002, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b3);
	expCo = new Vector2D(1.0, 1.6666666666666665);
	expSep = new Vector2D(-0.029864253393665177, -0.2630467571644042);
	expAli = new Vector2D(-2.0, -1.6666666666666665);
	String msgCo003 = "Actual: " + b0.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep003 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli003 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo003, b0.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep003, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli003, b0.getCurAlignmentForce().isCloseTo(expAli, delta));


	//testing B1 with small radius
	b1.addForceFrom(b0);
	expCo = new Vector2D(-1.0, -0.5);
	expSep = new Vector2D(0.24038461538461536, 0.014423076923076941);
	expAli = new Vector2D(1.0, 0.0);
	String msgCo100 = "Actual: " + b1.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
	String msgSep100 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli100 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;

	assertTrue(msgCo100, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep100, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli100, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b2);
	expCo = new Vector2D(-0.7999999999999998, 0.0);
	expSep = new Vector2D(0.2423076923076923, -0.038461538461538436);
	expAli = new Vector2D(0.5999999999999999, -0.6000000000000001);
	String msgCo110 = "Actual: " + b1.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep110 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli110 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo110, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep110, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli110, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b3);
	expCo = new Vector2D(-1.0, 0.0);
	expSep = new Vector2D(0.24358974358974356, -0.03205128205128203);
	expAli = new Vector2D(0.6666666666666667, -0.3333333333333333);
	String msgCo120 = "Actual: " + b1.getCurCohesionForce() + "\n"
            + "is not close to\n" + "Expected: " + expCo;
        String msgSep120 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
        String msgAli120 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgCo120, b1.getCurCohesionForce().isCloseTo(expCo, delta));
	assertTrue(msgSep120, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	assertTrue(msgAli120, b1.getCurAlignmentForce().isCloseTo(expAli, delta));
    
	
	}


   @Test
       public void testAddCohesionForceFrom(){
       Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
       Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
       Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
       Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
       double delta = 1E-4;

       Vector2D expCo = null;


       b0.addForceFrom(b1);
       expCo = new Vector2D(3.0, 1.0);
       String msgCo01 = "Actual: " + b0.getCurCohesionForce() + "\n" 
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo01, b0.getCurCohesionForce().isCloseTo(expCo, delta));

       b0.addForceFrom(b2);
       expCo = new Vector2D(2.0, 2.0);
       String msgCo02 = "Actual: " + b0.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo02, b0.getCurCohesionForce().isCloseTo(expCo, delta));

       b0.addForceFrom(b3);
       expCo = new Vector2D(1.0, 1.66667);
       String msgCo03 = "Actual: " + b0.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo03, b0.getCurCohesionForce().isCloseTo(expCo, delta));

       b1.addForceFrom(b0);
       expCo = new Vector2D(-1.0, -2.0);
       String msgCo10 = "Actual: " + b1.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo10, b1.getCurCohesionForce().isCloseTo(expCo, delta));

       b1.addForceFrom(b2);
       expCo = new Vector2D(-0.5, 0.0);
       String msgCo11 = "Actual: " + b1.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo11, b1.getCurCohesionForce().isCloseTo(expCo, delta));

       b1.addForceFrom(b3);
       expCo = new Vector2D(-1.0, 0.0);
       String msgCo12 = "Actual: " + b1.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo12, b1.getCurCohesionForce().isCloseTo(expCo, delta));


       /*       b0.addForceFrom(b1);
       expCo = new Vector2D(3.0, 2.0);
       String msgCo01 = "Actual: " + b0.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo01, b0.getCurCohesionForce().isCloseTo(expCo, delta));


       b0.addForceFrom(b2);
       expCo = new Vector2D(2.0, 3.0);
       String msgCo02 = "Actual: " + b0.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo02, b0.getCurCohesionForce().isCloseTo(expCo, delta));

       b0.addForceFrom(b3);
       expCo = new Vector2D(1.0, 2.66667);
       String msgCo03 = "Actual: " + b0.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo03, b0.getCurCohesionForce().isCloseTo(expCo, delta));


       b1.addForceFrom(b0);
       expCo = new Vector2D(-3.0, -2.0);
       String msgCo10 = "Actual: " + b1.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo10, b1.getCurCohesionForce().isCloseTo(expCo, delta));

       b1.addForceFrom(b2);
       expCo = new Vector2D(-2.5, 0.0);
       String msgCo11 = "Actual: " + b1.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo11, b1.getCurCohesionForce().isCloseTo(expCo, delta));

       b1.addForceFrom(b3);
       expCo = new Vector2D(-3.0, 0.0);
       String  msgCo12 = "Actual: " + b1.getCurCohesionForce() + "\n"
	   + "is not close to\n" + "Expected: " + expCo;
       assertTrue(msgCo12, b1.getCurCohesionForce().isCloseTo(expCo, delta));
       */
       }
    
    @Test
	public void testMove(){
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
	Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
	Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
	Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
	double delta = 1E-3;
	double timeDelta = 10;	

	b0.addForceFrom(b1);
	b0.addForceFrom(b2);
	b0.addForceFrom(b3);

	b1.addForceFrom(b0);
	b1.addForceFrom(b2);
	b1.addForceFrom(b3);


	b0.move(10);
	Vector2D expNewVel = new Vector2D(-1.02986, 0.73695); 
	Vector2D expNewPos = new Vector2D(-10.2986, 7.3685);
	String msgVel01 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + expNewVel;
	String msgPos01 = "Actual: " + b0.getPosition() + "\n"
            + "is not close to\n" + "Expected: " + expNewPos; 

	assertTrue(msgVel01, b0.getVelocity().isCloseTo(expNewVel, delta));
	assertTrue(msgPos01, b0.getPosition().isCloseTo(expNewPos, delta));

	b1.move(10);
	expNewVel = new Vector2D(-2.08974, -0.36538); 
	expNewPos = new Vector2D(-17.8974, -1.6538);
	String msgVel02 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + expNewVel; 
	String msgPos02 = "Actual: " + b0.getPosition() + "\n"
	    + "is not close to\n" + "Expected: " + expNewPos; 
	assertTrue(msgVel02, b1.getVelocity().isCloseTo(expNewVel, delta));
	assertTrue(msgPos02, b1.getPosition().isCloseTo(expNewPos, delta));




	//Small Radius
	b0 = new Boid(0.0, 0.0, 0.0, 1.0, 2.0, 255, 255, 255);
	b1 = new Boid(3.0, 2.0, -2.0, 0.0, 2.0, 0, 0, 255);
	b2 = new Boid(1.0, 4.0, -3.0, -3.0, 2.0, 255, 0, 0);
	b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 2.0, 0, 255, 0);
	b0.addForceFrom(b1);
	b0.addForceFrom(b2);
	b0.addForceFrom(b3);
        b1.addForceFrom(b0);
	b1.addForceFrom(b2);
	b1.addForceFrom(b3); 

	b0.move(timeDelta);
	
	delta = 0.1;
	expNewVel = new Vector2D(0.0, 1.0); 
	expNewPos = new Vector2D(0.0, 10.0);
	msgVel01 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + expNewVel;
	msgPos01 = "Actual: " + b0.getPosition() + "\n"
	    + "is not close to\n" + "Expected: " + expNewPos; 
	assertTrue(msgVel01, b0.getVelocity().isCloseTo(expNewVel, delta));
	assertTrue(msgPos01, b0.getPosition().isCloseTo(expNewPos, delta));


	b1.move(timeDelta); 
	expNewVel = new Vector2D(0.0, 1.0); 
	expNewPos = new Vector2D(0.0, 10.0);
	msgVel02 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + expNewVel; 
	msgPos02 = "Actual: " + b0.getPosition() + "\n"
	    + "is not close to\n" + "Expected: " + expNewPos; 
	assertTrue(msgVel02, b1.getVelocity().isCloseTo(expNewVel, delta));
	assertTrue(msgPos02, b1.getPosition().isCloseTo(expNewPos, delta));




	/*	Vector2D velocity = null;
	Vector2D position = null;

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
	velocity = new Vector2D(-0.3432, 1.5789);
	String msgVel01 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + velocity;
	assertTrue(msgVel01, b0.getVelocity().isCloseTo(velocity, delta));
	position = new Vector2D(-3.4328, 15.7898);
	String msgPos01 = "Actual: " + b0.getPosition() + "\n" 
	    + "is not close to\n" + "Expected: " + position;
	assertTrue(msgPos01, b0.getPosition().isCloseTo(position, delta)); 
    
	//b1
	velocity = new Vector2D(-3.3632, -0.1217);
	String msgVel02 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + velocity;
	assertTrue(msgVel02, b1.getVelocity().isCloseTo(velocity, delta));
	position = new Vector2D(-30.6324, 0.7820);
	String msgPos02 = "Actual: " + b0.getPosition() + "\n"
	    + "is not close to\n" + "Expected: " + position;
	assertTrue(msgPos02, b1.getPosition().isCloseTo(position, delta));    
       
	b0 = new Boid(0.0, 0.0, 0.0, 1.0, 2.0, 255, 255, 255);
	b1 = new Boid(3.0, 2.0, -2.0, 0.0, 2.0, 0, 0, 255);
	b2 = new Boid(1.0, 4.0, -3.0, -3.0, 2.0, 255, 0, 0);
	b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 2.0, 0, 255, 0); 
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
	velocity = new Vector2D(0.0, 1.0);
	String msgVel03 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + velocity;
	assertTrue(msgVel03, b0.getVelocity().isCloseTo(velocity, delta));
	position = new Vector2D(0.0, 10.0);
	String msgPos03 = "Actual: " + b0.getPosition() + "\n"
	    + "is not close to\n" + "Expected: " + position;
	assertTrue(msgPos03, b0.getPosition().isCloseTo(position, delta));

	//b1
	velocity = new Vector2D(-2.0, 0.0);
	String msgVel04 = "Actual: " + b0.getVelocity() + "\n"
	    + "is not close to\n" + "Expected: " + velocity;
	assertTrue(msgVel04, b1.getVelocity().isCloseTo(velocity, delta));
	position = new Vector2D(-17.0, 2.0);
	String msgPos04 = "Actual: " + b0.getPosition() + "\n" 
	    + "is not close to\n" + "Expected: " + position;
	assertTrue(msgPos04, b1.getPosition().isCloseTo(position, delta));   

	*/
    }

    
    @Test
	public void testAddAlignmentForceFrom(){
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
	Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
	Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
	Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
	double delta = 1E-4;

	Vector2D expAli = null;

	b0.addForceFrom(b1);
	expAli = new Vector2D(-2.0, -1.0);
	String msgAli01 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli01, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b2);
	expAli = new Vector2D(-2.5, -2.5);
	String msgAli02 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli02, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b3);
	expAli = new Vector2D(-2.0, -1.66667);
	String msgAli03 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli03, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b0);
	expAli = new Vector2D(2.0, 1.0);
	String msgAli10 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli10, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b2);
	expAli = new Vector2D(0.5, -1.0);
	String msgAli11 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli11, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b3);
	expAli = new Vector2D(0.66667, -0.33333);
	String msgAli12 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli12, b1.getCurAlignmentForce().isCloseTo(expAli, delta));




	/*Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
        double delta = 1E-4;

        Vector2D expCo = null;
        Vector2D expSep = null;
        Vector2D expAli = null;

        b0.addForceFrom(b1);
        expAli = new Vector2D(-2.0, 0.0);
        String msgAli01 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli01, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

        b0.addForceFrom(b2);
        expAli = new Vector2D(-2.5, -1.5);
        String msgAli02 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli02, b0.getCurAlignmentForce().isCloseTo(expAli, delta));


        b0.addForceFrom(b3);
        expAli = new Vector2D(-2.0, -0.66667);
        String msgAli03 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli03, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

        b1.addForceFrom(b0);
        expAli = new Vector2D(0.0, 1.0);
        String msgAli10 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli10, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

        b1.addForceFrom(b2);
        expAli = new Vector2D(-1.5, -1.0);
        String msgAli11 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli11, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b3);
        expAli = new Vector2D(-1.33333, -0.33333);
        String msgAli12 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli12, b1.getCurAlignmentForce().isCloseTo(expAli, delta));


	b0 = new Boid(0.0, 0.0, 0.0, 1.0, 2.0, 255, 255, 255);
        b1 = new Boid(3.0, 2.0, -2.0, 0.0, 2.0, 0, 0, 255);
        b2 = new Boid(1.0, 4.0, -3.0, -3.0, 2.0, 255, 0, 0);
        b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 2.0, 0, 255, 0);

        b0.addForceFrom(b1);
        expAli = new Vector2D(0.0, 0.0);
        String msgAli001 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli001, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

        b0.addForceFrom(b2);
        expAli = new Vector2D(0.0, 0.0);
        String msgAli002 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli002, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

        b0.addForceFrom(b3);
        expAli = new Vector2D(0.0, 0.0);
        String msgAli003 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli003, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

        b1.addForceFrom(b0);
        String msgAli100 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli100, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

        expAli = new Vector2D(0.0, 0.0);
        b1.addForceFrom(b2);
        String msgAli110 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli110, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

        b1.addForceFrom(b3);
        expAli = new Vector2D(0.0, 0.0);
        String msgAli120 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
        assertTrue(msgAli120, b1.getCurAlignmentForce().isCloseTo(expAli, delta));
	*/
    }
    
    @Test 
	public void testAddSeparationForceFrom(){
	
	Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
	Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
	Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
	Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
	double delta = 1E-4;

	Vector2D expSep = null;

	b0.addForceFrom(b1);
	expSep = new Vector2D(-0.23077, -0.15385);
	String msgSep01 = "Actual: " + b0.getCurSeparationForce() + "\n" 
	    + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep01, b0.getCurSeparationForce().isCloseTo(expSep, delta));

	b0.addForceFrom(b2);
	expSep = new Vector2D(-0.14480, -0.19457);
	String msgSep02 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep02, b0.getCurSeparationForce().isCloseTo(expSep, delta));

	b0.addForceFrom(b3);
	expSep = new Vector2D(-0.02986, -0.26305);
	String msgSep03 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep03, b0.getCurSeparationForce().isCloseTo(expSep, delta));

	b1.addForceFrom(b0);
	expSep = new Vector2D(0.23077, 0.15385);
	String msgSep10 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep10, b1.getCurSeparationForce().isCloseTo(expSep, delta));

	b1.addForceFrom(b2);
	expSep = new Vector2D(0.24038, -0.04808);
	String msgSep11 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep11, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	
	b1.addForceFrom(b3);
	expSep = new Vector2D(0.24359, -0.03205);
	String msgSep12 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep12, b1.getCurSeparationForce().isCloseTo(expSep, delta));


	/*Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
	Double delta = 1E-4;

	Vector2D expCo = null;
	Vector2D expSep = null;
	Vector2D expAli = null;
	
	b0.addForceFrom(b1);
	expSep = new Vector2D(-0.23077, -0.15385);
	String msgSep01 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep01, b0.getCurSeparationForce().isCloseTo(expSep, delta));
    
	b0.addForceFrom(b2);
	expSep = new Vector2D(-0.14480, -0.19457);
	String msgSep02 = "Actual: " + b0.getCurSeparationForce() + "\n"
	+ "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep02, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	
	b0.addForceFrom(b3);
	expSep = new Vector2D(-0.02986, -0.26305);
	String msgSep03 = "Actual: " + b0.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep03, b0.getCurSeparationForce().isCloseTo(expSep, delta));
	
	b1.addForceFrom(b0);
	expSep = new Vector2D(0.23077, 0.15385);
	String msgSep10 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep10, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	
	b1.addForceFrom(b2);
	expSep = new Vector2D(0.24038, -0.04808);
	String msgSep11 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep11, b1.getCurSeparationForce().isCloseTo(expSep, delta));
	
	b1.addForceFrom(b3);
	expSep = new Vector2D(0.24359, -0.03205);
	String msgSep12 = "Actual: " + b1.getCurSeparationForce() + "\n"
	+ "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep12, b1.getCurSeparationForce().isCloseTo(expSep, delta));

	b0 = new Boid(0.0, 0.0, 0.0, 1.0, 2.0, 255, 255, 255);                                               
        b1 = new Boid(3.0, 2.0, -2.0, 0.0, 2.0, 0, 0, 255);                                                  
        b2 = new Boid(1.0, 4.0, -3.0, -3.0, 2.0, 255, 0, 0);                                                 
        b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 2.0, 0, 255, 0);  
	

	b0.addForceFrom(b1);
	expSep = new Vector2D(0.0, 0.0);
	String msgSep001 = "Actual: " + b0.getCurSeparationForce() + "\n"
	+ "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep001, b0.getCurSeparationForce().isCloseTo(expSep, delta));

	b0.addForceFrom(b2);
	String msgSep002 = "Actual: " + b0.getCurSeparationForce() + "\n"
	+ "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep002, b0.getCurSeparationForce().isCloseTo(expSep, delta));

	b0.addForceFrom(b3);
	String msgSep003 = "Actual: " + b0.getCurSeparationForce() + "\n"
	+ "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep003, b0.getCurSeparationForce().isCloseTo(expSep, delta));

	b1.addForceFrom(b0);
	String msgSep100 = "Actual: " + b1.getCurSeparationForce() + "\n"
	+ "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep100, b1.getCurSeparationForce().isCloseTo(expSep, delta));

	b1.addForceFrom(b2);
	String msgSep110 = "Actual: " + b1.getCurSeparationForce() + "\n"
	+ "is not close to\n" + "Expected: " + expSep;
	assertTrue(msgSep110, b1.getCurSeparationForce().isCloseTo(expSep, delta));

	b1.addForceFrom(b3);
	expSep = new Vector2D(0.0, 0.0);
	String msgSep120 = "Actual: " + b1.getCurSeparationForce() + "\n"
            + "is not close to\n" + "Expected: " + expSep;
	*/  
	}
	/*
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
    */


    @Test
	public void testGetCurAlignmentForce(){
	/*Boid b0 = new Boid(0.0, 0.0, 0.0, 1.0, 5.0, 255, 255, 255);
        Boid b1 = new Boid(3.0, 2.0, -2.0, 0.0, 4.1, 0, 0, 255);
        Boid b2 = new Boid(1.0, 4.0, -3.0, -3.0, 5.0, 255, 0, 0);
        Boid b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 5.0, 0, 255, 0);
	double delta = 1E-4;

	Vector2D expCo = null;
        Vector2D expSep = null;
        Vector2D expAli = null;

	b0.addForceFrom(b1);
	expAli = new Vector2D(-2.0, 0.0);
	String msgAli01 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli01, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b2);
	expAli = new Vector2D(-2.5, -1.5);
	String msgAli02 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli02, b0.getCurAlignmentForce().isCloseTo(expAli, delta));


	b0.addForceFrom(b3);
	expAli = new Vector2D(-2.0, -0.66667);
	String msgAli03 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli03, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b0);
	expAli = new Vector2D(0.0, 1.0);
	String msgAli10 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli10, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b2);
	expAli = new Vector2D(-1.5, -1.0);
	String msgAli11 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli11, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b3);
	expAli = new Vector2D(-1.33333, -0.33333);
	String msgAli12 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli12, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0 = new Boid(0.0, 0.0, 0.0, 1.0, 2.0, 255, 255, 255);                                               
        b1 = new Boid(3.0, 2.0, -2.0, 0.0, 2.0, 0, 0, 255);                                                  
        b2 = new Boid(1.0, 4.0, -3.0, -3.0, 2.0, 255, 0, 0);                                                 
        b3 = new Boid(-1.0, 2.0, -1.0, 1.0, 2.0, 0, 255, 0);   

	b0.addForceFrom(b1);
	expAli = new Vector2D(0.0, 0.0);
	String msgAli001 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli001, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b2);
	expAli = new Vector2D(0.0, 0.0);
	String msgAli002 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli002, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b0.addForceFrom(b3);
	expAli = new Vector2D(0.0, 0.0);
	String msgAli003 = "Actual: " + b0.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli003, b0.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b0);
	String msgAli100 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli100, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	expAli = new Vector2D(0.0, 0.0);
	b1.addForceFrom(b2);
	String msgAli110 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli110, b1.getCurAlignmentForce().isCloseTo(expAli, delta));

	b1.addForceFrom(b3);
	expAli = new Vector2D(0.0, 0.0);
	String msgAli120 = "Actual: " + b1.getCurAlignmentForce() + "\n"
            + "is not close to\n" + "Expected: " + expAli;
	assertTrue(msgAli120, b1.getCurAlignmentForce().isCloseTo(expAli, delta));
	*/
    }
}