import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class TestColBody{

    @Test
	public void testGetXCoord(){
	ColBody ca = new ColBody(1.0, 1.0, 1.0, 1.0, 1.0, .01, 0, 0, 255);
	double delta = 0.00001;
	assertEquals(1.0, ca.getXCoord(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(0.0, M.getXCoord(), delta);
	assertEquals(4.0, M1.getXCoord(), delta);
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
	/* ColBody cbM1 = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
        ColBody cbM = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
        ColBody cbM2 = new ColBody(5, 1, 0, 0, 75, 0.01, 0, 0, 0);
        double delta = 0.01;
        assertEquals(0, cbM.getXForce(), delta);
        assertEquals(0, cbM.getYForce(), delta);
        cbM.addForceFrom(cbM1);
        cbM.addForceFrom(cbM2);
        delta = 1E-8;
        assertEquals(1.4597691298065942E-7, cbM.getXForce(), delta);
        delta = 1E-9;
        assertEquals(6.619388568435468E-8, cbM.getYForce(), delta);
        delta = 0;
        assertEquals(0, cbM2.getXForce(), delta);
        assertEquals(0, cbM2.getYForce(), delta);
        assertEquals(0, cbM1.getXForce(), delta);
        assertEquals(0, cbM1.getYForce(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	//need to test
	*/
	}

    @Test
	public void testMove(){
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
    /*     @Test
	 public void testGetXForce(){
	 ColBody cbA = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
	 double delta = 0.01;
	 assertEquals(0, cbA.getXForce(), delta);
	 ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	 ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	 assertEquals(0.0, M.getXForce(), delta);
	 assertEquals(0.0, M1.getXForce(), delta);
     }
    
    @Test
	public void testGetYForce(){
	ColBody cbA = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
	double delta = 0.01;
	assertEquals(0, cbA.getYForce(), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(0.0, M.getYForce(), delta);
	assertEquals(0.0, M1.getYForce(), delta);

    }
    
    @Test
	public void testCalculateTotalForce(){
	ColBody cbA = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
	ColBody cbB = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
	double delta = 1E-9;
	assertEquals(5.13E-8, cbA.calculateTotalForce(cbB), delta);
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	delta = 1E-9;
	assertEquals(2.084E-8, M.calculateTotalForce(M1), delta);
    }
    */    
    @Test
	public void testGetDistance(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.01;
	assertEquals(5.65685424949, M.getDistance(M1), delta);

    }
    /*
    @Test
	public void testAngle(){
        ColBody cbM1 = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
        ColBody cbM = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
        ColBody cbM2 = new ColBody(5, 1, 0, 0, 75, 0.01, 0, 0, 0);
        double delta = .01;
        assertEquals(2.56, cbM.getAngle(cbM1), delta);
        assertEquals(0.19, cbM.getAngle(cbM2), delta);
	
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(0.7853981634, M.getAngle(M1), delta);
    }

    @Test
	public void testCalculateXForce(){
	ColBody cbA = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
        ColBody cbB = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
        ColBody cbC = new ColBody(5, 1, 0, 0, 75, 0.01, 0, 0, 0);
        double delta = 1E-9;
        assertEquals(-4.26841801E-8, cbB.calculateXForce(cbA), delta);
        delta = 1E-8;
        assertEquals(1.88667493E-7, cbB.calculateXForce(cbC), delta);

	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	delta = 1E-9;
	assertEquals(1.474E-8, M.calculateXForce(M1), delta);
    }

    @Test
	public void testCalculateYForce(){
	ColBody cbA = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
        ColBody cbB = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
        ColBody cbC = new ColBody(5, 1, 0, 0, 75, 0.01, 0, 0, 0);
        ColBody cbD = new ColBody(5, -1, 0, 0, 75, 0.01, 0, 0, 0);
        double delta = 1E-9;
        assertEquals(2.85E-8, cbB.calculateYForce(cbA), delta);
        assertEquals(3.86E-8, cbB.calculateYForce(cbC), delta);
        assertEquals(-3.86E-8, cbB.calculateYForce(cbD), delta);

	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	delta = 1E-9;
	assertEquals(1.474E-8, M.calculateYForce(M1), delta);
    }

      @Test
	  public void testCalculateXAccel(){
	  ColBody cM1 = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
	  ColBody cM = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
	  cM.addForceFrom(cM1);
	  double delta = 1E-12;
	  assertEquals(-4.2690580486E-11, cM.calculateXAccel(), delta);

	  ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	  ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	  M.addForceFrom(M1);
	  delta = 1E-11;
	  assertEquals(1.474E-10, M.calculateXAccel(), delta);

      }

    @Test
	public void testCalculateYAccel(){
	ColBody cM1 = new ColBody(-6, 4, 0, 0, 40, 0.01, 0, 0, 0);
        ColBody cM = new ColBody(0, 0, 0, 0, 1000, 0.01, 0, 0, 0);
        cM.addForceFrom(cM1);
	double delta = 1E-12;
        double ya = 2.84561201E-8/1000;
	assertEquals(ya, cM.calculateYAccel(), delta);
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	M.addForceFrom(M1);
	delta = 1E-11;
	assertEquals(1.474E-10, M.calculateYAccel(), delta);
    }
    */
    @Test
	   public void testAreBodiesTouching(){
	   ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	   ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	   assertEquals(true, M.areBodiesTouching(M1));
       }
    
    @Test
	public void testAreBodiesMoving(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	assertEquals(true, M.areBodiesMoving(M1));

    }
    
    @Test
	public void testCalculateDotProduct(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
	ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.001;
	assertEquals(-8, M.calculateDotProduct(M1), delta);
    }
    
    @Test
	public void testCalculateXVelocity(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.001;
	assertEquals(-1, M.calculateXVelocity(M1), delta);
    }
    
    @Test
	public void testCalculateYVelocity(){
	ColBody M = new ColBody(0.0, 0.0, 0.0, 0.0, 100, 3.0, 0, 0, 0);
        ColBody M1 = new ColBody(4.0, 4.0, -1.0, -1.0, 100, 3.0, 0, 0, 0);
	double delta = 0.001;
	assertEquals(-1, M.calculateYVelocity(M1), delta);
    }
}