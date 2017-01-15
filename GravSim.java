// import java.awt.Color;

/**
 * Class for running a gravity simulation. This class uses
 * {@link GravUniverseReader} to read in data from a text file and a
 * {@link GravEngine} to run the simulation.
 *
 * @author Sean Stern
 * @version 1.0
 */
public class GravSim{

    /**
     * Runs a gravity simulation
     * Required command line argument: fileName
     * Optional command line arguments: timeDelta r-value b-value g-value 
     */
    public static void main(String[] args){
	if(args.length == 0){
	    System.out.println("usage: java GravSim fileName [timeDelta] " +
			       "[r-value] [b-value] [g-value]");
	    return;
	}
	UniverseReader ur = new GravUniverseReader(args[0]);
	double timeDelta = .001;
	if(args.length > 1){
	    timeDelta = Double.parseDouble(args[1]);
	}   
	int r = 0, b = 0, g = 0;
	if(args.length > 4){
	    r = Integer.parseInt(args[2]);
	    b = Integer.parseInt(args[3]);
	    g = Integer.parseInt(args[4]);
	}
	
	/*
        UniverseReader ur = new GravUniverseReader("test1.txt");
	Body[] test1 = ur.getBodies();
        double timeDelta = 0.001;

        if(test1.length > 1){
            timeDelta = 1.0;
        }

        int r = 0, b = 0, g = 0;
        if(test1.length > 4){
            r = Integer.parseInt(test1[2]);
            b = Integer.parseInt(test1[3]);
            g = Integer.parseInt(test1[4]);
        }
	*/

	PhysicsEngine pe = new GravEngine(ur.getBodies(), timeDelta,
					  ur.getUniverseRadius(),
					  r, b, g);
	pe.run();
    }
}