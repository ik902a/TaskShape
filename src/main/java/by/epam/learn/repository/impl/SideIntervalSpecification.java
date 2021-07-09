package by.epam.learn.repository.impl;

import by.epam.learn.entity.Cube;
import by.epam.learn.entity.CustomShape;
import by.epam.learn.repository.Specification;

public class SideIntervalSpecification implements Specification {
	private double minSide;
	private double maxSide;

	public SideIntervalSpecification(double minSide, double maxSide) {
		this.minSide = minSide;
		this.maxSide = maxSide;
	}
	
	@Override
	public boolean specify(CustomShape shape) {
		double side = ((Cube) shape).getHeight();
		boolean result = (side >= minSide && side <= maxSide);
		return result;
	}
}
