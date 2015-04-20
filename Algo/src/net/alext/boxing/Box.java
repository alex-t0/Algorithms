package net.alext.boxing;

public interface Box<T> {
	public void box(T t);
	public T unbox();
}
