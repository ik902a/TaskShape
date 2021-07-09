package by.epam.learn.entity;

import by.epam.learn.util.IdGenerator;

public abstract class CustomShape {
	private long id;
	
	public CustomShape() {
		this.id = IdGenerator.generateId();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomShape other = (CustomShape) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append("\nID: ").append(id);
		return sb.toString();
	}
}
