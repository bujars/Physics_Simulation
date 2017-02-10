/**
 * Class for reading in a file of two dimensional circular bodies for
 * gravity simulations.
 * @author Sean Stern
 * @version 1.0
 */
public class GravUniverseReader extends UniverseReader{
    
    private int numberOfGravBodies;
    /**
     * Reads a gravitational simulation universe from a file.
     *
     * @param fileName the file that contains the gravity simulation data in
     *        the following format:
     *
     * [integer n representing number of bodies in universe]\n
     * [real number r representing the radius of the universe]\n
     * [real number x-coordinate of body]
     * [real number y-coordinate of body]
     * [real number x-velocity of body] 
     * [real number y-velocity of body]
     * [real number mass of body]
     * [integer red-value using 0-255 RGB color scale]
     * [integer green-value using 0-255 RGB color scale]
     * [integer blue-value using 0-255 RGB color scale]\n
     */ 
    public GravUniverseReader(String fileName){
	In input = new In(fileName);
	int numberGravBodies = input.readInt(); 
	numberOfGravBodies = numberGravBodies;
	double uniRadius = input.readDouble();
	universeRadius = uniRadius;
	bodies = new Body[numberGravBodies];
	for(int i = 0; i < numberOfGravBodies; i++)
	    {
		bodies[i] = new GravBody(input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(),input.readDouble(), input.readInt(), input.readInt(), input.readInt());
	    }
	// TODO: Read in data from file according to format
	// TODO: Initialize parent class's protected instance variables
	// with data read from file
    }

    public static void main(String[] args){
	// TODO: Write simple test of GravUniverseReader here by
	// constructing a GravUniverseReader object and calling
	// the two inherited methods on the GravUniverseReader object.
        // Then print out the information returned from these methods
	// to verify that they worked correctly.
	GravUniverseReader test1 = new GravUniverseReader("gravdata/test2.txt");
	Body[] test1Bodies = test1.getBodies();
	for(int i = 0; i < test1Bodies.length; i++){
	    System.out.println(test1Bodies[i]);
	}
	double test1Radius = test1.getUniverseRadius();
	System.out.println(test1Radius);
    }
}