package net.alext.algorithm.sorting;
import java.util.List;

import net.alext.algorithm.sorting.exceptions.SortingAlgorithmException;

public class InsertSortingAlgorithm <TInput extends List<Comparable<?>>> extends SortingAlgorithm<TInput>  {

	@Override
	public TInput Process(TInput input) throws SortingAlgorithmException {
		
		CheckInput(input);
		
		return input;
	}

}
