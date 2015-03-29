package net.alext.algorithm.sorting;

import java.util.List;

import net.alext.algorithm.Algorithm;

public abstract class SortingAlgorithm <TInput extends List<Comparable<?>>> 
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
	
	public void SetDirection(SortDirection direction){
		
	}
}
