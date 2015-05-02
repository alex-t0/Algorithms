package net.alext.boxing;

public interface ComparableBox<T extends Comparable<T>> extends Box<T> {
	int compareTo(ComparableBox<T> other);
}
