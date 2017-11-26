package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;


@Entity
public class Location {
	
	public Coordinate coordinate;
	
	/**
	 *  default constructor
	 */
	public Location() {
		this.coordinate = new CartesianCoordinate(0.0, 0.0, 0.0);
	}
	
	/**
	 *  constructor to create a Location object with custom Cartesian coordinates
	 * @param myX
	 * @param myY
	 * @param myZ
	 */
	public Location(double myX, double myY, double myZ) {
		this.coordinate = new CartesianCoordinate(myX, myY, myZ);
	}
	
	/**
	 *  constructor to create a Location object with custom Spheric coordinates
	 *  the earths radius is used as radius
	 * @param myLatitude
	 * @param myLongitude
	 */
	public Location(double myLatitude, double myLongitude) {
		this.coordinate = new SphericCoordinate(myLatitude, myLongitude, 6378.137);
	}
	
	/**
	 * @methodtype setter for coordinate attribute
	 * @param coords
	 */
	public void setCoordinate(Coordinate coords) {
		this.coordinate = coords;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
}