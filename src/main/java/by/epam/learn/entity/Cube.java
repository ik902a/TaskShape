package by.epam.learn.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.learn.exception.ShapeException;
import by.epam.learn.observer.CubeEvent;
import by.epam.learn.observer.Observable;
import by.epam.learn.observer.ShapeObserver;

public class Cube extends CustomShape implements Observable {
	public static Logger log = LogManager.getLogger();
	private CustomPoint pointA;
	private CustomPoint pointB;
	private List<ShapeObserver> observers = new ArrayList<>();
	
	public Cube() {
		super();
	}

	public Cube(CustomPoint pointA, CustomPoint pointB) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
	}
	
	public Cube(CustomPoint[] points) {
		super();
		this.pointA = points[0];
		this.pointB = points[1];
	}

	public CustomPoint getPointA() {
		return pointA;
	}

	public void setPointA(CustomPoint pointA) {
		this.pointA = pointA;
	}

	public CustomPoint getPointB() {
		return pointB;
	}

	public void setPointB(CustomPoint pointB) {
		this.pointB = pointB;
		notifyObservers();
	}
	
	public double getHeight() {
		double height = Math.abs(pointA.getY());
		return height;
	}

	@Override
	public void attach(ShapeObserver observer) {
		if (observer!=null) {
			observers.add(observer);
		}
	}

	@Override
	public void detach(ShapeObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		CubeEvent event = new CubeEvent(this);
		for (ShapeObserver observer : observers) {
			try {
				observer.valueChanged(event);
			} catch (ShapeException e) {
				log.error("event exception");
			}
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((observers == null) ? 0 : observers.hashCode());
		result = prime * result + ((pointA == null) ? 0 : pointA.hashCode());
		result = prime * result + ((pointB == null) ? 0 : pointB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cube other = (Cube) obj;
		if (observers == null) {
			if (other.observers != null)
				return false;
		} else if (!observers.equals(other.observers))
			return false;
		if (pointA == null) {
			if (other.pointA != null)
				return false;
		} else if (!pointA.equals(other.pointA))
			return false;
		if (pointB == null) {
			if (other.pointB != null)
				return false;
		} else if (!pointB.equals(other.pointB))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append("\npointA: ").append(pointA);
		sb.append("\npointB: ").append(pointB);
		return sb.toString();
	}
}
