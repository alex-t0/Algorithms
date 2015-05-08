package net.alext.boxing;

public interface MultiplyableBox<T extends Comparable<T>> extends ComparableBox<T> {
	public MultiplyableBox<T> multiply(MultiplyableBox<T> other);
}
