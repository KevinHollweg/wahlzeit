package org.wahlzeit.model;

public interface Coordinate {
	
	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate coords);
	
	public SphericCoordinate asSphericCoordinate();
	
	public double getSphericDistance(Coordinate coords);
	
	public double getDistance(Coordinate coords);
	
	public boolean isEqual(Coordinate coords);
}
