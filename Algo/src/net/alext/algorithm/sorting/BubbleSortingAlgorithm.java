package net.alext.algorithm.sorting;

import java.util.List;

import net.alext.algorithm.sorting.exceptions.SortingAlgorithmException;

public class BubbleSortingAlgorithm<TInput extends List<TElement>, TElement extends Comparable<TElement>>
		extends SortingAlgorithm<TInput, TElement> {

	@Override
	public TInput Process(TInput input) throws SortingAlgorithmException {

		CheckInput(input);

		int sortKoef = getSortKoef();
		
		for (int i = 0; i < input.size(); i++) {

			for (int j = input.size() - 1; j > i; j--){
				if (sortKoef * input.get(j).compareTo(input.get(j-1)) > 0)
					this.switchElements(input, j, j-1);
			}

		}

		return input;
	}

}
