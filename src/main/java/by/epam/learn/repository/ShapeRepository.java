package by.epam.learn.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import by.epam.learn.entity.CustomShape;

public class ShapeRepository {
	private final static ShapeRepository repository = new ShapeRepository();
	private List<CustomShape> shapes = new ArrayList<>();
	
	public ShapeRepository() {
	}
	
	public static ShapeRepository getShapeRepository () {
		return repository;
	}
	
	public List<CustomShape> getShapes() {
		return Collections.unmodifiableList(shapes);
	}
	
	public boolean addShape(CustomShape shape) {
		return shapes.add(shape);
	}

	public boolean addAllShapes(Collection<CustomShape> shapes) {
		return this.shapes.addAll(shapes);
	}
	
	public boolean removeShape(CustomShape shape) {
		return shapes.remove(shape);
	}

	public boolean removeAllShapes(Collection<CustomShape> shapes) {
		return this.shapes.removeAll(shapes);
	}
	
	public CustomShape setShape(int index, CustomShape shape) {
		return shapes.set(index, shape);
	}

	public CustomShape getShape(int index) {
		return shapes.get(index);
	}
	
	public List<CustomShape> query(Specification specification) {
		List<CustomShape> list = shapes.stream()
										.filter(o -> specification.specify(o))
										.collect(Collectors.toList());
		return list;
	}
	
	public List<CustomShape> sort(Comparator<CustomShape> comparator) {
		shapes.sort(comparator);
		return shapes;
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("/nShapeRepository:\n").append(shapes);
		return sb.toString();
	}
}
