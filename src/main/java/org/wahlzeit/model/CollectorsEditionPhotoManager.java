package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CollectorsEditionPhotoManager extends PhotoManager{
	
	protected static final CollectorsEditionPhotoManager instance = new CollectorsEditionPhotoManager();
	
	private static final Logger log = Logger.getLogger(CollectorsEditionPhotoManager.class.getName());

	protected Map<PhotoId, CollectorsEditionPhoto> photoCache = new HashMap<PhotoId, CollectorsEditionPhoto>();

	/**
	 * @methodtype factory
	 */
	public CollectorsEditionPhotoManager() {
		super.photoTagCollector = CollectorsEditionPhotoFactory.getInstance().createPhotoTagCollector();	
	}
	
	public static final CollectorsEditionPhotoManager getInstance() {
		return instance;
	}

	



}
