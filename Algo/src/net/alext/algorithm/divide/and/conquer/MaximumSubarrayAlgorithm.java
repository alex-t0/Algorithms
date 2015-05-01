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
	protected List<ArrayRangeData<T>> Divide(TArray input) throws DivideAndConquerAlgorithmException {
		
		List<ArrayRangeData<T>> result = new ArrayList<>();
		
		for (int i = 0; i < input.size(); i++){
			try {
				result.add(new ArrayRangeData<T>(i, i, (BaseBox<T>) input.get(i).clone()));
			} catch (CloneNotSupportedException e) {
				throw new DivideAndConquerAlgorithmException("Error while cloning objects");
			}
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	private ArrayRangeData<T> ConquerTwo(TArray input, ArrayRangeData<T> one, ArrayRangeData<T> another) 
			throws DivideAndConquerAlgorithmException {
		if (one.Left  > one.Right || another.Left  > another.Right)
			throw new DivideAndConquerAlgorithmException("Invalid ranges");
		if (one.Right + 1 != another.Left)
			throw new DivideAndConquerAlgorithmException("Ranges must be adjacent");
		if (one.Sum == null || another.Sum == null)
			throw new DivideAndConquerAlgorithmException("Both sum must be set");
		
		ArrayRangeData<T> crossingRange;
		
		try{
			crossingRange = FindCrossingSubArray(input, one.Right, new ArrayRangeData<T>(one.Left, another.Right));
			
			if (crossingRange.Sum.compareTo(one.Sum) >= 0 && crossingRange.Sum.compareTo(another.Sum) >= 0)
				return crossingRange;
			if (one.Sum.compareTo(crossingRange.Sum) >= 0 && one.Sum.compareTo(another.Sum) >= 0)
				return new ArrayRangeData<T>(one.Left, another.Right, (BaseBox<T>)one.Sum.clone());
			
			return new ArrayRangeData<T>(one.Left, another.Right, (BaseBox<T>)another.Sum.clone());
		}
		catch(CloneNotSupportedException e){
			throw new DivideAndConquerAlgorithmException("Error while cloning objects");
		}
	}
	
	@Override
	protected ArrayRangeData<T> Conquer(TArray input, List<ArrayRangeData<T>> simples) {
		
		return null;
	}
}
