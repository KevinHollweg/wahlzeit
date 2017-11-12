package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	
	private static Coordinate baseCoordinate;
	private static Coordinate customCoordinate;
	
	@Before
	public void initial() {
		baseCoordinate = new Coordinate(0.0, 0.0, 0.0);
		customCoordinate = new Coordinate(3.0, 5.0, 1.0);
	}
	
	@Test
	public void testGetCoordinate() {
		assertNotNull(baseCoordinate.getX());
		assertNotNull(baseCoordinate.getY());
		assertNotNull(baseCoordinate.getZ());
		assertNotNull(customCoordinate.getX());
		assertNotNull(customCoordinate.getY());
		assertNotNull(customCoordinate.getZ());
		
		assertEquals(0.0, baseCoordinate.getX(), 0.00001);
		assertEquals(0.0, baseCoordinate.getY(), 0.00001);
		assertEquals(0.0, baseCoordinate.getZ(), 0.00001);
		assertEquals(3.0, customCoordinate.getX(), 0.00001);
		assertEquals(5.0, customCoordinate.getY(), 0.00001);
		assertEquals(1.0, customCoordinate.getZ(), 0.00001);
	}
	
	@Test
	public void testDistance() {
		Coordinate distant = new Coordinate(2.0, 3.0, 4.0);
		double distance0 = Math.sqrt((2.0 * 2.0) + (3.0 * 3.0) + (4.0 * 4.0));
		double distance1 = Math.sqrt(((2.0 - 3.0) * (2.0 - 3.0)) + ((3.0 - 5.0) * (3.0 - 5.0)) + ((4.0 - 1.0) * (4.0 - 1.0)));
		assertEquals(distance0, baseCoordinate.getDistance(distant), 0.0001);
		assertEquals(distance1, customCoordinate.getDistance(distant), 0.0001);
		assertEquals(distant.getDistance(null), -1.0, 0.1);
		
	}
	
	@Test
	public void testCoordinateEquals() {
		Coordinate testPoint0 = new Coordinate(3.0, 5.0, 1.0);
		Coordinate testPoint1  = new Coordinate(3.1, 4.0, 1.5);
		assertTrue(customCoordinate.isEqual(testPoint0));
		assertTrue(customCoordinate.equals(testPoint0));
		assertFalse(baseCoordinate.isEqual(testPoint1));
		assertFalse(customCoordinate.isEqual(testPoint1));
		assertFalse(customCoordinate.equals(null));
		assertTrue(customCoordinate.equals(customCoordinate));
	}
}
