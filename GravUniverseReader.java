/**
 * Class for reading in a file of two dimensional circular bodies for
 * gravity simulations.
 * @author Sean Stern
 * @version 1.0
 */
public class GravUniverseReader extends UniverseReader{
    
    private int numberOfGravBodies;
    private double universeRadius;
    private Body[] bodies;
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
	numberOfGravBodies = input.readInt(); 
	universeRadius = input.readDouble();
	bodies = new Body[numberOfGravBodies];
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
	GravUniverseReader test1 = new GravUniverseReader("test1.txt");
	Body[] test1Bodies = test1.getBodies();
	System.out.println(test1Bodies[0]);
	double test1Radius = test1.getUniverseRadius();



	//GravUniverseReader test2 = new GravUniverseReader("test2.txt");

    }
}