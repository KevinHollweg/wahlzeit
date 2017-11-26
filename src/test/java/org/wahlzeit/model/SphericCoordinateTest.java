package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {

	private static SphericCoordinate baseCoordinate;
	private static SphericCoordinate customCoordinate;
	
	@Before
	public void initial() {
		baseCoordinate = new SphericCoordinate(0.0, 0.0, 1.0);
		customCoordinate = new SphericCoordinate(2.0, 3.0, 1.0);
	}
	
	@Test
	public void testGetCoordinate() {
		assertNotNull(baseCoordinate.getRadius());
		assertNotNull(baseCoordinate.getLatitude());
		assertNotNull(baseCoordinate.getLongitude());
		assertNotNull(customCoordinate.getRadius());
		assertNotNull(customCoordinate.getLatitude());
		assertNotNull(customCoordinate.getLongitude());
		
		assertEquals(1.0, baseCoordinate.getRadius(), 0.00000001);
		assertEquals(0.0, baseCoordinate.getLatitude(), 0.00000001);
		assertEquals(0.0, baseCoordinate.getLongitude(), 0.00000001);
		assertEquals(1.0, customCoordinate.getRadius(), 0.00000001);
		assertEquals(2.0, customCoordinate.getLatitude(), 0.00000001);
		assertEquals(3.0, customCoordinate.getLongitude(), 0.00000001); 
	}
	
	@Test
	public void testDistance() {
		SphericCoordinate distant = new SphericCoordinate(5.0, 3.0, 1.0);
		double distance0 = 1 * Math.acos(Math.sin(0.0) * Math.sin(5.0) + Math.cos(0.0) * Math.cos(5.0 * Math.cos(Math.abs(0.0 - 3.0))));
		double distance1 = 1 * Math.acos(Math.sin(2.0) * Math.sin(5.0) + Math.cos(2.0) * Math.cos(5.0 * Math.cos(Math.abs(3.0 - 3.0))));
		assertEquals(distance0, baseCoordinate.getSphericDistance(distant), 0.0000001);
		assertEquals(distance1, customCoordinate.getSphericDistance(distant), 0.0000001);
		assertEquals(-1.0,distant.getSphericDistance(null), 0.1);
		
	}
	
	@Test
	public void testCoordinateEquals() {
		SphericCoordinate testPoint0 = new SphericCoordinate(0.0, 0.0, 1.0);
		SphericCoordinate testPoint1  = new SphericCoordinate(2.0, 3.0, 1.0);
		assertTrue(customCoordinate.isEqual(testPoint1));
		assertTrue(customCoordinate.equals(testPoint1));
		assertFalse(baseCoordinate.isEqual(testPoint1));
		assertFalse(customCoordinate.isEqual(testPoint0)); 
		assertFalse(customCoordinate.equals(null));
		assertTrue(customCoordinate.equals(customCoordinate));
	}
	
	@Test
	public void testConversionToCartesianCoordinates() {
		SphericCoordinate testPoint0 = new SphericCoordinate(0.0, 0.0, 0.0);
		SphericCoordinate testPoint1  = new SphericCoordinate(1.0, 2.0, 3.0);
		CartesianCoordinate diffPoint0 = new CartesianCoordinate(0.0, 0.0, 0.0);
		double x = 3.0 * Math.sin(2.0) * Math.cos(1.0);
		double y = 3.0 * Math.sin(2.0) * Math.sin(1.0);
		double z = 3.0 * Math.cos(2.0);
		CartesianCoordinate diffPoint1 = new CartesianCoordinate(x ,y, z);
		assertTrue(testPoint0.asSphericCoordinate().isEqual(diffPoint0));
		assertTrue(testPoint1.asSphericCoordinate().isEqual(diffPoint1));
		assertFalse(testPoint0.asSphericCoordinate().isEqual(diffPoint1));
		
	}
}
