package by.epam.learn.validator;

import by.epam.learn.entity.CustomPoint;

public class CubeValidator {
	
	public static boolean isCube(CustomPoint pointA, CustomPoint pointB) {
		boolean result = false;
		double height = 0; 
		double xA = pointA.getX();
		double zA = pointA.getZ();
		double xB = pointB.getX();
		double zB = pointB.getZ();
		double heightA = pointA.getY();
		double heightB = pointB.getY();
		if (heightA == heightB) {
			height = heightA;
		}
		result = Math.abs((Math.pow((xA - xB), 2) + Math.pow((zA - zB), 2) - (2 * Math.pow(height, 2)))) < 0.0001;
		return result;
	}
}
