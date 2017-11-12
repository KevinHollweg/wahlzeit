package org.wahlzeit.model;

public class CollectorsEditionPhoto extends Photo{
	
	/**
	 * @methodtype constructor 
	 */
	public CollectorsEditionPhoto() {
		super.id = PhotoId.getNextId();
		incWriteCount();
	}
	
	/**
	 * @methodtype constructor 
	 */
	public CollectorsEditionPhoto(PhotoId myId) {
		super.id = myId;
		
		incWriteCount();
	}
	
	/**
	 * @methodtype boolean-query
	 * @param ColEdPhoto
	 * @return True, if same owner, false, if not
	 */
	public boolean hasSameOwner(CollectorsEditionPhoto ColEdPhoto) {
		return ColEdPhoto.getOwnerEmailAddress().equals(super.ownerEmailAddress);
		
	}
}
