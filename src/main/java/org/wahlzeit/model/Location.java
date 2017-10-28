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
public class Location {
	
	public Coordinate coordinates;
	
	public Location() {
		this.coordinates = new Coordinate(0.0, 0.0, 0.0);
	}
	
	public Location(double myX, double myY, double myZ) {
		this.coordinates = new Coordinate(myX, myY, myZ);
	}
	
}