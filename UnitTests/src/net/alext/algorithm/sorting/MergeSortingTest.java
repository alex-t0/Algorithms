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

public class MergeSortingTest {
	@Test
	public void Test1() throws ZeroSizeSortingAlgorithmException{
		MergeSortingAlgorithm<List<Integer>, Integer> algorithm = new MergeSortingAlgorithm<>();
		
		List<Integer> processed = algorithm.Process(Arrays.<Integer>asList(1, 3, 2));
		
		Assert.assertEquals(Arrays.<Integer>asList(1, 2, 3), processed);
		
		algorithm.SetDirection(SortDirection.Descending);
		
		processed = algorithm.Process(Arrays.<Integer>asList(1, 3, 2));
		Assert.assertEquals(Arrays.<Integer>asList(3, 2, 1), processed);
		
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
		
		SortingAlgorithm<List<Integer>, Integer> algorithm = new MergeSortingAlgorithm<>();
		
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
