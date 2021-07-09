package by.epam.learn.observer;

import by.epam.learn.exception.ShapeException;

public interface ShapeObserver {
	void valueChanged(CubeEvent event) throws ShapeException;
}
