package net.alext.algorithm.divide.and.conquer;

import net.alext.boxing.ComparableBaseBox;

public class ArrayRangeSumData<T extends Comparable<T>> {
	public int Left;
	public int Right;
	
	public Integer MaximumSubArrayIndexLeft;
	public Integer MaximumSubArrayIndexRight;
	
	public ComparableBaseBox<T> Sum;

	public ArrayRangeSumData(int left, int right, Integer leftIndex, Integer rightIndex, ComparableBaseBox<T> sum) {
		super();
		Left = left;
		Right = right;
		MaximumSubArrayIndexLeft = leftIndex;
		MaximumSubArrayIndexRight = rightIndex;
		Sum = sum;
	}
	
	public ArrayRangeSumData(int left, int right) {
		this(left, right, null, null, null);
	}
}
