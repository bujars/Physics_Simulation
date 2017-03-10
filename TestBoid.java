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
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.1;
    

	t0.addForceFrom(t1);
	t0.addForceFrom(t2);
	t0.addForceFrom(t3);

	assertEquals(5, t0.getChangeInXVelocity(), delta);
	assertEquals(.6666, t0.getChangeInYVelocity(), delta);
	

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
	assertEquals(0, T0.getSumOfNeighborsX(), delta);
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


	assertEquals(5, T0.calcXNeighborsCenter(), delta);
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

	double changeX = t0.calcXCohesionForce(0);
	assertEquals(0, t0.getChangeInXVelocity(), delta);
	

    }

    @Test 
	public void testGetChangeInYVelocity(){
	Boid t0 = new Boid(0, 0, 0, 0);
        Boid t1 = new Boid(4, 3, -1, 1);
        Boid t2 = new Boid(6, -2, 0, 1);
        Boid t3 = new Boid(5, 1, 1, 1);
	double delta = 0.0001;

	double changeY = t0.calcYCohesionForce(0);
	assertEquals(0, t0.getChangeInYVelocity(), delta);

    }

    @Test
	public void testRecordNeighborsVelocities(){

    }
    
    @Test
	public void testCalcXAlignmentForce(){

    }

    @Test 
	public void testCalcYAlignmentForce(){

    }

    @Test
	public void testGetSumOfXVelocities(){

    }
    
    @Test
	public void testGetSumOfYVelocities(){
	
    }
    
    @Test
	public voi testAddAlignmentForceFrom(){

    }
}