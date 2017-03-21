public class BoidUniverseReader extends UniverseReader{
    
    private int numberOfBoids;

    public BoidUniverseReader(String fileName){
        In input = new In(fileName);
        int numberBoid = input.readInt();
        numberOfBoids = numberBoid;
        double uniRadius = input.readDouble();
        universeRadius = uniRadius;
        bodies = new Body[numberOfBoids];
        for(int i = 0; i < numberOfBoids; i++)
	    {
		bodies[i] = new Boid(input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(), input.readInt(), input.readInt(), input.readInt());
	    }
    }

    public static void main(String[] args){
        BoidUniverseReader test0 = new BoidUniverseReader("boidtest0.txt");
        Body[] test0Boids = test0.getBodies();
        for(int i = 0; i < test0Boids.length; i++){
            System.out.println(test0Boids[i]);
        }
        double test0Radius = test0.getUniverseRadius();
        System.out.println(test0Radius);
    }


}