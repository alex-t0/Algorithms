package net.alext.algorithm.divide.and.conquer;

import java.util.List;

import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerAlgorithmException;
import net.alext.boxing.BaseBox;

public class MaximumSubarrayAlgorithm<TArray extends List<BaseBox<T>>, T extends Comparable<T>> 
	extends DivideAndConquerAlgorithm<TArray, ArrayRangeData> {

	private ArrayRangeData FindCrossingSubArray(TArray source, Integer middle, ArrayRangeData boundaries) 
			throws DivideAndConquerAlgorithmException {
		
		if (middle >= boundaries.Right || middle < boundaries.Left) // middle applies to left part
			throw new DivideAndConquerAlgorithmException("Invalid middle point: miss interval");
		
		Integer leftSum = null, rightSum = null;
		BaseBox<T> sum = null;
		
		//for (int i = middle; i >= 0; i--){
		//	sum = sum.add(source.get(i));
		//}
		
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
