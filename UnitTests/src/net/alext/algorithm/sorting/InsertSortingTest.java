package net.alext.algorithm.sorting;

import java.util.Arrays;
import java.util.List;

import net.alext.algorithm.exceptions.AlgorithmException;
import net.alext.algorithm.sorting.exceptions.ZeroSizeSortingAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

public class InsertSortingTest {
	@Test
	public void TestSorting() throws AlgorithmException {
		SortingAlgorithm<List<Integer>, Integer> algorithm = new InsertSortingAlgorithm<>();
		
		List<Integer> processed = algorithm.Process(Arrays.<Integer>asList(1, 3, 2));
		Assert.assertEquals(Arrays.<Integer>asList(1, 2, 3), processed);
		
		processed = algorithm.Process(Arrays.<Integer>asList(1, 3, 2, 17, -2, 10, 2));
		Assert.assertEquals(Arrays.<Integer>asList(-2, 1, 2, 2, 3, 10, 17), processed);
		
		algorithm.SetDirection(SortDirection.Descending);
		processed = algorithm.Process(Arrays.<Integer>asList(1, 3, 2, 17, -2, 10, 2));
		Assert.assertEquals(Arrays.<Integer>asList(17, 10, 3, 2, 2, 1, -2), processed);
		
		processed = algorithm.Process(Arrays.<Integer>asList(1));
		Assert.assertEquals(Arrays.<Integer>asList(1), processed);
	}
	
	@Test(expected = ZeroSizeSortingAlgorithmException.class)
	public void TestExceptionWhenEmpty() throws AlgorithmException {
		SortingAlgorithm<List<Integer>, Integer> algorithm = new InsertSortingAlgorithm<>();
		
		algorithm.Process(Arrays.<Integer>asList());
	}
}
