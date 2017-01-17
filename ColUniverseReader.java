public class ColUniverseReader extends UniverseReader{
    
    private int numberOfBodies;

    public ColUniverseReader(String fileName){
        In input = new In(fileName);
        int numberBodies = input.readInt();
        numberOfBodies = numberBodies;
        double uniRadius = input.readDouble();
        universeRadius = uniRadius;
        bodies = new Body[numberOfBodies];
        for(int i = 0; i < numberOfBodies; i++)
	    {
		bodies[i] = new ColBody(input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(),input.readDouble(), input.readInt(), input.readInt(), input.readInt());
	    }
    }

    public static void main(String[] args){
        ColUniverseReader test1 = new ColUniverseReader("gravdata/coltest0.txt");
        Body[] test1Bodies = test1.getBodies();
        for(int i = 0; i < test1Bodies.length; i++){
            System.out.println(test1Bodies[i]);
        }
        double test1Radius = test1.getUniverseRadius();
        System.out.println(test1Radius);
    }


}