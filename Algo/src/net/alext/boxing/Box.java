package net.alext.boxing;

public interface Box<T> {
	public Box<T> box(T t);
	public T unbox();
}
