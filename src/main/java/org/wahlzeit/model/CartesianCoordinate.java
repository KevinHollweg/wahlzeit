package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Entity;


@Entity
public class CartesianCoordinate implements Coordinate{
	
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
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * getter method for x value 
	 * @return x
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * getter method for y value 
	 * @return y
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * getter method for z value 
	 * @return z
	 */
	public double getZ() {
		return this.z;
	}
	

	/**
	 *  method to forward the java.lang.object method equals() to the implemented method isEqual()
	 *  @param obj
	 *  @return true, if given object is the same as referenced object, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		} else if(obj == this){
			return true;
		} else if(obj instanceof CartesianCoordinate) {
			return isEqual((Coordinate) obj);
		} else {
			return false;
		}
	}
	
	/**
	 * method to check if the given coordinate object is the same as the referenced coordinate object
	 * @param coords
	 * @return true, if both coordinate objects are the same, false otherwise
	 */
	@Override
	public boolean isEqual(Coordinate coords) {
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
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	/**
	 *  method to calculate the distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 */
	@Override
	public double getCartesianDistance(Coordinate coords) {
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
		double distance = Math.sqrt(underRoot);
		return distance;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
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
		return new SphericCoordinate(latitude, longitude, radius);
	}

	@Override
	public double getSphericDistance(Coordinate coords) {
		SphericCoordinate spherCoords = this.asSphericCoordinate();
		return spherCoords.getSphericDistance(coords);
	}

	@Override
	public double getDistance(Coordinate coords) {
		return getCartesianDistance(coords);
	}
}