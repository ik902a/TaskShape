package by.epam.learn.warehouse;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.learn.entity.ShapeValues;

public class Warehouse {
	public static Logger log = LogManager.getLogger();
	private final static Warehouse warehouse = new Warehouse();
	private Map<Long, ShapeValues> shapesValues = new HashMap<>();
	
	private Warehouse() {
	}

	public static Warehouse getWarehouse() {
		return warehouse;
	}
	
	public ShapeValues putShapeValues(long id, ShapeValues shapeValues) {
		log.info( "\nValues added in warehouse, ID: " + id);
		return shapesValues.put(id, shapeValues);
	}

	public ShapeValues removeShapeValue(Long id) {
		log.info( "\nValues removed from warehouse, ID: " + id);
		return shapesValues.remove(id);
	}

	public ShapeValues getShapeValues(Long id) {
		return shapesValues.get(id);
	}
}
