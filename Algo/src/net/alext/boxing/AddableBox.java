package net.alext.boxing;

public interface AddableBox<T extends Comparable<T>> extends ComparableBox<T> {
	public AddableBox<T> add(AddableBox<T> other);
}
