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
	Vector2D exp1 =new Vector2D(2.5, 1.7);
	Vector2D exp2 =new Vector2D(3.0, 4.0);
	Vector2D exp3 =new Vector2D(2.0, 1.0);
	Vector2D exp4 =new Vector2D(1.0, 0.0);
	Vector2D exp5 =new Vector2D(2.0, 0.0);
	
	Vector2D actual00 = v0.getCappedVersion(2.0, 1.0);
	Vector2D actual01 = v1.getCappedVersion(3.0, 1.0);
	Vector2D actual02 = v2.getCappedVersion(5.0, 2.0);
	Vector2D actual03 = v3.getCappedVersion(5.0, 2.0);
	Vector2D actual04 = v4.getCappedVersion(2.0, 1.0);
	Vector2D actual05 = v5.getCappedVersion(3.0, 2.0);

	String msg0 = "Actual: " + actual00 + "\n" + "is not close to\n" + "Expected: " + exp0;
	String msg1 = "Actual: " + actual01 + "\n" + "is not close to\n" + "Expected: " + exp1;
	String msg2 = "Actual: " + actual02 + "\n" + "is not close to\n" + "Expected: " + exp2;
        String msg3 = "Actual: " + actual03 + "\n" + "is not close to\n" + "Expected: " + exp3;
	String msg4 = "Actual: " + actual04 + "\n" + "is not close to\n" + "Expected: " + exp4;
        String msg5 = "Actual: " + actual05 + "\n" + "is not close to\n" + "Expected: " + exp5;
	assertTrue(msg0, actual00.isCloseTo(exp0, 1E-1));
	assertTrue(msg1, actual01.isCloseTo(exp1, 1E-1));
	assertTrue(msg2, actual02.isCloseTo(exp2, 1E-1));
        assertTrue(msg3, actual03.isCloseTo(exp3, 1E-1));
	assertTrue(msg4, actual04.isCloseTo(exp4, 1E-1));
        assertTrue(msg5, actual05.isCloseTo(exp5, 1E-1));
    }
    
    @Test
	public void testCalcRoatedVector2D(){
	Vector2D tip = new Vector2D(1.2, 1.6);
	Vector2D expLeft = new Vector2D(-1.9856, 0.2392);
	Vector2D expRight = new Vector2D(0.7856, -1.8392);

	Vector2D actLeft = tip.calcRotatedVector2D(2.0944);
	Vector2D actRight = tip.calcRotatedVector2D(4.18879);
	
	String msgLeft = "Actual: " + actLeft + "\n" + "is not close to\n" + "Expected: " + expLeft;
	String msgRight = "Actual: " + actRight + "\n" + "is not close to\n" + "Expected: " + expRight;

	assertTrue(msgLeft, actLeft.isCloseTo(expLeft, 1E-3));
	assertTrue(msgRight, actRight.isCloseTo(expRight, 1E-3));

    }
	
}