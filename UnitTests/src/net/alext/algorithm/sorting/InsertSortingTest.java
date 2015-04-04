package net.alext.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
		
		processed = algorithm.Process(Arrays.<Integer>asList(25, 25));
		Assert.assertEquals(Arrays.<Integer>asList(25, 25), processed);
		
		processed = algorithm.Process(Arrays.<Integer>asList(25));
		Assert.assertEquals(Arrays.<Integer>asList(25), processed);
	}
	
	@Test(expected = ZeroSizeSortingAlgorithmException.class)
	public void TestExceptionWhenEmpty() throws AlgorithmException {
		SortingAlgorithm<List<Integer>, Integer> algorithm = new InsertSortingAlgorithm<>();
		
		algorithm.Process(Arrays.<Integer>asList());
	}
	
	public static int generateRandomInteger(int min, int max) {
	    // SecureRandom rand = new SecureRandom();
		Random rand = new Random();
	    rand.setSeed(new Date().getTime());
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	@Test
	public void BigArrayTest() throws AlgorithmException {
		
		SortingAlgorithm<List<Integer>, Integer> algorithm = new InsertSortingAlgorithm<>();
		
		ArrayList<Integer> toSort = new ArrayList<>();
		
		for (int i=0; i<100000; i++){
			toSort.add(generateRandomInteger(0, 1000000));
		}
		
		System.out.println("Size of toSort: " + toSort.size());
			
		List<Integer> sorted = algorithm.Process(toSort);
		
		System.out.println("Now sorted");
		
		for (int i = 0; i< toSort.size() - 1; i++){
			Assert.assertTrue(sorted.get(i) <= sorted.get(i+1));
		}
	}
}
