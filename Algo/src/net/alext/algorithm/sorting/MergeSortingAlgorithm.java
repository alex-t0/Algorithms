package net.alext.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortingAlgorithm <TInput extends List<T>, T extends Comparable<T>> extends SortingAlgorithm<TInput, T> {

	private ArrayList<T> createPreparedPair(List<T> input, int currentIndex, int sortKoef){
		T value1 = input.get(currentIndex);
		T value2 = input.get(currentIndex);
		
		ArrayList<T> result = new ArrayList<>();
		
		if (sortKoef * value1.compareTo(value2) > 0)
		{
			result.add(value1);
			result.add(value2);
		}
		else
		{
			result.add(value2);
			result.add(value1);
		}
		
		return result;
	}
	
	@Override
	public TInput Process(TInput input) {
		// not implemented now
		
		// TInput x = new TInput();
		
		// 0. Divide in pairs
		List<ArrayList<T>> divided = new ArrayList<ArrayList<T>>();
		// divided.add(new ArrayList<T>());
		int currentIndex = 0;
		int sortKoef = getSortKoef();
		while (currentIndex <= input.size() - 3){
			divided.add(createPreparedPair(input, currentIndex, sortKoef));
			currentIndex += 2;
		}
		
		return input;
	}

}
