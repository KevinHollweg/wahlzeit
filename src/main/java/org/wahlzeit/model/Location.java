package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;


@Entity
public class Location {
	
	public Coordinate coordinates;
	
	/**
	 *  \brief default constructor
	 */
	public Location() {
		this.coordinates = new CartesianCoordinate(0.0, 0.0, 0.0);
	}
	
	/**
	 *  \brief constructor to which coordinates can be given
	 * @param myX
	 * @param myY
	 * @param myZ
	 */
	public Location(double myX, double myY, double myZ) {
		this.coordinates = new CartesianCoordinate(myX, myY, myZ);
	}
	
}