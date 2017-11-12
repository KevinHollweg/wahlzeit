package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LocationTest {
	
	private static Location baseLocation;
	private static Location customLocation;
	
	
	@Before
	public void initial() {
		baseLocation = new Location();
		customLocation = new Location(2.0, 4.0, 3.0);
	}
	
	@Test
	public void testCounstuctor() {
		assertNotNull(baseLocation.coordinate);
		assertNotNull(customLocation.coordinate);
		
	}

}
