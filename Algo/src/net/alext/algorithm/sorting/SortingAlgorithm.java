package net.alext.algorithm.sorting;

import java.util.List;

import net.alext.algorithm.Algorithm;
import net.alext.algorithm.sorting.exceptions.ZeroSizeSortingAlgorithmException;
import net.alext.algorithm.sorting.exceptions.SortingAlgorithmException;

public abstract class SortingAlgorithm <TInput extends List<T>, T extends Comparable<T>> 
	implements Algorithm<TInput, TInput> {
	
	protected SortDirection sortDirection;
	
	public SortingAlgorithm(SortDirection sortDirection) {
		super();
		this.sortDirection = sortDirection;
	}

	public SortingAlgorithm() {
		super();
		this.sortDirection = SortDirection.Ascending;
	}

	public abstract TInput Process(TInput input) throws SortingAlgorithmException;
	
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

	protected int getSortKoef() {
		return sortDirection == SortDirection.Ascending ? -1 : 1;
	}
}
