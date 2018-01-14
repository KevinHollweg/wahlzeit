package org.wahlzeit.model;

public class CollectorsEdition {

	protected CollectorsEditionType CEType;
	private Location Location;
	
	
	public CollectorsEdition(CollectorsEditionType CEType) {
		this.CEType =  CEType;
		this.Location = new Location();
	}
	
	/**
	 * Getter and setter for Location
	 */
	public Location getLocation() {
		return Location;
	}
	public void setLocation(Location location) {
		Location = location;
	}
	/**
	 * Getter for CEType
	 * @return CEType
	 */
	public CollectorsEditionType getCollectorsEditionType() {
		return CEType;
		
	}
}
