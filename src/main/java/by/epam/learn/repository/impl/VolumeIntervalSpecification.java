package by.epam.learn.repository.impl;

import by.epam.learn.action.CubeAction;
import by.epam.learn.entity.Cube;
import by.epam.learn.entity.CustomShape;
import by.epam.learn.repository.Specification;

public class VolumeIntervalSpecification implements Specification {
	private double minVolume;
	private double maxVolume;
	private CubeAction cubeAction;

	public VolumeIntervalSpecification(double minVolume, double maxVolume) {
		this.minVolume = minVolume;
		this.maxVolume = maxVolume;
		cubeAction = new CubeAction();
	}

	@Override
	public boolean specify(CustomShape shape) {
		double volume = cubeAction.volume((Cube) shape);
		boolean result = (volume >= minVolume && volume <= maxVolume);
		return result;
	}
}
