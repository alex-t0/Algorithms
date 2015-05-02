package net.alext.algorithm.bruteforce;

import java.util.List;

import net.alext.algorithm.*;
import net.alext.algorithm.divide.and.conquer.ArrayRangeSumData;
import net.alext.algorithm.exceptions.AlgorithmException;
import net.alext.boxing.BaseBox;

public class MaximumSubarrayBruteForceAlgorithm<TArray extends List<BaseBox<T>>, T extends Comparable<T>> 
	implements Algorithm<TArray, ArrayRangeSumData<T>> {

	private BaseBox<T> findSum(TArray list, int left, int right) throws CloneNotSupportedException{
		@SuppressWarnings("unchecked")
		BaseBox<T> sum = (BaseBox<T>) list.get(left).clone();
		
		for (int i = left + 1; i <= right; i++){
			sum = sum.add(list.get(i));
		}
		
		return sum;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayRangeSumData<T> Process(TArray input) throws AlgorithmException {

		ArrayRangeSumData<T> max;
		
		try {
			
			max = new ArrayRangeSumData<T>(0, input.size(), 0, 0, (BaseBox<T>)input.get(0).clone());
			
			for (int i = 0; i < input.size(); i++){
						
				for (int j = i; j < input.size(); j++) {
					BaseBox<T> sum = findSum(input, i, j);
					
					if (sum.compareTo(max.Sum) > 0){
						max.MaximumSubArrayIndexLeft = i;
						max.MaximumSubArrayIndexRight = j;
						max.Sum = sum;
					}
					
				}
			}
		
		} catch (CloneNotSupportedException e) {
			throw new AlgorithmException("Clone error");
		}
		
		return max;
	}

}
