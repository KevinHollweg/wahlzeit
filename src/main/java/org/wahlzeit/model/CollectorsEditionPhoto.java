package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/*@PatternInstance(
	patternName = "Concrete Factory"
	participants = {
		"ConcreteProduct"
	}
)*/
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
		assert myId != null : "null was given as method argument";
		if(myId == null){
			throw new IllegalArgumentException("Null was given as an parameter!");
		}
		super.id = myId;
		
		incWriteCount();
	}
	
	/**
	 * @methodtype boolean-query
	 * @param ColEdPhoto
	 * @return True, if same owner, false, if not
	 */
	public boolean hasSameOwner(CollectorsEditionPhoto ColEdPhoto) {
		assert ColEdPhoto != null : "null was given as method argument";
		if(ColEdPhoto == null){
			throw new IllegalArgumentException("Null was given as an parameter!");
		}
		return ColEdPhoto.getOwnerEmailAddress().equals(super.ownerEmailAddress);
		
	}
}
