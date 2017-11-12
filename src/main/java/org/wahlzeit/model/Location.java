package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Location {
	
	public Coordinate coordinate;
	
	/**
	 *  default constructor
	 */
	public Location() {
		this.coordinate = new Coordinate(0.0, 0.0, 0.0);
	}
	
	/**
	 * constructor to which coordinates can be given
	 * @param myX
	 * @param myY
	 * @param myZ
	 */
	public Location(double myX, double myY, double myZ) {
		this.coordinate = new Coordinate(myX, myY, myZ);
	}
	
}