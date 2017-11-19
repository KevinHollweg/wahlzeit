package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CollectorsEditionPhoto extends Photo{
	
	public int preis = 0;

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
