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
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public double getDistance(Coordinate coords) {
		double x2 = (coords.getX() - this.x);
		double y2 = (coords.getY() - this.y);
		double z2 = (coords.getZ() - this.z);
		double underRoot = (x2 * x2) + (y2 * y2) + (z2 * z2);
		double distance = Math.sqrt(underRoot);
		return distance;
	}
	
	public boolean equals(Coordinate coords) {
		return isEqual(coords);
	}
	
	public boolean isEqual(Coordinate coords) {
		if((this.x == coords.getX())&&(this.y == coords.getY()) && (this.z == coords.getZ())){
			return true;
		} else{
			return false;
		}
	}
}