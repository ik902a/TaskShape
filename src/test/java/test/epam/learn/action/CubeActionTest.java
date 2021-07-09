package test.epam.learn.action;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.learn.action.CubeAction;
import by.epam.learn.entity.Cube;
import by.epam.learn.entity.CustomPoint;

public class CubeActionTest {
	CubeAction action;
	
	@BeforeClass
	public void setUp() {
		action = new CubeAction();
	}
	
	@AfterClass
	public void tearDown() {
		action = null;
	}
	
	@Test (dataProvider = "cubes-area")
	public void testArea(Cube cube, double expected) {
		double actual = action.area(cube);
		assertEquals(actual, expected, 0.0001);
	}
	
	
	@Test (dataProvider = "cubes-volume")
	public void testVolume(Cube cube, double expected) {
		double actual = action.volume(cube);
		assertEquals(actual, expected, 0.0001);
	}
	
	@Test (dataProvider = "cubes-dissectionXY")
	public void testDissectionXY(Cube cube, double expected) {
		double actual = action.dissectionXY(cube);
		assertEquals(actual, expected, 0.0001);
	}
	
	
	@Test (dataProvider = "cubes-dissectionYZ")
	public void testDissectionYZ(Cube cube, double expected) {
		double actual = action.dissectionYZ(cube);
		assertEquals(actual, expected, 0.0001);
	}

	
	@DataProvider(name = "cubes-area")
	public Object[] createArea() {
		return new Object[][] { { new Cube(new CustomPoint(0, 1, 0), new CustomPoint(1, 1, 1)), 6.0},
								{ new Cube(new CustomPoint(0, -3, 2), new CustomPoint(3, -3, -1)), 54.0},
								{ new Cube(new CustomPoint(21, 4, 5), new CustomPoint(17, 4, 9)), 96.0} };
	}
	
	@DataProvider(name = "cubes-volume")
	public Object[] createVolume() {
		return new Object[][] { { new Cube(new CustomPoint(0, 1, 0), new CustomPoint(1, 1, 1)), 1.0},
								{ new Cube(new CustomPoint(0, -3, 2), new CustomPoint(3, -3, 1)), 27.0},
								{ new Cube(new CustomPoint(21, 4, 5), new CustomPoint(17, 4, 9)), 64.0} };
	}
	
	@DataProvider(name = "cubes-dissectionXY")
	public Object[] createDissectionXY() {
		return new Object[][] { { new Cube(new CustomPoint(0, -1, 0), new CustomPoint(1, -1, 1)), 0.0},
								{ new Cube(new CustomPoint(0, 3, 2), new CustomPoint(3, 3, -1)), 2.0},
								{ new Cube(new CustomPoint(-2, 9, 5), new CustomPoint(7, 9, -4)), 1.25} };
	}
	
	@DataProvider(name = "cubes-dissectionYZ")
	public Object[] createDissectionYZ() {
		return new Object[][] { { new Cube(new CustomPoint(0, -1, 0), new CustomPoint(1, -1, 1)), 0.0},
								{ new Cube(new CustomPoint(0, 3, 2), new CustomPoint(3, 3, -1)), 0.0},
								{ new Cube(new CustomPoint(-2, 9, 5), new CustomPoint(7, 9, -4)), 0.285714} };
	}
}
