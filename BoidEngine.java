public class BoidEngine extends BoidPhysicsEngine{

    public BoidEngine(Boid[] bodies, double timeDelta, double universeRadius,
		     int bgRed, int bgBlue, int bgGreen){
        super(boids, timeDelta, universeRadius, bgRed, bgBlue, bgGreen);
    }

    protected void computeForces(){
        for(int i = 0; i < boids.length; i++){
            for(int j = 0; j < boids.length; j++){
                if(i != j){
                    boids[i].addForceFrom(boids[j]);
                }
            }
        }
    }


}