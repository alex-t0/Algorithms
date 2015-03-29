package net.alext.algorithm.sorting;

import java.util.Arrays;
import java.util.List;

import net.alext.algorithm.sorting.exceptions.SortingAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

public class InsertSortingTest {
	@Test
	public void Test1() throws SortingAlgorithmException{
		InsertSortingAlgorithm<List<Integer>, Integer> algorithm = new InsertSortingAlgorithm<>();
		
		List<Integer> processed = algorithm.Process(Arrays.<Integer>asList(1, 3, 2));
		Assert.assertEquals(Arrays.<Integer>asList(1, 2, 3), processed);
	}
}
