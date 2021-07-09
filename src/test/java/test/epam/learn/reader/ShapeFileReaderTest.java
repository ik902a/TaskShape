package test.epam.learn.reader;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.learn.exception.ShapeException;
import by.epam.learn.reader.ShapeFileReader;

public class ShapeFileReaderTest {
	ShapeFileReader reader;
	public static final String TEST_FILE = "data_shape\\cube_test.txt";
	
	@BeforeClass
	public void setUp() {
		reader = new ShapeFileReader();
	}
	
	@AfterClass
	public void tearDown() {
		reader = null;
	}
	
	@Test 
	public void testReadFromFile() throws ShapeException {
		List<String> expected = List.of("0.0 0.0 1.0 1.0 1.0",
										"0 r 42 5 0",
										"0.0 4.2 3.3 5.3 4",
										"",
										"0 2 3 -1 -3",
										"21 5 17 9 4",
										"2.2 5 5.2 3");
		List<String> actual = reader.readFromFile(TEST_FILE);
		assertEquals(actual, expected);
	}
}
