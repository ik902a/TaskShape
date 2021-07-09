package by.epam.learn.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.learn.action.CubeAction;
import by.epam.learn.entity.Cube;
import by.epam.learn.entity.ShapeValues;
import by.epam.learn.exception.ShapeException;
import by.epam.learn.observer.CubeEvent;
import by.epam.learn.observer.ShapeObserver;
import by.epam.learn.warehouse.Warehouse;

public class CubeObserver implements ShapeObserver {
	public static Logger log = LogManager.getLogger();

	@Override
	public void valueChanged(CubeEvent event) throws ShapeException {
		if (event == null) {
			throw new ShapeException("event is null");
		}
		Cube cube = event.getSource();
		long id = cube.getId();
		CubeAction action = new CubeAction();
		double area = action.area(cube);
		double volume = action.volume(cube);
		ShapeValues shapeValues = new ShapeValues(area, volume);
		Warehouse warehouse = Warehouse.getWarehouse();
		log.info("values cube ID:" + id + " were changed");
		warehouse.putShapeValues(id, shapeValues);
	}
}
