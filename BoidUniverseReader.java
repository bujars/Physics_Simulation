public class BoidUniverseReader{
    
    private int numberOfBoids;
    private double universeRadius;
    private Boid[] boids;

    public BoidUniverseReader(String fileName){
        In input = new In(fileName);
        int numberBoid = input.readInt();
        numberOfBoids = numberBoid;
        double uniRadius = input.readDouble();
        universeRadius = uniRadius;
        boids = new Boid[numberOfBoids];
        for(int i = 0; i < numberOfBoids; i++)
	    {
		boids[i] = new Boid(input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(), input.readInt(), input.readInt(), input.readInt());
	    }
    }

    public Boid[] getBoids(){
        return boids;
    }

    public double getUniverseRadius(){
        return universeRadius;
    }



    public static void main(String[] args){
        BoidUniverseReader test0 = new BoidUniverseReader("boidtest0.txt");
        Boid[] test0Boids = test0.getBoids();
        for(int i = 0; i < test0Boids.length; i++){
            System.out.println(test0Boids[i]);
        }
        double test0Radius = test0.getUniverseRadius();
        System.out.println(test0Radius);
    }


}