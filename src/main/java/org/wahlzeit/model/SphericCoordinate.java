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
		//Precondition
		assert latitude <= Double.MAX_VALUE : "x value is too large";
		assert longitude <= Double.MAX_VALUE : "y value is too large";
		assert radius <= Double.MAX_VALUE : "z value is too large";
				
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
		//Postcondition
		assert latitude == this.latitude : "couldn't write varibale x";
		assert longitude == this.longitude : "couldn't write varibale y";
		assert radius == this.radius : "couldn't write varibale z";
	}
	
	/**
	 *  method to convert this coordinate to a cartesian coordinate
	 *  @return the cartesian representation of this point
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		//no Precondition, because no input is given to that function
		double z = this.radius * Math.cos(this.longitude);
		double y = this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
		double x = this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
		CartesianCoordinate result = new CartesianCoordinate(x, y, z);
		
		//Postcondition
		assert result != null : "creation of new CartesianCoordinate object failed";
		
		return result;
	}

	/**
	 *  method to calculate the cartesian distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 */
	@Override
	public double getCartesianDistance(Coordinate coords) {
		//Precondition
		assert coords != null : "null was given as method argument";
		
		CartesianCoordinate cartCoords = this.asCartesianCoordinate();
		double result = cartCoords.getCartesianDistance(cartCoords);
		
		//Postcondition
		assert result >= 0 : "getCartesianDistance() produced an calculation error";
		
		return result;
	}

	/**
	 *  method to convert this coordinate to a spheric coordinate
	 *  @return the spheric representation of this point
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
		return this;
	}

	/**
	 *  method to calculate the spheric distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance, -1.0, if coords is invalid
	 */
	@Override
	public double getSphericDistance(Coordinate coords) {
		//Precondition
		assert coords != null : "null was given as Method argument";
				
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
		double result = this.radius * deltaAngle;
		
		//Postcondition
		assert result >= 0 : "overflow detected";
		
		return result;
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
		SphericCoordinate spherCoords = coords.asSphericCoordinate();
		if( coords == this ){
			return true;
		} else if( (Math.abs(spherCoords.latitude - this.latitude) < 0.00000001) && (Math.abs(spherCoords.longitude - this.longitude) < 0.00000001) && (Math.abs(spherCoords.radius - this.radius) < 0.00000001) ) {
			return true;
		} else {
			return false;
		}
		//no Postcondition, because state of object wasn't changed
	}

	/**
	 * getter method for radius value 
	 * @return radius
	 */
	public double getRadius() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
		return radius;
	}

	/**
	 * getter method for longitude value 
	 * @return longitude
	 */
	public double getLongitude() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
		return longitude;
	}

	/**
	 * getter method for latitude value 
	 * @return latitude
	 */
	public double getLatitude() {
		//no Precondition, because no input is given to this method 
		//no Postcondition, because object state isn't changed
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
