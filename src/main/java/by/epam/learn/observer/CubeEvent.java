package by.epam.learn.observer;

import java.util.EventObject;

import by.epam.learn.entity.Cube;

public class CubeEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	public CubeEvent(Cube source) {
		super(source);
	}
	
	@Override
	public Cube getSource() {
		return (Cube) super.getSource();
	}
}
