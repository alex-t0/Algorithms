package net.alext.algorithm.bruteforce;

import java.util.List;

import net.alext.algorithm.Algorithm;
import net.alext.algorithm.divide.and.conquer.ArrayRangeSumData;
import net.alext.algorithm.exceptions.AlgorithmException;
import net.alext.boxing.ComparableBaseBox;

public class MaximumSubarrayBruteForceAlgorithm<TArray extends List<ComparableBaseBox<T>>, T extends Comparable<T>> 
	implements Algorithm<TArray, ArrayRangeSumData<T>> {

	private ComparableBaseBox<T> findSum(TArray list, int left, int right) throws CloneNotSupportedException{
		@SuppressWarnings("unchecked")
		ComparableBaseBox<T> sum = (ComparableBaseBox<T>) list.get(left).clone();
		
		for (int i = left + 1; i <= right; i++){
			sum = (ComparableBaseBox<T>) sum.add(list.get(i));
		}
		
		return sum;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayRangeSumData<T> Process(TArray input) throws AlgorithmException {

		ArrayRangeSumData<T> max;
		
		try {
			
			max = new ArrayRangeSumData<T>(0, input.size(), 0, 0, (ComparableBaseBox<T>)input.get(0).clone());
			
			for (int i = 0; i < input.size(); i++){
						
				for (int j = i; j < input.size(); j++) {
					ComparableBaseBox<T> sum = findSum(input, i, j);
					
					int compareResult = sum.compareTo(max.Sum);
					if (compareResult > 0 || (compareResult == 0 && j - i > max.MaximumSubArrayIndexRight - max.MaximumSubArrayIndexLeft)){
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
