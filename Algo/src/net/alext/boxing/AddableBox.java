package net.alext.boxing;

public interface AddableBox<T> extends Box<T> {
	public AddableBox<T> add(AddableBox<T> other);
}
