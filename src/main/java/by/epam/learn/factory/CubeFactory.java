package by.epam.learn.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.learn.entity.Cube;
import by.epam.learn.entity.CustomPoint;
import by.epam.learn.entity.CustomShape;
import by.epam.learn.exception.ShapeException;

public class CubeFactory extends ShapeFactory {
	public static Logger log = LogManager.getLogger();

	@Override
	public CustomShape createShape(CustomPoint[] points) throws ShapeException {
		if (points == null) {
			log.error("data not available");
			throw new ShapeException("data not available");
		}
		Cube cube = new Cube(points);
		log.info("cube created: " + cube.toString());
		return cube;
	}
}
