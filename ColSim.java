public class ColSim {

    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("usage: java ColSim fileName [timeDelta] " +
                               "[r-value] [b-value] [g-value]");
            return;
        }
        UniverseReader ur = new ColUniverseReader(args[0]);
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
	PhysicsEngine pe = new ColEngine(ur.getBodies(), timeDelta,
                                          ur.getUniverseRadius(),
                                          r, b, g);
        pe.run();
    }

}