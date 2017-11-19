package org.wahlzeit.model;


public class SphericCoordinate implements Coordinate{
	
	private double latitude;
	private double longitude;
	private double radius;

	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double z = this.radius * Math.cos(this.longitude);
		double y = this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
		double x = this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public double getCartesianDistance(Coordinate coords) {
		CartesianCoordinate cartCoords = this.asCartesianCoordinate();
		return cartCoords.getCartesianDistance(cartCoords);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate coords) {
		SphericCoordinate spherCoords;
		if( coords == null ){
			return -1.0;
		} else if( coords instanceof CartesianCoordinate ) {
			spherCoords = coords.asSphericCoordinate();
		} else {
			spherCoords = (SphericCoordinate) coords;
		}
		double deltaAngle = Math.acos(Math.sin(this.latitude) * Math.sin(spherCoords.latitude) +
				Math.cos(this.latitude) * Math.cos(spherCoords.latitude * Math.cos(Math.abs(this.longitude - spherCoords.longitude))));
		return this.radius * deltaAngle;
	}

	@Override
	public double getDistance(Coordinate coords) {
		return getSphericDistance(coords);
	}

	@Override
	public boolean isEqual(Coordinate coords) {
		if(coords == null) {
			return false;
		}
		SphericCoordinate spherCoords = coords.asSphericCoordinate();
		if( coords == this ){
			return true;
		} else if( (Math.abs(spherCoords.latitude - this.latitude) < 0.00000001) && (Math.abs(spherCoords.longitude - this.longitude) < 0.00000001) && (Math.abs(spherCoords.radius - this.radius) < 0.00000001) ) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean equals(Object object) {
		if( object == null ) {
			return false;
		} else if( object == this ) {
			return true;
		} else if(object instanceof SphericCoordinate ) {
			return isEqual((Coordinate) object);
		} else {
			return false;
		}
	}

	public double getRadius() {
		return radius;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

}
