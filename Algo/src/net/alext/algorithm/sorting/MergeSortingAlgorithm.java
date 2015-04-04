package net.alext.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortingAlgorithm <TInput extends List<T>, T extends Comparable<T>> extends SortingAlgorithm<TInput, T> {

	interface InsertAction<T extends Comparable<T>> {
		void Insert(List<T> list, T element, Integer index);
	}
	
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
	
	private List<T> mergeArrays(List<T> list1, List<T> list2, List<T> result, int sortKoef){
		
		int i1 = 0, i2 = 0;
		
		int size1 = list1.size();
		int size2 = list2.size();
		
		int totalSize = size1 + size2;
		
		InsertAction<T> action = (list, element, i) -> {
			list.set(i, element);
		};
		
		if (result == null){
			result = new ArrayList<>(totalSize);
			action = (list, element, i) -> {
				list.add(element);
			};
		}
		
		for (int i = 0; i < totalSize; i++){
			
			if (i1 == size1){	
				action.Insert(result, list2.get(i2), i);
				i2++;
				continue;
			}
			
			if (i2 == size2){
				action.Insert(result, list1.get(i1), i);
				i1++;
				continue;
			}
			
			if (sortKoef * list1.get(i1).compareTo(list2.get(i2)) > 0){
				action.Insert(result, list1.get(i1), i);
				i1++;
			}
			else{
				action.Insert(result, list2.get(i2), i);
				i2++;			
			}
			
		}
		
		return result;
	}
	
	@Override
	public TInput Process(TInput input) {
		// not implemented now
		
		// TInput x = new TInput();
		
		// 0. Divide in pairs
		List<List<T>> divided = new ArrayList<List<T>>();
		int currentIndex = 0;
		int sortKoef = getSortKoef();
		while (currentIndex <= input.size() - 3){
			divided.add(createPreparedPair(input, currentIndex, sortKoef));
			currentIndex += 2;
		}

		// 1. While count of arrays in divided greather than 2, merge first 2 arrays,
		// put result at end, and remove merged arrays from divided
		while (divided.size() > 2){
			divided.add(mergeArrays(divided.get(0), divided.get(1), null, sortKoef));
			divided.remove(0);
			divided.remove(0);
		}
		
		mergeArrays(divided.get(0), divided.get(1), input, sortKoef);
		
		return input;
	}

}
