package net.alext.boxing;

public abstract class BaseBox<T extends Comparable<T>> implements AddableBox<T> {

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
	public abstract AddableBox<T> add(AddableBox<T> other);
}
