package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCoordinate implements Coordinate{
	
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	@Override
	public abstract double getCartesianDistance(Coordinate coords);
	
	@Override
	public abstract SphericCoordinate asSphericCoordinate();
	
	@Override
	public abstract double getSphericDistance(Coordinate coords);
	
	@Override
	public abstract boolean isEqual(Coordinate coords);
	
	//@Override 
	//public abstract CartesianCoordinate makeCartesianCoordinate(double x, double y, double z);
	
	/**
	 *  method to calculate the cartesian distance between a given point a the
	 *  point on which this method is called
	 *  @param coords
	 *  @return cartesian distance
	 */
	@Override
	public double getDistance(Coordinate coords) {
		if(coords == null){
			throw new IllegalArgumentException("Null was given as an parameter!");
		}
		return getCartesianDistance(coords);
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
		} else if(obj instanceof SphericCoordinate) {
			return isEqual((Coordinate) obj);
		} else {
			return false;
		}
	}
	
	protected abstract void assertClassInvariants();
	
	protected static List<Coordinate> CoordinateListCart = new ArrayList<Coordinate>();
	protected static List<Coordinate> CoordinateListSpher = new ArrayList<Coordinate>();
}
