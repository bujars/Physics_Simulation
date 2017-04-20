import java.awt.Color;    

    public abstract class BoidPhysicsEngine{
    
    private double dt;
    private Color bgColor;
    protected double uniRad;
    protected Boid[] boids;
    
    public BoidPhysicsEngine(Boid[] boids, double timeDelta,
			 double universeRadius,
			 int bgRed, int bgBlue, int bgGreen){
	this.dt = timeDelta;
	this.uniRad = universeRadius;
	this.boids = boids;
	this.bgColor = new Color(bgRed, bgBlue, bgGreen);
    }

    /**
     * Runs the simluation.
     */
    public void run(){
	setUpDrawingCanvas();
	while(true){
	    drawData();
	    computeForces();
	    computePositions();
	}
    }

    /**
     * Scale the drawing window and enable efficient animation.
     */
    private void setUpDrawingCanvas(){
        // TODO: Scale the drawing window so that x and y axes between 
	StdDraw.setScale(-uniRad, +uniRad);
	// TODO: Enable double buffering for efficient animation
	StdDraw.enableDoubleBuffering(); 
	
    }

    /**
     * Draws the data as a 2D visualization for each time step of the 
     */
    private void drawData(){//set radius to negative one, then in engine, if its negative say screw it and choose the radius to draw at a fine - this was done. 
	// TODO: Clear the canvas
	StdDraw.clear(bgColor);
	// TODO: Draw each body on the offscreen canvas
	int[] rGB;
	for(int i = 0; i < boids.length; i++){
	    rGB = boids[i].getRGB();
	    StdDraw.setPenColor(rGB[0], rGB[1], rGB[2]);
	    double boidRad = (boids[i].getRadius()/50);
	    if(boidRad < 0){
		//boidRad = (this.uniRad/50);
		boidRad = 20;
	    }
	    StdDraw.filledCircle((boids[i].getPosition()).getXComp(), (boids[i].getPosition()).getYComp(), boidRad);
	}
	// TODO: Copy the offscreen canvs to the onscreen canvas
	StdDraw.show();
	// TODO: Wait for a short amount of time
	StdDraw.pause(50); //might have to cast dt, ask stern
    }
    
    /**
     * For each body, computes the new position of the body over a single 
     * quantum of time. 
     */
    private void computePositions(){
	// TODO: Move each body
	for(int i = 0; i < boids.length; i++){
	    boids[i].move(dt);
	}
    }


    /**
     * For each body, computes the sum of all the foces acting on that body.
     * Different physics simulations use different algorithms to compute 
     * the sume of all the forces--some are more efficient than others.
     */
    protected abstract void computeForces();
}