package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;

@PatternInstance(
	patternName = "Abstract Factory",
	participants = {
		"AbstractProduct"
	}
)
@Subclass
public class CollectorsEditionPhoto extends Photo{
	
	@Serialize 
	public CollectorsEdition CollectorsEdition;

	/**
	 * @methodtype constructor 
	 */
	public CollectorsEditionPhoto() {
		super.id = PhotoId.getNextId();
		this.CollectorsEdition = CollectorsEditionManager.createCollectorsEdition();
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

		this.CollectorsEdition = CollectorsEditionManager.createCollectorsEdition();
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
