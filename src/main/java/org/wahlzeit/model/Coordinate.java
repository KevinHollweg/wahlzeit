package org.wahlzeit.model;

import com.google.api.client.util.ArrayMap;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.images.Image;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Parent;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;
import org.wahlzeit.services.ObjectManager;

@Entity
public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	/**
	 *  \brief constructor, takes x, y, z values as parameters 
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
	 *  \brief getter method for x value 
	 * @return x
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 *  \brief getter method for y value 
	 * @return y
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 *  \brief getter method for z value 
	 * @return z
	 */
	public double getZ() {
		return this.z;
	}
	
	/**
	 *  \brief method to calculate the distance between given and and own coordinates
	 * @param coords
	 * @return the calculated distance
	 */
	public double getDistance(Coordinate coords) {
		double x2 = (coords.getX() - this.x);
		double y2 = (coords.getY() - this.y);
		double z2 = (coords.getZ() - this.z);
		double underRoot = (x2 * x2) + (y2 * y2) + (z2 * z2);
		double distance = Math.sqrt(underRoot);
		return distance;
	}
	
	/**
	 *  \brief method to forward the java.lang.object method equals() to the implemented method isEqual()
	 *  @param obj
	 *  @return true, if given object is the same as referenced object, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coordinate){
			return isEqual((Coordinate) obj);
		} else{
			return false;
		}
	}
	
	/**
	 *  \brief method to check if the given coordinate object is the same as the referenced coordinate object
	 * @param coords
	 * @return true, if both coordinate objects are the same, false otherwise
	 */
	public boolean isEqual(Coordinate coords) {
		if((this.x == coords.getX())&&(this.y == coords.getY()) && (this.z == coords.getZ())){
			return true;
		} else{
			return false;
		}
	}
}