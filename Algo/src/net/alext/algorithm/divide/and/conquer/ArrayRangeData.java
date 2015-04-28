package net.alext.algorithm.divide.and.conquer;

import net.alext.boxing.BaseBox;

public class ArrayRangeData<T extends Comparable<T>> {
	public int Left;
	public int Right;
	
	public BaseBox<T> Sum;

	public ArrayRangeData(int left, int right, BaseBox<T> sum) {
		super();
		Left = left;
		Right = right;
		Sum = sum;
	}
}
