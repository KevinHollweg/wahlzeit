package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;
import java.util.logging.Logger;

public class CollectorsEditionPhotoFactory extends PhotoFactory{
	
	private static final Logger Log = Logger.getLogger(CollectorsEditionPhotoFactory.class.getName());
	
	private static CollectorsEditionPhotoFactory instance = null;
	
	/**
	 * @methodtype constructor
	 */
	protected CollectorsEditionPhotoFactory() {
		// nothing
	}
	
	public static void initialize() {
		getInstance();
	}
	
	/**
	 * @methodetype get
	 */
	public static synchronized CollectorsEditionPhotoFactory getInstance() {
		if (instance == null) {
			Log.config(LogBuilder.createSystemMessage().addAction("setting CollectorsEditionPhotoFactory").toString());
			setInstance(new CollectorsEditionPhotoFactory());
		}
		return instance;
	}
	
	/**
	 * 	 @methodetype set
	 */
	protected static synchronized void setInstance(CollectorsEditionPhotoFactory ColEdPhotoFactory) {

		if (instance != null) {
			throw new IllegalStateException("attempt to initalize CollectorsEditionPhotoFactory twice");
		}
		
		instance  = ColEdPhotoFactory;
	}
	
	/**
	 * @methodetype factory
	 */
	@Override
	public CollectorsEditionPhoto createPhoto() {
		return new CollectorsEditionPhoto();
	}
	
	/**
	 * @methodetype
	 */
	@Override
	public CollectorsEditionPhoto createPhoto(PhotoId id) {
		return new CollectorsEditionPhoto(id);
	}
	
	//public CollectorsEditionPhoto getPhotoFormId(PhotoId id) {
	//	return null;
	//}
	
	@Override
	public CollectorsEditionPhoto loadPhoto(PhotoId id) {
		 /* Photo result =
        		OfyService.ofy().load().type(Photo.class).ancestor(KeyFactory.createKey("Application", "Wahlzeit")).filter(Photo.ID, id).first().now();
		for (PhotoSize size : PhotoSize.values()) {
    		GcsFilename gcsFilename = new GcsFilename("picturebucket", filename);
		}*/
		return null;
	}
	
}
