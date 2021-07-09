package by.epam.learn.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.learn.entity.CustomPoint;
import by.epam.learn.exception.ShapeException;
import by.epam.learn.validator.CubeValidator;
import by.epam.learn.validator.DataValidator;

public class CubeParser {
	public static Logger log = LogManager.getLogger();
	private static final String DELIMETER ="\\s";
	
	public List<CustomPoint[]> parseShape(List<String> data) throws ShapeException {
		if (data == null || data.size() == 0) {
			log.error("data not available");
			throw new ShapeException("data not available");
		}
		List<CustomPoint[]> cubesPoint = new ArrayList<>();
		for (String rowPoints : data) {
			if (DataValidator.isCorrectRow(rowPoints)) {
				String[] points = rowPoints.split(DELIMETER);
				double x = Double.parseDouble(points[0]);
				double y = Double.parseDouble(points[4]);
				double z = Double.parseDouble(points[1]);
				CustomPoint pointA = new CustomPoint(x, y, z);
				x = Double.parseDouble(points[2]);
				z = Double.parseDouble(points[3]);
				CustomPoint pointB = new CustomPoint(x, y, z);
				if (CubeValidator.isCube(pointA, pointB)) {
					CustomPoint[] diagonal = new CustomPoint[2];
					diagonal[0] = pointA;
					diagonal[1] = pointB;
					cubesPoint.add(diagonal);
				}
			}
		}
		if (cubesPoint.isEmpty()) {
			log.error("no data to create the cube");
			throw new ShapeException("no data to create the cube");
		}
		log.info("data were parsed");
		return cubesPoint;
	}
}
