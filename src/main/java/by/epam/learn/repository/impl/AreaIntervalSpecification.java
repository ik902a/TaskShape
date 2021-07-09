package by.epam.learn.repository.impl;

import by.epam.learn.action.CubeAction;
import by.epam.learn.entity.Cube;
import by.epam.learn.entity.CustomShape;
import by.epam.learn.repository.Specification;

public class AreaIntervalSpecification implements Specification {
	private double minArea;
	private double maxArea;
	private CubeAction cubeAction;

	public AreaIntervalSpecification(double minArea, double maxArea) {
		this.minArea = minArea;
		this.maxArea = maxArea;
		cubeAction = new CubeAction();
	}

	@Override
	public boolean specify(CustomShape shape) {
		double area = cubeAction.area((Cube) shape);
		boolean result = (area >= minArea && area <= maxArea);
		return result;
	}
}
