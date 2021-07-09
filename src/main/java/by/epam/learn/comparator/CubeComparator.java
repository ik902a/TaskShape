package by.epam.learn.comparator;

import java.util.Comparator;

import by.epam.learn.entity.Cube;
import by.epam.learn.entity.CustomShape;

public enum CubeComparator implements Comparator<CustomShape> {
	ID {
		@Override
		public int compare(CustomShape shape1, CustomShape shape2) {
			int result;
			result = Long.compare(shape1.getId(), shape2.getId());
			return result;
		}
	},
	AXIS_X {
		@Override
		public int compare(CustomShape shape1, CustomShape shape2) {
			int result;
			double coordinateX1 = Double.min(((Cube) shape1).getPointA().getX(), ((Cube) shape1).getPointB().getX());
			double coordinateX2 = Double.min(((Cube) shape2).getPointA().getX(), ((Cube) shape2).getPointB().getX());
			result = Double.compare(coordinateX1, coordinateX2);
			return result;
		}
	},
	HEIGHT {
		@Override
		public int compare(CustomShape shape1, CustomShape shape2) {
			int result;
			result = Double.compare(((Cube) shape1).getHeight(), ((Cube) shape2).getHeight());
			return result;
		}
	}
}
