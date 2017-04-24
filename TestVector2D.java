import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestVector2D{

    @Test
	public void testGetMagnitude(){
	Vector2D v0 = new Vector2D(0.0, 2.0);
	assertEquals(2.0, v0.getMagnitude(), 1E-10);

	Vector2D v1 = new Vector2D(-1.0, 0.0);
	assertEquals(1.0, v1.getMagnitude(), 1E-10);

	Vector2D v2 = new Vector2D(-4.0, -3.0);
	assertEquals(5.0, v2.getMagnitude(), 1E-10);

	Vector2D v3 = new Vector2D(-1.0, 2.0);
	assertEquals(2.2360679775, v3.getMagnitude(), 1E-10);
    }

    @Test
	public void testGetSum(){
	Vector2D v00 = new Vector2D(4.0, 8.0);
	Vector2D v01 = new Vector2D(-5.0, 3.0);
	Vector2D actual0 = v00.getSum(v01);
	Vector2D expect0 = new Vector2D(-1.0, 11.0);
	String msg0 = "Actual: " + actual0 + "\n" +
	        "is not close to\n" +
	    "Expected: " + expect0;
	assertTrue(msg0, actual0.isCloseTo(expect0, 1E-10));
    }

    @Test
	public void testGetDiff(){
	Vector2D v00 = new Vector2D(4.0, 8.0);
	Vector2D v01 = new Vector2D(-5.0, 3.0);
	Vector2D actual0 = v00.getDiff(v01);
	Vector2D expect0 = new Vector2D(9.0, 5.0);
	String msg0 = "Actual: " + actual0 + "\n" +
	        "is not close to\n" +
	    "Expected: " + expect0;
	assertTrue(msg0, actual0.isCloseTo(expect0, 1E-10));
    }

    @Test
	public void testGetScaling(){
	Vector2D v0 = new Vector2D(4.0, 8.0);
	Vector2D actual0 = v0.getScaling(0.5);
	Vector2D expect0 = new Vector2D(2.0, 4.0);
	String msg0 = "Actual: " + actual0 + "\n" +
	        "is not close to\n" +
	    "Expected: " + expect0;
	assertTrue(msg0, actual0.isCloseTo(expect0, 1E-10));
    }

    @Test
	public void testGetNormalization(){
	Vector2D v0 = new Vector2D(3.0, -4.0);
	Vector2D actual0 = v0.getNormalization();
	Vector2D expect0 = new Vector2D(0.6, -0.8);
	String msg0 = "Actual: " + actual0 + "\n" +
	        "is not close to\n" +
	    "Expected: " + expect0;
	assertTrue(msg0, actual0.isCloseTo(expect0, 1E-10));

	Vector2D v1 = new Vector2D(0.0, 0.0);
	Vector2D actual1 = v1.getNormalization();
	Vector2D expect1 = new Vector2D(0.0, 0.0);
	String msg1 = "Actual: " + actual1 + "\n" +
	        "is not close to\n" +
	    "Expected: " + expect1;
	assertTrue(msg1, actual1.isCloseTo(expect1, 1E-10));
    }

    @Test
	public void testIsCloseTo(){
	Vector2D v0 = new Vector2D(3.0, -4.0);
	Vector2D v1 = new Vector2D(3.99, -3.01);
	boolean actual0 = v0.isCloseTo(v1, 1.0);
	String msg0 = "v0: " + v0 + "\n" +
	        "is not considered close to\n" +
	        "v1: " + v1 + "\n" +
	    "within 1.0";
	assertTrue(msg0, actual0);

	boolean actual1 = v0.isCloseTo(v1, 0.9);
	String msg1 = "v0: " + v0 + "\n" +
	        "is considered close to\n" +
	        "v1: " + v1 + "\n" +
	    "within 0.9";
	assertFalse(msg1, actual1);
    }
    
    @Test
	public void testGetCappedVersion(){
	Vector2D v0 = new Vector2D(3.0, 4.0);
	Vector2D v1 = new Vector2D(3.0, 2.0); 
	Vector2D v2 = new Vector2D(3.0, 4.0);
	Vector2D v3 = new Vector2D(2.0, 1.0);
	Vector2D v4 = new Vector2D(1.0, 0.0);
	Vector2D v5 = new Vector2D(1.0, 0.0);
	
	Vector2D exp0 = new Vector2D(1.2, 1.6);
	Vector2D exp1 =new Vector2D(1.2, 1.6);
	Vector2D exp2 =new Vector2D(3.0, 4.0);
	Vector2D exp3 =new Vector2D(2.0, 1.0);
	Vector2D exp4 =new Vector2D(1.0, 0.0);
	Vector2D exp5 =new Vector2D(2.0, 0.0);
    }
}