public class BoidEngine extends PhysicsEngine{

    public BoidEngine(Body[] bodies, double timeDelta, double universeRadius,
		     int bgRed, int bgBlue, int bgGreen){
        super(bodies, timeDelta, universeRadius, bgRed, bgBlue, bgGreen);
    }

    protected void computeForces(){
        for(int i = 0; i < bodies.length; i++){
            for(int j = 0; j < bodies.length; j++){
                if(i != j){
                    bodies[i].addForceFrom(bodies[j]);
                }
            }
        }
    }


}