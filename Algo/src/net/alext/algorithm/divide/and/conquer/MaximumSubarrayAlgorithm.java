package net.alext.algorithm.divide.and.conquer;

import java.util.Comparator;
import java.util.List;

public class MaximumSubarrayAlgorithm<TArray extends List<T>, TComparator extends Comparator<T>, T extends Comparable<T>> 
	extends DivideAndConquerAlgorithm<TArray, ArrayRangePair> {

	private ArrayRangePair FindCrossingSubArray(TArray source, Integer middle, ArrayRangePair boundaries){
		return null;
	}
	
	@Override
	public ArrayRangePair ProcessSimple(TArray simple) {
		
		T t1 = simple.get(0);
		T t2 = simple.get(1);

		//t1 = t1 + t2;
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TArray> Divide(TArray input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayRangePair Conquer(List<ArrayRangePair> simples) {
		// TODO Auto-generated method stub
		return null;
	}
}
