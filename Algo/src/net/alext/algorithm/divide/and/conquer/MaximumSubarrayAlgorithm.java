package net.alext.algorithm.divide.and.conquer;

import java.util.ArrayList;
import java.util.List;

import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerAlgorithmException;
import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerSimpleDataNullPointerException;
import net.alext.boxing.ComparableBaseBox;

public class MaximumSubarrayAlgorithm<TArray extends List<ComparableBaseBox<T>>, T extends Comparable<T>> 
	extends DivideAndConquerAlgorithm<TArray, ArrayRangeSumData<T>, ArrayRangeSumData<T>, ArrayRangeSumData<T>> {
	
	@SuppressWarnings("unchecked")
	private ArrayRangeSumData<T> FindCrossingSubArray(TArray source, Integer middle, ArrayRangeSumData<T> boundaries) 
			throws DivideAndConquerAlgorithmException, CloneNotSupportedException {
		
		if (middle >= boundaries.Right || middle < boundaries.Left) // middle applies to left part
			throw new DivideAndConquerAlgorithmException("Invalid middle point: miss interval");
		
		ComparableBaseBox<T> leftSum = null, rightSum = null;
		ComparableBaseBox<T> sum = null;
		
		Integer leftPosition = 0;
		Integer rightPosition = 0;
		
		for (int i = middle; i >= boundaries.Left; i--){
			sum = sum == null ? (ComparableBaseBox<T>) source.get(i).clone() : (ComparableBaseBox<T>) sum.add(source.get(i));
			
			if (leftSum == null || sum.compareTo(leftSum) >= 0){
				leftSum = (ComparableBaseBox<T>) sum.clone();
				leftPosition = i;
			}
		}
		
		sum = null;
		for (int i = middle + 1; i <= boundaries.Right; i++){
			sum = sum == null ? (ComparableBaseBox<T>) source.get(i).clone() : (ComparableBaseBox<T>) sum.add(source.get(i));
			
			if (rightSum == null || sum.compareTo(rightSum) >= 0){
				rightSum = (ComparableBaseBox<T>) sum.clone();
				rightPosition = i;
			}
		}
		
		return new ArrayRangeSumData<T>(boundaries.Left, boundaries.Right, leftPosition, rightPosition, (ComparableBaseBox<T>) leftSum.add(rightSum));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ArrayRangeSumData<T> ProcessSimple(TArray input,
			ArrayRangeSumData<T> simple) throws DivideAndConquerAlgorithmException {
		
		if (simple == null) 
			throw new DivideAndConquerSimpleDataNullPointerException();
		
		// check that length is 1
		if (simple.Right != simple.Left)
			throw new DivideAndConquerAlgorithmException("Input must be simple (length = 1)");
		
		try {
			return new ArrayRangeSumData<T>(simple.Left, simple.Right, simple.Left, simple.Right, (ComparableBaseBox<T>) input.get(simple.Left).clone());
		}
		catch (CloneNotSupportedException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ArrayRangeSumData<T>> Divide(TArray input) throws DivideAndConquerAlgorithmException {
		
		List<ArrayRangeSumData<T>> result = new ArrayList<>();
		
		for (int i = 0; i < input.size(); i++){
			try {
				result.add(new ArrayRangeSumData<T>(i, i, i, i, (ComparableBaseBox<T>) input.get(i).clone()));
			} catch (CloneNotSupportedException e) {
				throw new DivideAndConquerAlgorithmException("Error while cloning objects");
			}
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	private ArrayRangeSumData<T> ConquerTwo(TArray input, ArrayRangeSumData<T> one, ArrayRangeSumData<T> another) 
			throws DivideAndConquerAlgorithmException {
		if (one.Left  > one.Right || another.Left  > another.Right)
			throw new DivideAndConquerAlgorithmException("Invalid ranges");
		if (one.Right + 1 != another.Left)
			throw new DivideAndConquerAlgorithmException("Ranges must be adjacent");
		if (one.Sum == null || another.Sum == null)
			throw new DivideAndConquerAlgorithmException("Both sum must be set");
		
		ArrayRangeSumData<T> crossingRange;
		
		try{
			crossingRange = FindCrossingSubArray(input, one.Right, new ArrayRangeSumData<T>(one.Left, another.Right));
			
			if (crossingRange.Sum.compareTo(one.Sum) >= 0 && crossingRange.Sum.compareTo(another.Sum) >= 0)
				return crossingRange;
			if (one.Sum.compareTo(crossingRange.Sum) >= 0 && one.Sum.compareTo(another.Sum) >= 0)
				return new ArrayRangeSumData<T>(one.Left, another.Right, one.MaximumSubArrayIndexLeft, one.MaximumSubArrayIndexRight,  (ComparableBaseBox<T>)one.Sum.clone());
			
			return new ArrayRangeSumData<T>(one.Left, another.Right, another.MaximumSubArrayIndexLeft, another.MaximumSubArrayIndexRight, (ComparableBaseBox<T>)another.Sum.clone());
		}
		catch(CloneNotSupportedException e){
			throw new DivideAndConquerAlgorithmException("Error while cloning objects");
		}
	}
	
	@Override
	protected ArrayRangeSumData<T> Conquer(TArray input, List<ArrayRangeSumData<T>> simples) throws DivideAndConquerAlgorithmException {
		
		// simples must contain even elements
		if (simples.size() % 2 == 1){
			ArrayRangeSumData<T> one = simples.get(simples.size() - 2);
			ArrayRangeSumData<T> another = simples.get(simples.size() - 1);
			
			ArrayRangeSumData<T> result = ConquerTwo(input, one, another);
			
			simples.remove(one);
			simples.remove(another);
			simples.add(result);
		}
		
		int index = 0;
		while (simples.size() > 1){
			if (index >= simples.size() - 1) index = 0;
			
			ArrayRangeSumData<T> one = simples.get(index);
			ArrayRangeSumData<T> another = simples.get(index + 1);
			
			ArrayRangeSumData<T> result = ConquerTwo(input, one, another);
			
			simples.add(index, result);
			simples.remove(one);
			simples.remove(another);
			
			index++;
		}
		
		return simples.get(0);
	}
}
