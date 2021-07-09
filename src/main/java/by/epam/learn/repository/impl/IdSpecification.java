package by.epam.learn.repository.impl;

import by.epam.learn.entity.CustomShape;
import by.epam.learn.repository.Specification;

public class IdSpecification implements Specification {
	private long id;

	public IdSpecification(long id) {
		this.id = id;
	}

	@Override
	public boolean specify(CustomShape shape) {
		boolean result = (shape.getId() == id);
		return result;
	}
	
}
