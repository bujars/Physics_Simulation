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
	double delta = 0.00001;

	assertEquals(1, gb.getYCoord(), delta);
        assertEquals(0, gc.getYCoord(), delta);
        assertEquals(1.52308, gd.getYCoord(), delta);
        assertEquals(-1, ge.getYCoord(), delta);
        assertEquals(100, gf.getYCoord(), delta);
    }

    @Test
	public void testGetXVel() {
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

    @Test
	public void testGetYVel() {                              
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
    
    @Test
	public void testGetRadius() {
        GravBody gb = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        double delta = 0.00001;
        assertEquals(-1, gb.getRadius(), delta);
    }
    
    @Test
	public void testGetRed(){
	GravBody gbA = new GravBody(0, 0, 0, 0, 0, 255, 0, 0);
        double delta = 0.00001;
        assertEquals(255, gbA.getRed(), delta);
    } 

    @Test
	public void testGetGreen(){
        GravBody gbA = new GravBody(0, 0, 0, 0, 0, 0, 255, 0);
        double delta = 0.00001;
        assertEquals(255, gbA.getGreen(), delta);
    }

    @Test
	public void testGetBlue(){
        GravBody gbA = new GravBody(0, 0, 0, 0, 0, 0, 0, 255);
        double delta = 0.00001;
        assertEquals(255, gbA.getBlue(), delta);
    }


    @Test
	public void testGetRGB() {                              
	GravBody gb = new GravBody(1, 1, 1, 1, 1, 1, 1, 1);
        GravBody gc = new GravBody(0, 0, 0, 0, 0, 0, 0, 0);
        GravBody gd = new GravBody(2.95365, 1.52308, -3.24931, 6.34897, 5.96676, 255, 255, 0);
        GravBody ge = new GravBody(-1, -1, -1, -1, -1, 255, 255, 255);
        GravBody gf = new GravBody(100, 100, 100, 100, 100, 100, 100, 100);
	int gbr = 1;
	int gbg = 1;
	int gbb = 1;
	int[] whatb = {gbr,gbg,gbb};
	assertArrayEquals(whatb, gb.getRGB());        
	int gcr = 0;
        int gcg = 0;
        int gcb = 0;
        int[] whatc = {gcr,gcg,gcb};
        assertArrayEquals(whatc, gc.getRGB());
	int gdr = 255;
        int gdg = 255;
        int gdb = 0;
        int[] whatd = {gdr,gdg,gdb};
        assertArrayEquals(whatd, gd.getRGB());
	int ger = 255;
        int geg = 255;
        int geb = 255;
        int[] whate = {ger,geg,geb};
        assertArrayEquals(whate, ge.getRGB());
	int gfr = 100;
        int gfg = 100;
        int gfb = 100;
        int[] whatf = {gfr,gfg,gfb};
        assertArrayEquals(whatf, gf.getRGB());
	
    }
    
    @Test
	public void testGetMass() {
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
	GravBody gbM1 = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody gbM = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
        GravBody gbM2 = new GravBody(5, 1, 0, 0, 75, 0, 0, 0);

	double delta = 0.01;

        assertEquals(0, gbM.getXForce(), delta);
	assertEquals(0, gbM.getYForce(), delta);

	gbM.addForceFrom(gbM1);
	gbM.addForceFrom(gbM2);
	delta = 1E-8;
	assertEquals(1.4597691298065942E-7, gbM.getXForce(), delta);
	delta = 1E-9;
	assertEquals(6.619388568435468E-8, gbM.getYForce(), delta);

	delta = 0;
	assertEquals(0, gbM2.getXForce(), delta);
	assertEquals(0, gbM2.getYForce(), delta);
	assertEquals(0, gbM1.getXForce(), delta);
	assertEquals(0, gbM1.getYForce(), delta);
    }

    @Test
	public void testMove(){
	GravBody gbEarth = new GravBody(1.5, 0, 0, 3.0E4, 5.972E24, 0, 0, 0);
        GravBody gbSun = new GravBody(0, 0, 0, 0, 1.99E30, 0, 0, 0);
        GravBody gbVenus = new GravBody(1, 0, 0, 3.5E4, 4.87E24, 0, 0, 0);

	GravBody gbM1 = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody gbM = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
        GravBody gbM2 = new GravBody(5, 1, 0, 0, 75, 0, 0, 0);
	double time = 1; 
	double delta = 1E-11;

	gbM.addForceFrom(gbM1);
	gbM.addForceFrom(gbM2);

	gbM.move(time);
	gbM1.move(time);
	gbM2.move(time);

	assertEquals(1.45976912E-10, gbM.getXCoord(), delta);
	delta = 1E-12;
	assertEquals(6.61938856843E-11, gbM.getYCoord(), delta);

	assertEquals(0, gbM.getXForce(), delta);
	assertEquals(0, gbM.getYForce(), delta);
	assertEquals(0, gbM1.getXForce(), delta);
	assertEquals(0, gbM2.getYForce(), delta);
	assertEquals(0, gbM1.getXForce(), delta);
	assertEquals(0, gbM1.getYForce(), delta);
    }
    
    @Test
	public void testCalculateTotalForce(){
        GravBody gbA = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody gbB = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
        double delta = 1E-9;
        assertEquals(5.13E-8, gbA.calculateTotalForce(gbB), delta);
    }

    @Test
	public void testDistance(){
	GravBody gbA = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody gbB = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
	double delta = 1E-9; 
	double distance = Math.hypot(0 - (-6), 0 - (4));
	System.out.println(distance);
	assertEquals(distance, gbA.getDistance(gbB), delta);
    }

    @Test
	public void testAngle(){
	GravBody gbM1 = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody gbM = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
        GravBody gbM2 = new GravBody(5, 1, 0, 0, 75, 0, 0, 0);
	double delta = .001;
	assertEquals(2.553, gbM.getAngle(gbM1), delta);
	assertEquals(0.197, gbM.getAngle(gbM2), delta);
	
    }

    @Test
	public void testCalculateXForce(){
	GravBody gbA = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody gbB = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
	GravBody gbC = new GravBody(5, 1, 0, 0, 75, 0, 0, 0);
	double delta = 1E-9;
        assertEquals(-4.26841801E-8, gbB.calculateXForce(gbA), delta);
	delta = 1E-8;
	assertEquals(1.88667493E-7, gbB.calculateXForce(gbC), delta);
	
    }

    @Test
	public void testCalculateYForce(){ 
        GravBody gbA = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody gbB = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
        GravBody gbC = new GravBody(5, 1, 0, 0, 75, 0, 0, 0);

	GravBody gbD = new GravBody(5, -1, 0, 0, 75, 0, 0, 0);
	
	double delta = 1E-9;
        assertEquals(2.85E-8, gbB.calculateYForce(gbA), delta);
	assertEquals(3.86E-8, gbB.calculateYForce(gbC), delta); 
	assertEquals(-3.86E-8, gbB.calculateYForce(gbD), delta);
    }

    @Test
	public void testCalculateXAccel(){
        GravBody M1 = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody M = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
        M.addForceFrom(M1);
	double delta = 1E-12;
        assertEquals(-4.2690580486E-11, M.calculateXAccel(), delta);
    }

    @Test
	public void testCalculateYAccel(){
        GravBody M1 = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
        GravBody M = new GravBody(0, 0, 0, 0, 1000, 0, 0, 0);
	M.addForceFrom(M1);
	double delta = 1E-12;
        double ya = 2.84561201E-8/1000;
        assertEquals(ya, M.calculateYAccel(), delta);
    }

    @Test
	public void testGetXForce(){
	GravBody gbA = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
	double delta = 0.01;
	assertEquals(0, gbA.getXForce(), delta);
    }

    @Test
	public void testGetYForce(){
	GravBody gbA = new GravBody(-6, 4, 0, 0, 40, 0, 0, 0);
	double delta = 0.01;
	assertEquals(0, gbA.getYForce(), delta);
    }
}