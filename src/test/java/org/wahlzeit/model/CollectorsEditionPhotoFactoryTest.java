package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CollectorsEditionPhotoFactoryTest {

	private CollectorsEditionPhotoFactory colEdPhotoFac; 
	
	@Before
	public void initial() {
		colEdPhotoFac.initialize();
		colEdPhotoFac = colEdPhotoFac.getInstance();
	}
	
	@Test
	public void CreatePhotoTest() {
		CollectorsEditionPhoto ColEdPhoto = colEdPhotoFac.createPhoto();
		assertNotNull(ColEdPhoto);
	}
}
