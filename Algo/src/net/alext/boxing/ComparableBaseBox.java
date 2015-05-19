package net.alext.boxing;

public abstract class ComparableBaseBox<T extends Comparable<T>> 
	extends BaseBox<T> implements ComparableBox<T> {
	
	public ComparableBaseBox(T initValue) {
		super(initValue);
	}

	@Override
	public int compareTo(ComparableBox<T> other) {
		return instance.compareTo(other.unbox());
	}
}
