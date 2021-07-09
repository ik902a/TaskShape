package by.epam.learn.repository.impl;

import by.epam.learn.action.CubeAction;
import by.epam.learn.entity.Cube;
import by.epam.learn.entity.CustomShape;
import by.epam.learn.repository.Specification;

public class IsNotDissectionSpecification implements Specification {
	private CubeAction cubeAction;

	public IsNotDissectionSpecification() {
		cubeAction = new CubeAction();
	}

	@Override
	public boolean specify(CustomShape shape) {
		double dessectionXY = cubeAction.dissectionXY((Cube) shape);
		double dessectionYZ = cubeAction.dissectionYZ((Cube) shape);
		boolean result = ((dessectionXY + dessectionYZ) == 0);
		return result;
	}
}
