package net.alext.boxing;

public interface MultiplyableBox<T> extends Box<T> {
	public MultiplyableBox<T> multiply(MultiplyableBox<T> other);
	
	public MultiplyableBox<T> getOne();
}
