package net.alext.algorithm.divide.and.conquer;

import java.util.List;

import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerAlgorithmException;
import net.alext.boxing.BaseBox;

public class MaximumSubarrayAlgorithm<TArray extends List<BaseBox<T>>, T extends Comparable<T>> 
	extends DivideAndConquerAlgorithm<TArray, ArrayRangeData> {

	@SuppressWarnings("unchecked")
	private ArrayRangeData FindCrossingSubArray(TArray source, Integer middle, ArrayRangeData boundaries) 
			throws DivideAndConquerAlgorithmException, CloneNotSupportedException {
		
		if (middle >= boundaries.Right || middle < boundaries.Left) // middle applies to left part
			throw new DivideAndConquerAlgorithmException("Invalid middle point: miss interval");
		
		BaseBox<T> leftSum = null, rightSum = null;
		BaseBox<T> sum = null;
		
		Integer leftPosition = 0;
		Integer rightPosition = 0;
		
		for (int i = middle; i >= boundaries.Left; i--){
			sum = sum == null ? (BaseBox<T>) source.get(i).clone() : sum.add(source.get(i));
			
			if (leftSum != null && sum.compareTo(leftSum) > 0){
				
			}
		}
		
		sum = null;
		for (int i = middle + 1; i <= boundaries.Right; i++){
			sum = sum == null ? (BaseBox<T>) source.get(i).clone() : sum.add(source.get(i));
		}
		
		return null;
	}
	
	@Override
	public ArrayRangeData ProcessSimple(TArray simple) {
		
		BaseBox<T> t1 = simple.get(0);
		BaseBox<T> t2 = simple.get(1);

		t1 = t1.add(t2);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TArray> Divide(TArray input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayRangeData Conquer(List<ArrayRangeData> simples) {
		// TODO Auto-generated method stub
		return null;
	}
}
