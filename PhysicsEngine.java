import java.awt.Color;

/**
 * Abstract class for a general purpose physics simulation engine. This class
 * handles running a physics simulation EXCEPT FOR computing the forces on
 * all the {@link Body} objects. Sub-classes just need to implement the
 * {@link #computeForces() computForces} method. 
 *
 * @author Sean Stern
 * @version 1.0
 */
public abstract class PhysicsEngine{
    
    private double dt;
    private Color bgColor;
    protected double uniRad;
    protected Body[] bodies;
    
    
    /**
     * Constructs a {@link PhysicsEngine}
     *
     * @param bodies an array of {@link Body} objects; this represents
     *        all the bodies in the universe
     * @param timeDelta the quantum of time over which the engine applies
     *        forces; similar in concept to a frame rate
     * @param universeRadius the radius of the universe being simulated; the
     *        radius is the minimum distance from the center to an edge of the
     *        universe
     * @param bgRed determines the r-value of the background; should be 0-255
     * @param bgBlue determines the b-value of the background; should be 0-255
     * @param bgGreen determines the g-value of the background; should be 0-255
     */
    public PhysicsEngine(Body[] bodies, double timeDelta,
			 double universeRadius,
			 int bgRed, int bgBlue, int bgGreen){
	this.dt = timeDelta;
	this.uniRad = universeRadius;
	this.bodies = bodies;
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
	for(int i = 0; i < bodies.length; i++){
	    rGB = bodies[i].getRGB();
	    StdDraw.setPenColor(rGB[0], rGB[1], rGB[2]);
	    double bodRad = (bodies[i].getRadius()/100);
	    if(bodRad < 0){
		bodRad = (this.uniRad/100);
	    }
	    StdDraw.filledCircle(bodies[i].getXCoord(), bodies[i].getYCoord(), bodRad);
	}
	// TODO: Copy the offscreen canvs to the onscreen canvas
	StdDraw.show();
	// TODO: Wait for a short amount of time
	StdDraw.pause(1000); //might have to cast dt, ask stern
    }
    
    /**
     * For each body, computes the new position of the body over a single 
     * quantum of time. 
     */
    private void computePositions(){
	// TODO: Move each body
	for(int i = 0; i < bodies.length; i++){
	    bodies[i].move(dt);
	}
    }


    /**
     * For each body, computes the sum of all the foces acting on that body.
     * Different physics simulations use different algorithms to compute 
     * the sume of all the forces--some are more efficient than others.
     */
    protected abstract void computeForces();
}