package net.alext.algorithm.sorting;

import java.util.List;

import net.alext.algorithm.sorting.exceptions.SortingAlgorithmException;

public class InsertSortingAlgorithm<TInput extends List<TElement>, TElement extends Comparable<TElement>>
		extends SortingAlgorithm<TInput, TElement> {

	@Override
	public TInput Process(TInput input) throws SortingAlgorithmException {

		CheckInput(input);

		int sortKoef = sortDirection == SortDirection.Ascending ? -1 : 1;

		for (int pointerIndex = 1; pointerIndex < input.size(); pointerIndex++) {

			int currentPointerIndex = pointerIndex;
			while (currentPointerIndex > 0 && 
					sortKoef * input.get(currentPointerIndex).compareTo(input.get(currentPointerIndex - 1)) > 0) {
				this.switchElements(input, currentPointerIndex, currentPointerIndex - 1);
				currentPointerIndex--;
			}

		}

		return input;
	}

}
