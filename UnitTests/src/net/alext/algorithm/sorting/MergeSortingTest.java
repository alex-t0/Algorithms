package net.alext.algorithm.sorting;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MergeSortingTest {
	@Test
	public void Test1(){
		MergeSortingAlgorithm<List<Integer>, Integer> algorithm = new MergeSortingAlgorithm<>();
		
		List<Integer> process = algorithm.Process(Arrays.<Integer>asList(1, 3, 2));
	}
}
