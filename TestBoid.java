import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class TestBoid {

    @Test
	public void testGetXCoord(){
	Boid t0 = new Boid(0, 0, 0, 0);
	Boid t1 = new Boid(4, 3, -1, 1);
	Boid t2 = new Boid(6, -2, 0, 1);
	Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1; 

	assertEquals(0, t0.getXCoord(), delta);
	assertEquals(4, t1.getXCoord(), delta);
	assertEquals(6, t2.getXCoord(), delta);
	assertEquals(5, t3.getXCoord(), delta);

    }

    @Test
	public void testGetYCoord() {
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);	
	double delta = 0.1;
 
	assertEquals(0, t0.getYCoord(), delta);
	assertEquals(3, t1.getYCoord(), delta);
	assertEquals(-2, t2.getYCoord(), delta);
	assertEquals(1, t3.getYCoord(), delta);
    }

    @Test
	public void testGetXVel() {
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
	
	assertEquals(0, t0.getXVel(), delta);
	assertEquals(-1, t1.getXVel(), delta);
	assertEquals(0, t2.getXVel(), delta);
	assertEquals(1, t3.getXVel(), delta);
    }

    @Test
	public void testGetYVel() {
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    
	assertEquals(0, t0.getYVel(), delta);
	assertEquals(1, t1.getYVel(), delta);
	assertEquals(1, t2.getYVel(), delta);
	assertEquals(1, t3.getYVel(), delta);

    }

    @Test
	public void testGetRadius() {
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }

    @Test
	public void testGetRGB() {
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }
    
    
    @Test
	public void testGetMass() {
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }
   
    @Test
	public void testAddForceFrom(){
	Boid b0 = new Boid(0, 0, 0, 1);
        Boid b1 = new Boid(3, 2, -2, 0);
        Boid b2 = new Boid(1, 4, -3, -3);
        Boid b3 = new Boid(-1, 2, -1, 1);
	double delta;


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
	assertEquals(0.0, b0.getCurYCohesionForce(), delta);

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
	assertEquals(-1.5, b0.getCurYCohesionForce(), delta);

	b0.addForceFrom(b3);
	delta = 0.1;
	assertEquals(1.0, b0.getCurXCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(2.66667, b0.getCurYCohesionForce(), delta);
	delta = 0.00001;
	assertEquals(-0.02986, b0.getCurXSeparationForce(), delta);
	delta = 0.00001;
	assertEquals(-0.28718, b0.getCurYSeparationForce(), delta);
	delta = 0.1;
	assertEquals(-2.0, b0.getCurXAlignmentForce(), delta);
	delta = 0.00001;
	assertEquals(-0.66667, b0.getCurYCohesionForce(), delta);


    }

   @Test
       public void testAddCohesionForceFrom(){
       Boid t0 = new Boid(0, 0, 0, 0);
       Boid t1 = new Boid(4, 3, -1, 1);
       Boid t2 = new Boid(6, -2, 0, 1);
       Boid t3 = new Boid(5, 1, 1, 1);
       double delta = 0.1;


       t0.addCohesionForceFrom(t1);
       t0.addCohesionForceFrom(t2);
       t0.addCohesionForceFrom(t3);

       assertEquals(5, t0.getChangeInXVelocity(), delta);
       assertEquals(.6666, t0.getChangeInYVelocity(), delta);


   }
    
    @Test
	public void testMove(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }

    @Test 
	public void testRecordNeighborsPosition(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	t0.recordNeighborsPosition(t1);
	t0.recordNeighborsPosition(t2);
	t0.recordNeighborsPosition(t3);
	
	assertEquals(15, t0.getSumOfNeighborsX(), delta);
	assertEquals(2, t0.getSumOfNeighborsY(), delta);
	assertEquals(3, t0.getCountOfNeighbors(), delta);
    }

    @Test
	public void testGetSumOfNeighborsX(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	//Since we didnt add anything, sum should be zero
	assertEquals(0, t0.getSumOfNeighborsX(), delta);
    }
    
    @Test
	public void testGetSumOfNeighborsY(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	//Since we didnt add anything, sum should be zero                                               
        assertEquals(0, t0.getSumOfNeighborsY(), delta);
    }

    @Test
	public void testCalcXNeighborsCenter(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	t0.recordNeighborsPosition(t1);
	t0.recordNeighborsPosition(t2);
	t0.recordNeighborsPosition(t3);

	assertEquals(15, t0.getSumOfNeighborsX(), delta);
	assertEquals(2, t0.getSumOfNeighborsY(), delta);
	assertEquals(3, t0.getCountOfNeighbors(), delta);


	assertEquals(5, t0.calcXNeighborsCenter(), delta);
    }

    @Test
	public void testCalcYNeighborsCenter(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;
	
	t0.recordNeighborsPosition(t1);
	t0.recordNeighborsPosition(t2);
	t0.recordNeighborsPosition(t3);
	
	assertEquals(15, t0.getSumOfNeighborsX(), delta);
	assertEquals(2, t0.getSumOfNeighborsY(), delta);
	assertEquals(3, t0.getCountOfNeighbors(), delta);

	assertEquals(0.6666, t0.calcYNeighborsCenter(), delta);
    }

    @Test
	public void testCalcXCohesionForce(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	t0.recordNeighborsPosition(t1);
	t0.recordNeighborsPosition(t2);
	t0.recordNeighborsPosition(t3);

	assertEquals(15, t0.getSumOfNeighborsX(), delta);
	assertEquals(2, t0.getSumOfNeighborsY(), delta);
	assertEquals(3, t0.getCountOfNeighbors(), delta);


	assertEquals(5, t0.calcXNeighborsCenter(), delta);

	double xCenter = t0.calcXNeighborsCenter();
	assertEquals(5, t0.calcXCohesionForce(xCenter), delta);
    
    }

   @Test
       public void testCalcYCohesionForce(){
       Boid t0 = new Boid(0, 0, 0, 0);
       Boid t1 = new Boid(4, 3, -1, 1);
       Boid t2 = new Boid(6, -2, 0, 1);
       Boid t3 = new Boid(5, 1, 1, 1);
       double delta = 0.0001;

       t0.recordNeighborsPosition(t1);
       t0.recordNeighborsPosition(t2);
       t0.recordNeighborsPosition(t3);

       assertEquals(15, t0.getSumOfNeighborsX(), delta);
       assertEquals(2, t0.getSumOfNeighborsY(), delta);
       assertEquals(3, t0.getCountOfNeighbors(), delta);


       assertEquals(0.6666, t0.calcYNeighborsCenter(), delta);

       double yCenter = t0.calcYNeighborsCenter();
       assertEquals(0.6666, t0.calcYCohesionForce(yCenter), delta);
   }   
    

    @Test
	public void testGetChangeInXVelocity(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;


	double changeX = t0.calcXCohesionForce(0.0);
	assertEquals(0, t0.getChangeInXVelocity(), delta);
	

    }

    @Test 
	public void testGetChangeInYVelocity(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	double changeY = t0.calcYCohesionForce(0.0);
	assertEquals(0, t0.getChangeInYVelocity(), delta);

    }

    @Test
	public void testRecordNeighborsVelocities(){
	Boid t4 = new Boid(0, 0, -1.5, 2);
	Boid t5 = new Boid(3, 2, 0, 2);
	Boid t6 = new Boid(-3, 3, -2, 2);
	double delta = 0.0001;
	
	t4.recordNeighborsVelocities(t5);
	t4.recordNeighborsVelocities(t6);
	assertEquals(-2, t4.getSumOfNeighborsVelX(), delta);
	assertEquals(4, t4.getSumOfNeighborsVelY(), delta);
    }
    
    @Test
	public void testCalcXAlignmentForce(){
	Boid t4 = new Boid(0, 0, -1.5, 2);
	Boid t5 = new Boid(3, 2, 0, 2);
	Boid t6 = new Boid(-3, 3, -2, 2);
	double delta = 0.0001;
	
	t4.addAlignmentForceFrom(t5);
	t4.addAlignmentForceFrom(t6);
	
	double xAlignment = t4.calcXAlignmentForce();
        
	assertEquals(-1, t4.getChangeInXVelocity(), delta);
    }

    @Test 
	public void testCalcYAlignmentForce(){
	Boid t4 = new Boid(0, 0, -1.5, 2);
	Boid t5 = new Boid(3, 2, 0, 2);
	Boid t6 = new Boid(-3, 3, -2, 2);
	double delta = 0.0001;

	t4.addAlignmentForceFrom(t5);
	t4.addAlignmentForceFrom(t6);
	
        double yAlignment = t4.calcYAlignmentForce();
	
	assertEquals(-1, t4.getChangeInYVelocity(), delta);
    }

    @Test
	public void testGetSumOfXVelocities(){
	Boid t4 = new Boid(0, 0, -1.5, 2);
	Boid t5 = new Boid(3, 2, 0, 2);
	Boid t6 = new Boid(-3, 3, -2, 2);
	double delta = 0.0001;
    
	//Nothing added to variable   
	assertEquals(0, t4.getSumOfNeighborsVelX(), delta);
    }
    
    @Test
	public void testGetSumOfYVelocities(){
	Boid t4 = new Boid(0, 0, -1.5, 2);
	Boid t5 = new Boid(3, 2, 0, 2);
	Boid t6 = new Boid(-3, 3, -2, 2);
	double delta = 0.0001;

	//Nothing added to variable
	assertEquals(0, t4.getSumOfNeighborsVelY(), delta);
    }
    
    @Test
	public void testAddAlignmentForceFrom(){
	Boid t4 = new Boid(0, 0, -1.5, 2);
	Boid t5 = new Boid(3, 2, 0, 2);
	Boid t6 = new Boid(-3, 3, -2, 2);
	double delta = 0.0001;

	t4.addAlignmentForceFrom(t5);
	t4.addAlignmentForceFrom(t6);
	
	assertEquals(-2, t4.getSumOfNeighborsVelX(), delta);
	assertEquals(4, t4.getSumOfNeighborsVelY(), delta);
    }

    @Test 
	public void testAddSeparationForceFrom(){
	Boid t7 = new Boid(0, 0, 0, 1);
	Boid t8 = new Boid(3, 3, -3, -3);
	Boid t9 = new Boid(5, 10, -5, -10);
	Boid t10 = new Boid(-4, 1, 4, -1);
	double delta = 0.0001;
   

    }

  @Test
      public void testCalcXDistToThis(){
      Boid t7 = new Boid(0, 0, 0, 1);
      Boid t8 = new Boid(3, 3, -3, -3);
      Boid t9 = new Boid(5, 10, -5, -10);
      Boid t10 = new Boid(-4, 1, 4, -1);
      double delta = 0.0001;
  
      double xDist = t7.calcXDistToThis(t8);
      assertEquals(-3, xDist, delta);
      assertEquals(-3, t7.getSumOfXDistToThis(), delta);
      
      xDist = t7.calcXDistToThis(t9);
      assertEquals(-5, xDist, delta);
      assertEquals(-8, t7.getSumOfXDistToThis(), delta);

      xDist = t8.calcXDistToThis(t10);
      assertEquals(4, xDist, delta);
      assertEquals(-4, t7.getSumOfXDistToThis(), delta);

}


  @Test
      public void testCalcYDistToThis(){
      Boid t7 = new Boid(0, 0, 0, 1);
      Boid t8 = new Boid(3, 3, -3, -3);
      Boid t9 = new Boid(5, 10, -5, -10);
      Boid t10 = new Boid(-4, 1, 4, -1);
      double delta = 0.0001;
  
      double yDist = t7.calcYDistToThis(t8);
      assertEquals(-3, yDist, delta);
      assertEquals(-3, t7.getSumOfYDistToThis(), delta);

      yDist = t7.calcYDistToThis(t9);
      assertEquals(-5, yDist, delta);
      assertEquals(-8, t7.getSumOfYDistToThis(), delta);

      yDist = t8.calcYDistToThis(t10);
      assertEquals(4, yDist, delta);
      assertEquals(-4, t7.getSumOfYDistToThis(), delta);
}

  @Test
      public void testCalcDistance(){
      Boid t7 = new Boid(0, 0, 0, 1);
      Boid t8 = new Boid(3, 3, -3, -3);
      Boid t9 = new Boid(5, 10, -5, -10);
      Boid t10 = new Boid(-4, 1, 4, -1);
      double delta = 0.0001;

      double distance = t7.calcDistance(t8);
      assertEquals(18, distance, delta);
      distance = t7.calcDistance(t9);
      assertEquals(125, distance, delta);
      distance = t7.calcDistance(t10);
      assertEquals(17, distance, delta);
  }

  @Test
      public void testCalcXSeparationForce(){
      Boid t7 = new Boid(0, 0, 0, 1);
      Boid t8 = new Boid(3, 3, -3, -3);
      Boid t9 = new Boid(5, 10, -5, -10);
      Boid t10 = new Boid(-4, 1, 4, -1);
      double delta = 0.0001;
  }

  @Test
      public void testCalcYSeparationForce(){
      Boid t7 = new Boid(0, 0, 0, 1);
      Boid t8 = new Boid(3, 3, -3, -3);
      Boid t9 = new Boid(5, 10, -5, -10);
      Boid t10 = new Boid(-4, 1, 4, -1);
      double delta = 0.0001;
  }

  @Test
      public void testGetSumXDistToThis(){
      Boid t7 = new Boid(0, 0, 0, 1);
      Boid t8 = new Boid(3, 3, -3, -3);
      Boid t9 = new Boid(5, 10, -5, -10);
      Boid t10 = new Boid(-4, 1, 4, -1);
      double delta = 0.0001;
  }

  @Test
      public void testGetSumYDistToThis(){
      Boid t7 = new Boid(0, 0, 0, 1);
      Boid t8 = new Boid(3, 3, -3, -3);
      Boid t9 = new Boid(5, 10, -5, -10);
      Boid t10 = new Boid(-4, 1, 4, -1);
      double delta = 0.0001;
  }

}