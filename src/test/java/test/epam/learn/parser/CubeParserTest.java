package test.epam.learn.parser;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.learn.entity.CustomPoint;
import by.epam.learn.exception.ShapeException;
import by.epam.learn.parser.CubeParser;

public class CubeParserTest {
	CubeParser parser;
	
	@BeforeClass
	public void setUp() {
		parser = new CubeParser();
	}
	
	@AfterClass
	public void tearDown() {
		parser = null;
	}
	
	@Test 
	public void testParseShape() throws ShapeException {
		List<String> data = List.of("0.0 0.0 1.0 1.0 1.0",
									"0 r 42 5 0",
									"0.0 4.2 3.3 5.3 4",
									"",
									"0 2 3 -1 -3",
									"21 5 17 9 4",
									"2.2 5 5.2 3");
		List<CustomPoint[]> actual = parser.parseShape(data);
		List<CustomPoint[]> expected = List.of(
				new CustomPoint[]{new CustomPoint(0, 1, 0), new CustomPoint(1, 1, 1)},
				new CustomPoint[]{new CustomPoint(0.0, -3.0, 2.0), new CustomPoint(3.0, -3.0, -1.0)},
				new CustomPoint[]{new CustomPoint(21.0, 4.0, 5.0), new CustomPoint(17.0, 4.0, 9.0)});
				assertEquals(actual, expected);
	}
}
