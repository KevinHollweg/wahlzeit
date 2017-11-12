package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Entity;


@Entity
public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * constructor, takes x, y, z values as parameters 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Coordinate(double x, double y, double z) {
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
	 *  method to calculate the distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 */
	public double getDistance(Coordinate coords) {
		if(coords == null) {
			return -1.0;
		}
		double deltaX = (coords.getX() - this.x);
		double deltaY = (coords.getY() - this.y);
		double deltaZ = (coords.getZ() - this.z);
		double underRoot = (deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ);
		double distance = Math.sqrt(underRoot);
		return distance;
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
		} else if(obj instanceof Coordinate) {
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
	public boolean isEqual(Coordinate coords) {
		if(coords == null) {
			return false;
		} else if(coords == this){
			return true;
		} else if((Math.abs(coords.getX() - this.x) < 0.00000001) && (Math.abs(coords.getY() - this.y) < 0.00000001) && (Math.abs(coords.getZ() - this.z) < 0.00000001)) {
			return true;
		} else {
			return false;
		}
	}
}