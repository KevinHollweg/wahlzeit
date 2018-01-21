package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CollectorsEditionPhotoManager extends PhotoManager{
	
	protected static final CollectorsEditionPhotoManager instance = new CollectorsEditionPhotoManager();
	//protected static final PhotoManager instance = new PhotoManager();
	
	//private static final Logger log = Logger.getLogger(CollectorsEditionPhotoManager.class.getName());
	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());

	protected Map<PhotoId, CollectorsEditionPhoto> photoCache = new HashMap<PhotoId, CollectorsEditionPhoto>();

	/**
	 * @methodtype factory
	 */
	public CollectorsEditionPhotoManager() {
		super.photoTagCollector = CollectorsEditionPhotoFactory.getInstance().createPhotoTagCollector();	
		//super.photoTagCollector = PhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	//public static final CollectorsEditionPhotoManager getInstance() {
	//	return instance;
	//}
	
//	@Override
/*	public CollectorsEditionPhoto getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		CollectorsEditionPhoto result = doGetPhotoFromId(id);

		if (result == null) {
			result = CollectorsEditionPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	} */
	

}
