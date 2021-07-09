package by.epam.learn.action;

import by.epam.learn.entity.Cube;

public class CubeAction {

	public double area(Cube cube) {
		double side = cube.getHeight();
		return (Math.pow(side, 2) * 6);
	}
	
	public double volume(Cube cube) {
		double side = cube.getHeight();
		return Math.abs(Math.pow(side, 3));
	}

	public double dissectionXY(Cube cube) {
		double result = 0;
		double zA = cube.getPointA().getZ();
		double zB = cube.getPointB().getZ();
		if (zA * zB < 0) {
			result = Math.abs(zA / zB);
		}
		return result;
	}

	public double dissectionYZ(Cube cube) {
		double result = 0;
		double xA = cube.getPointA().getX();
		double xB = cube.getPointB().getX();
		if (xA * xB < 0) {
			result = Math.abs(xA / xB);
		}
		return result;
	}
}
