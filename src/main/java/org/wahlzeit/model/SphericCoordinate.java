package org.wahlzeit.model;


public class SphericCoordinate extends AbstractCoordinate{
	
	private double latitude;
	private double longitude;
	private double radius;

	/**
	 * constructor, takes x, y, z values as parameters 
	 * @param latitude
	 * @param longitude
	 * @param radius
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	/**
	 *  method to convert this coordinate to a cartesian coordinate
	 *  @return the cartesian representation of this point
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double z = this.radius * Math.cos(this.longitude);
		double y = this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
		double x = this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
		return new CartesianCoordinate(x, y, z);
	}

	/**
	 *  method to calculate the cartesian distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 */
	@Override
	public double getCartesianDistance(Coordinate coords) {
		CartesianCoordinate cartCoords = this.asCartesianCoordinate();
		return cartCoords.getCartesianDistance(cartCoords);
	}

	/**
	 *  method to convert this coordinate to a spheric coordinate
	 *  @return the spheric representation of this point
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	/**
	 *  method to calculate the spheric distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 */
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
		SphericCoordinate spherCoords = coords.asSphericCoordinate();
		if( coords == this ){
			return true;
		} else if( (Math.abs(spherCoords.latitude - this.latitude) < 0.00000001) && (Math.abs(spherCoords.longitude - this.longitude) < 0.00000001) && (Math.abs(spherCoords.radius - this.radius) < 0.00000001) ) {
			return true;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

}
