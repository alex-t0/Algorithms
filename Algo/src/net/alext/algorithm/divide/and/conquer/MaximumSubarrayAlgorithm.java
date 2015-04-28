package net.alext.algorithm.divide.and.conquer;

import java.util.ArrayList;
import java.util.List;

import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerAlgorithmException;
import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerSimpleDataNullPointerException;
import net.alext.boxing.BaseBox;

public class MaximumSubarrayAlgorithm<TArray extends List<BaseBox<T>>, T extends Comparable<T>> 
	extends DivideAndConquerAlgorithm<TArray, ArrayRangeData<T>, ArrayRangeData<T>, ArrayRangeData<T>> {
	
	@SuppressWarnings("unchecked")
	private ArrayRangeData<T> FindCrossingSubArray(TArray source, Integer middle, ArrayRangeData<T> boundaries) 
			throws DivideAndConquerAlgorithmException, CloneNotSupportedException {
		
		if (middle >= boundaries.Right || middle < boundaries.Left) // middle applies to left part
			throw new DivideAndConquerAlgorithmException("Invalid middle point: miss interval");
		
		BaseBox<T> leftSum = null, rightSum = null;
		BaseBox<T> sum = null;
		
		Integer leftPosition = 0;
		Integer rightPosition = 0;
		
		for (int i = middle; i >= boundaries.Left; i--){
			sum = sum == null ? (BaseBox<T>) source.get(i).clone() : sum.add(source.get(i));
			
			if (leftSum == null || sum.compareTo(leftSum) > 0){
				leftSum = (BaseBox<T>) sum.clone();
				leftPosition = i;
			}
		}
		
		sum = null;
		for (int i = middle + 1; i <= boundaries.Right; i++){
			sum = sum == null ? (BaseBox<T>) source.get(i).clone() : sum.add(source.get(i));
			
			if (rightSum == null || sum.compareTo(rightSum) > 0){
				rightSum = (BaseBox<T>) sum.clone();
				rightPosition = i;
			}
		}
		
		return new ArrayRangeData<T>(leftPosition, rightPosition, leftSum.add(rightSum));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ArrayRangeData<T> ProcessSimple(TArray input,
			ArrayRangeData<T> simple) throws DivideAndConquerAlgorithmException {
		
		if (simple == null) 
			throw new DivideAndConquerSimpleDataNullPointerException();
		
		// check that length is 1
		if (simple.Right != simple.Left)
			throw new DivideAndConquerAlgorithmException("Input must be simple (length = 1)");
		
		try {
			return new ArrayRangeData<T>(simple.Left, simple.Right, (BaseBox<T>) input.get(simple.Left).clone());
		}
		catch (CloneNotSupportedException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ArrayRangeData<T>> Divide(TArray input) {
		
		List<ArrayRangeData<T>> result = new ArrayList<>();
		
		for (int i = 0; i < input.size(); i++){
			try {
				result.add(new ArrayRangeData<T>(i, i, (BaseBox<T>) input.get(i).clone()));
			} catch (CloneNotSupportedException e) {}
		}
		
		return result;
	}

	@Override
	protected ArrayRangeData<T> Conquer(List<ArrayRangeData<T>> simples) {
		// TODO Auto-generated method stub
		return null;
	}

}
