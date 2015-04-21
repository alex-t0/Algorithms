package net.alext.boxing;

public abstract class BaseBox<T extends Comparable<T>> implements AddableBox<T>, Cloneable {

	protected T instance;

	@Override
	public int compareTo(ComparableBox<T> other) {
		return instance.compareTo(other.unbox());
	}

	@Override
	public void box(T t) {
		instance = t;
	}

	@Override
	public T unbox() {
		return instance;
	}

	// seems to impossible to implement, so we make current class abstract
	@Override
	public abstract BaseBox<T> add(AddableBox<T> other);

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		
		
		return super.clone();
	}
}
