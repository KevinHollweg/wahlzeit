package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CartesianCoordinateTest {
	
	
	private static CartesianCoordinate baseCoordinate;
	private static CartesianCoordinate customCoordinate;
	
	@Before
	public void initial() {
		baseCoordinate = new CartesianCoordinate(0.0, 0.0, 0.0);
		customCoordinate = new CartesianCoordinate(3.0, 5.0, 1.0);
	}
	
	@Test
	public void testGetCoordinate() {
		assertNotNull(baseCoordinate.getX());
		assertNotNull(baseCoordinate.getY());
		assertNotNull(baseCoordinate.getZ());
		assertNotNull(customCoordinate.getX());
		assertNotNull(customCoordinate.getY());
		assertNotNull(customCoordinate.getZ());
		
		assertEquals(0.0, baseCoordinate.getX(), 0.00000001);
		assertEquals(0.0, baseCoordinate.getY(), 0.00000001);
		assertEquals(0.0, baseCoordinate.getZ(), 0.00000001);
		assertEquals(3.0, customCoordinate.getX(), 0.00000001);
		assertEquals(5.0, customCoordinate.getY(), 0.00000001);
		assertEquals(1.0, customCoordinate.getZ(), 0.00000001); 
	}
	
	@Test
	public void testDistance() {
		CartesianCoordinate distant = new CartesianCoordinate(2.0, 3.0, 4.0);
		double distance0 = Math.sqrt((2.0 * 2.0) + (3.0 * 3.0) + (4.0 * 4.0));
		double distance1 = Math.sqrt(((2.0 - 3.0) * (2.0 - 3.0)) + ((3.0 - 5.0) * (3.0 - 5.0)) + ((4.0 - 1.0) * (4.0 - 1.0)));
		assertEquals(distance0, baseCoordinate.getDistance(distant), 0.0001);
		assertEquals(distance1, customCoordinate.getDistance(distant), 0.0001);
		assertEquals(distant.getDistance(null), -1.0, 0.1);
		
	}
	
	@Test
	public void testCoordinateEquals() {
		CartesianCoordinate testPoint0 = new CartesianCoordinate(3.0, 5.0, 1.0);
		CartesianCoordinate testPoint1  = new CartesianCoordinate(3.1, 4.0, 1.5);
		assertTrue(customCoordinate.isEqual(testPoint0));
		assertTrue(customCoordinate.equals(testPoint0));
		assertFalse(baseCoordinate.isEqual(testPoint1));
		assertFalse(customCoordinate.isEqual(testPoint1)); 
		assertFalse(customCoordinate.equals(null));
		assertTrue(customCoordinate.equals(customCoordinate));
	}
	
	@Test
	public void testConversionToSphericCoordinates() {
		CartesianCoordinate testPoint0 = new CartesianCoordinate(0.0, 0.0, 0.0);
		CartesianCoordinate testPoint1  = new CartesianCoordinate(1.0, 2.0, 3.0);
		SphericCoordinate diffPoint0 = new SphericCoordinate(0.0, 0.0, 0.0);
		double rad = Math.sqrt(1.0 * 1.0 + 2.0 * 2.0 + 3.0 * 3.0);
		double longi = Math.acos(3.0 / rad);
		double lati = Math.atan(2.0 / 1.0);
		SphericCoordinate diffPoint1 = new SphericCoordinate(lati, longi, rad);
		assertTrue(testPoint0.asSphericCoordinate().isEqual(diffPoint0));
		assertTrue(testPoint1.asSphericCoordinate().isEqual(diffPoint1));
		assertFalse(testPoint0.asSphericCoordinate().isEqual(diffPoint1));
		
	}
}
