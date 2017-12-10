package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Entity;


@Entity
public class CartesianCoordinate extends AbstractCoordinate{
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * constructor, takes x, y, z values as parameters 
	 * @param x
	 * @param y
	 * @param z
	 */
	public CartesianCoordinate(double x, double y, double z) {
		//Precondition
		assert x <= Double.MAX_VALUE : "x value is too large";
		assert y <= Double.MAX_VALUE : "y value is too large";
		assert z <= Double.MAX_VALUE : "z value is too large";
		
		if(x <= Double.MAX_VALUE || y <= Double.MAX_VALUE || z <= Double.MAX_VALUE) {
			throw new IllegalArgumentException("The given values aren't vaild!");
		}
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		//Postcondition
		assert x == this.x : "couldn't write varibale x";
		assert y == this.y : "couldn't write varibale y";
		assert z == this.z : "couldn't write varibale z";

	}
	
	/**
	 * getter method for x value 
	 * @return x
	 */
	public double getX() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
		return this.x;
	}
	
	/**
	 * getter method for y value 
	 * @return y
	 */
	public double getY() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
		return this.y;
	}
	
	/**
	 * getter method for z value 
	 * @return z
	 */
	public double getZ() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
		return this.z;
	}
	
	/**
	 * method to check if the given coordinate object is the same as the referenced coordinate object
	 * @param coords
	 * @return true, if both coordinate objects are the same, false otherwise
	 */
	@Override
	public boolean isEqual(Coordinate coords) {
		//no Precondition, because every input can be given to this method 
		if(coords == null) {
			return false;
		} 
		CartesianCoordinate cartCoords = coords.asCartesianCoordinate();
		 if(coords == this){
			return true;
		} else if((Math.abs(cartCoords.getX() - this.x) < 0.00000001) && (Math.abs(cartCoords.getY() - this.y) < 0.00000001) && (Math.abs(cartCoords.getZ() - this.z) < 0.00000001)) {
			return true;
		} else {
			return false;
		}
		//no Postcondition, because state of object wasn't changed
	}
	
	/**
	 *  method to convert this coordinate to a cartesian coordinate
	 *  @return the cartesian representation of this point
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
		return this;
	}
	
	/**
	 *  method to calculate the cartesian distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 * @pre coords != null
	 * @post distance is valid
	 */
	@Override
	public double getCartesianDistance(Coordinate coords) {
		//class invariant
		assertClassInvariants();
		//Precondition
		assert coords != null : "null was given as Method argument";
		if(coords == null){
			throw new IllegalArgumentException("Null was given as an parameter!");
		}
		
		double underRoot = doGetCartesianDistance(coords);
		
		//Postcondition
		assert underRoot >= 0 : "overflow detected";
		if(underRoot < 0) {
			throw new IllegalStateException("Distance wasn't calculated correctly!");
		}
		
		double distance = Math.sqrt(underRoot);
		
		//class invariant
		assertClassInvariants();
		return distance;
	}
	
	/**
	 * Method that does the actual work for getCartesianDistance
	 * @param coords
	 * @return underRoot value for distance calculating
	 */
	protected double doGetCartesianDistance(Coordinate coords) {
		CartesianCoordinate cartCoords;
		if( coords == null ) {
			return -1.0;
		} else if( coords instanceof SphericCoordinate) {
			cartCoords = coords.asCartesianCoordinate();
		} else {
			cartCoords = (CartesianCoordinate) coords;
		}
		double deltaX = (cartCoords.getX() - this.x);
		double deltaY = (cartCoords.getY() - this.y);
		double deltaZ = (cartCoords.getZ() - this.z);
		double underRoot = (deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ);
		
		return underRoot;
	}

	/**
	 *  method to convert this coordinate to a spheric coordinate
	 *  @return the spheric representation of this point
	 *  @post result != null
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		//class invariant
		assertClassInvariants();
		//no Precondition, because no input is given to that function
		
		SphericCoordinate result = doAsSphericCoordinate();
		
		//Postcondition
		assert result != null : "creation of new SphericCoordinate object failed";		
		if(result == null){
			throw new IllegalArgumentException("Could not create new SphericCoordinate object!");
		}
		//class invariant
		assertClassInvariants();
		
		return result;
	}
	
	/**
	 *  method that does the actual work in converting the cartesian representation to a spheric one
	 *  @return the spheric representation of this point
	 */
	protected SphericCoordinate doAsSphericCoordinate() {
		double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		assert radius <= Double.MAX_VALUE : "overflow detected";
		
		double longitude;
		if(radius == 0) {
			longitude = 0;
		} else {
			longitude = Math.acos(this.z / radius);
		}
		double latitude;
		if(this.x == 0){
			latitude = 0;
		} else {
			latitude = Math.atan(this.y / this.x);
		}	
		SphericCoordinate result = new SphericCoordinate(latitude, longitude, radius);
		
		return result;
	}

	/**
	 *  method to calculate the spheric distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 * @pre coords != null
	 * @post result >= 0
	 */
	@Override
	public double getSphericDistance(Coordinate coords) {
		//class invariant
		assertClassInvariants();
		//Precondition
		assert coords != null : "null was given as method argument";
		if(coords == null){
			throw new IllegalArgumentException("Null was given as an parameter!");
		}
		
		SphericCoordinate spherCoords = this.asSphericCoordinate();
		double result = spherCoords.getSphericDistance(coords);
		
		//Postcondition
		assert result >= 0 : "getSphericDistance() produced an calculation error";
		if(result < 0) {
			throw new IllegalStateException("Distance wasn't calculated correctly!");
		}
		//class invariant
		assertClassInvariants();
		
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/**
	 * Method that checks the internal attributes of an CartesianCoordinate Object for plausibility 
	 */
	@Override
	protected void assertClassInvariants() {
		assert this.x != Double.NaN : "No valid value for X";
		assert this.y != Double.NaN : "No valid value for Y";
		assert this.z != Double.NaN : "No valid value for Z";
		
		assert this.x != Double.POSITIVE_INFINITY : "Value for X too big";
		assert this.y != Double.POSITIVE_INFINITY : "Value for Y too big";
		assert this.z != Double.POSITIVE_INFINITY : "Value for Z too big";
		
		assert this.x != Double.NEGATIVE_INFINITY : "Value for X too small";
		assert this.x != Double.NEGATIVE_INFINITY : "Value for Y too small";
		assert this.x != Double.NEGATIVE_INFINITY : "Value for Z too small";
	}

}