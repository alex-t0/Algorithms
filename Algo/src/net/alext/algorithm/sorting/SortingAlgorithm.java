package net.alext.algorithm.sorting;

import java.util.List;

import net.alext.algorithm.Algorithm;
import net.alext.algorithm.sorting.exceptions.ZeroSizeSortingAlgorithmException;

public abstract class SortingAlgorithm <TInput extends List<T>, T extends Comparable<T>> 
	implements Algorithm<TInput, TInput> {
	
	protected SortDirection sortDirection;
	// protected TInput input;
	
	public SortingAlgorithm(/*TInput input, */SortDirection sortDirection) {
		super();
		this.sortDirection = sortDirection;
		// this.input = input;
	}

	public SortingAlgorithm() {
		super();
		this.sortDirection = SortDirection.Ascending;
	}
	
	public void SetDirection(SortDirection direction){
		this.sortDirection = direction;
	}

	protected void CheckInput(TInput input) throws ZeroSizeSortingAlgorithmException {
		if (input.size() == 0)
			throw new ZeroSizeSortingAlgorithmException();
	}
	
	protected void switchElements(TInput input, int index1, int index2){
		T tmp = input.get(index1);
		
		input.set(index1, input.get(index2));
		input.set(index2, tmp);
	}
}
