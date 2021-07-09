package by.epam.learn.factory;

import by.epam.learn.entity.CustomPoint;
import by.epam.learn.entity.CustomShape;
import by.epam.learn.exception.ShapeException;

public abstract class ShapeFactory {
	public abstract CustomShape createShape (CustomPoint[] points) throws ShapeException;
}
