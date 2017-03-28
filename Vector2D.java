public class Vector2D{

    private double xComp;
    private double yComp;

    /**
     * Constructs a new Vector2D object
     * @param x the x-component of the vector
     * @param y the y-component of the vector
     */
    public Vector2D(double x, double y){
	xComp = x;
	yComp = y;
    }

    /**
     * Gets the magnitude/length of the vector
     * @return the magnitude/length of the vector
     */
    public double getMagnitude(){
	return Math.sqrt(xComp * xComp + yComp * yComp);
    }

    /**
     * Gets the x-component of the vector
     * @return the x-component of the vector
     */
    public double getXComp(){
	return xComp;
    }

    /**
     * Gets the y-component of the vector
     * @return the y-component of hte vector
     */
    public double getYComp(){
	return yComp;
    }

    /**
     * Gets the sum/addition of two vectors. NOTE: This
     * method DOES NOT MUTATE the Vector2D object.
     * @param v an addend vector
     * @return a NEW Vector2D object representing the
     *         sum of the two vectors
     */
    public Vector2D getSum(Vector2D v){
	return new Vector2D(this.xComp + v.xComp,
			    this.yComp + v.yComp);
    }

    /**
     * Gets the difference/subtraction of two vectors. 
     * NOTE: This method DOES NOT MUTATE the Vector2D 
     * object.
     * @param v the subtrahend vector
     * @return a NEW Vector2D object representing the
     *         difference/subtration of the two vectors
     */
    public Vector2D getDiff(Vector2D v){
	return new Vector2D(this.xComp - v.xComp,
			    this.yComp - v.yComp);
    }

    /**
     * Gets the vector that results from scaling this
     * vector. NOTE: This method DOES NOT MUTATE the
     * Vector2D object.
     * @param scaleFactor the factor by which to scale
     * @return a NEW Vector2D object representing the
     *         result of scaling this vector.
     */
    public Vector2D getScaling(double scaleFactor){
	return new Vector2D(this.xComp * scaleFactor,
			    this.yComp * scaleFactor);
    } 

    /** 
     * Gets the vector that results from normalizing
     * this vector. NOTE: This method DOES NOT MUTATE
     * the Vector2D object.
     * @return a NEW Vector2D object representing the
     *         result of normalizing this vector.
     */
    public Vector2D getNormalization(){
	double mag = getMagnitude();
	if(mag > 0.0){
	    return new Vector2D(this.xComp/mag,
				this.yComp/mag);
	}
	else{
	    return new Vector2D(0.0, 0.0);
	}
	
    }

    /**
     * Compares two vectors and returns true when both
     * the x and y-components of the vectors are within
     * delta of one another.
     * @param v the comparison vector
     * @param delta the maximum difference between the
     *        x and y-compnents of the vectors such that
     *        they are deemed "close to" one another 
     * @returns true when the x and y-components of the
     *          vectors are within delta of one another
     */
    public boolean isCloseTo(Vector2D v, double delta){
	return (Math.abs(this.xComp - v.xComp) < delta) &&
	    (Math.abs(this.yComp - v.yComp) < delta);
    }

    /**
     * Returns a String representation of this vector
     * @return a String representation of this vector
     */
    public String toString(){
	return this.getClass() + "\n" +
	        "{x-component: " + xComp + ",\n" +
	    "{y-component: " + yComp + "}";
    }

    

}