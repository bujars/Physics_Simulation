import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class TestBoid {

    @Test
	public void testGetXCoord(){
	Boid T0 = new Boid(0, 0, 0, 0);
	Boid T1 = new Boid(4, 3, -1, 1);
	Boid T2 = new Boid(6, -2, 0, 1);
	Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1; 

	assertEquals(0, T0.getXCoord(), delta);
	assertEquals(4, T1.getXCoord(), delta);
	assertEquals(6, T2.getXCoord(), delta);
	assertEquals(5, T3.getXCoord(), delta);

    }

    @Test
	public void testGetYCoord() {
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);	
	double delta = 0.1;
 
	assertEquals(0, T0.getYCoord(), delta);
	assertEquals(3, T1.getYCoord(), delta);
	assertEquals(-2, T2.getYCoord(), delta);
	assertEquals(1, T3.getYCoord(), delta);
    }

    @Test
	public void testGetXVel() {
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
	
	assertEquals(0, T0.getXVel(), delta);
	assertEquals(-1, T1.getXVel(), delta);
	assertEquals(0, T2.getXVel(), delta);
	assertEquals(1, T3.getXVel(), delta);
    }

    @Test
	public void testGetYVel() {
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    
	assertEquals(0, T0.getYVel(), delta);
	assertEquals(1, T1.getYVel(), delta);
	assertEquals(1, T2.getYVel(), delta);
	assertEquals(1, T3.getYVel(), delta);

    }

    @Test
	public void testGetRadius() {
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }

    @Test
	public void testGetRGB() {
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }
    
    
    @Test
	public void testGetMass() {
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }
   
    @Test
	public void testAddForceFrom(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    

	T0.addForceFrom(T1);
	T0.addForceFrom(T2);
	T0.addForceFrom(T3);

	assertEquals(5, T0.getChangeInXVelocity(), delta);
	assertEquals(.6666, T0.getChangeInYVelocity(), delta);
	

    }

   @Test
       public void testAddCohesionForceFrom(){
       Boid T0 = new Boid(0, 0, 0, 0);
       Boid T1 = new Boid(4, 3, -1, 1);
       Boid T2 = new Boid(6, -2, 0, 1);
       Boid T3 = new Boid(5, 1, 1, 1);
       double delta = 0.1;


       T0.addCohesionForceFrom(T1);
       T0.addCohesionForceFrom(T2);
       T0.addCohesionForceFrom(T3);

       assertEquals(5, T0.getChangeInXVelocity(), delta);
       assertEquals(.6666, T0.getChangeInYVelocity(), delta);


   }
    
    @Test
	public void testMove(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    }

    @Test 
	public void testRecordNeighborsPosition(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	T0.recordNeighborsPosition(T1);
	T0.recordNeighborsPosition(T2);
	T0.recordNeighborsPosition(T3);
	
	assertEquals(15, T0.getSumOfNeighborsX(), delta);
	assertEquals(2, T0.getSumOfNeighborsY(), delta);
	assertEquals(3, T0.getCountOfNeighbors(), delta);
    }

    @Test
	public void testGetSumOfNeighborsX(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	//Since we didnt add anything, sum should be zero
	assertEquals(0, T0.getSumOfNeighborsX(), delta);
    }
    
    @Test
	public void testGetSumOfNeighborsY(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	//Since we didnt add anything, sum should be zero                                               
        assertEquals(0, T0.getSumOfNeighborsY(), delta);
    }

    @Test
	public void testCalcXNeighborsCenter(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	T0.recordNeighborsPosition(T1);
	T0.recordNeighborsPosition(T2);
	T0.recordNeighborsPosition(T3);

	assertEquals(15, T0.getSumOfNeighborsX(), delta);
	assertEquals(2, T0.getSumOfNeighborsY(), delta);
	assertEquals(3, T0.getCountOfNeighbors(), delta);


	assertEquals(5, T0.calcXNeighborsCenter(), delta);
    }

    @Test
	public void testCalcYNeighborsCenter(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;
	
	T0.recordNeighborsPosition(T1);
	T0.recordNeighborsPosition(T2);
	T0.recordNeighborsPosition(T3);
	
	assertEquals(15, T0.getSumOfNeighborsX(), delta);
	assertEquals(2, T0.getSumOfNeighborsY(), delta);
	assertEquals(3, T0.getCountOfNeighbors(), delta);

	assertEquals(0.6666, T0.calcYNeighborsCenter(), delta);
    }

    @Test
	public void testCalcXCohesionForce(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	T0.recordNeighborsPosition(T1);
	T0.recordNeighborsPosition(T2);
	T0.recordNeighborsPosition(T3);

	assertEquals(15, T0.getSumOfNeighborsX(), delta);
	assertEquals(2, T0.getSumOfNeighborsY(), delta);
	assertEquals(3, T0.getCountOfNeighbors(), delta);


	assertEquals(5, T0.calcXNeighborsCenter(), delta);

	double xCenter = T0.calcXNeighborsCenter();
	assertEquals(5, T0.calcXCohesionForce(xCenter), delta);
    
    }

   @Test
       public void testCalcYCohesionForce(){
       Boid T0 = new Boid(0, 0, 0, 0);
       Boid T1 = new Boid(4, 3, -1, 1);
       Boid T2 = new Boid(6, -2, 0, 1);
       Boid T3 = new Boid(5, 1, 1, 1);
       double delta = 0.0001;

       T0.recordNeighborsPosition(T1);
       T0.recordNeighborsPosition(T2);
       T0.recordNeighborsPosition(T3);

       assertEquals(15, T0.getSumOfNeighborsX(), delta);
       assertEquals(2, T0.getSumOfNeighborsY(), delta);
       assertEquals(3, T0.getCountOfNeighbors(), delta);


       assertEquals(0.6666, T0.calcYNeighborsCenter(), delta);

       double yCenter = T0.calcYNeighborsCenter();
       assertEquals(0.6666, T0.calcYCohesionForce(yCenter), delta);
   }   
    

    @Test
	public void testGetChangeInXVelocity(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	double changeX = T0.calcXCohesionForce(0.0);
	assertEquals(0, T0.getChangeInXVelocity(), delta);
	

    }

    @Test 
	public void testGetChangeInYVelocity(){
	Boid T0 = new Boid(0, 0, 0, 0);
        Boid T1 = new Boid(4, 3, -1, 1);
        Boid T2 = new Boid(6, -2, 0, 1);
        Boid T3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	double changeY = T0.calcYCohesionForce(0.0);
	assertEquals(0, T0.getChangeInYVelocity(), delta);

    }

}