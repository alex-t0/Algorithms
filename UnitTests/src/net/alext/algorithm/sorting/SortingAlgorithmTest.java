package net.alext.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.alext.algorithm.sorting.exceptions.SortingAlgorithmException;
import net.alext.algorithm.sorting.exceptions.ZeroSizeSortingAlgorithmException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SortingAlgorithmTest {
	
	interface AlgorithmCreator {
		SortingAlgorithm<List<Integer>, Integer> Create();
	}
	
	private AlgorithmCreator creator;
	
	@Parameters
	public static Iterable<Object[]> Algorithms() {
		
		return Arrays.asList((Object[][])new AlgorithmCreator[][] { 
			{ () -> new BubbleSortingAlgorithm<List<Integer>, Integer>() },
			{ () -> new InsertSortingAlgorithm<List<Integer>, Integer>() },
			{ () -> new MergeSortingAlgorithm<List<Integer>, Integer>() }
		});
	}
	
	public SortingAlgorithmTest(AlgorithmCreator creator) {
		super();
		this.creator = creator;
	}

	@Test
	public void CommonCases() throws SortingAlgorithmException {
		
		SortingAlgorithm<List<Integer>, Integer> algorithm = creator.Create();
		
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
	public void TestExceptionWhenEmpty() throws SortingAlgorithmException {
		SortingAlgorithm<List<Integer>, Integer> algorithm = creator.Create();
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
	public void BigArrayTest() throws SortingAlgorithmException {
			
		ArrayList<Integer> toSort = new ArrayList<>();
		
		for (int i=0; i<100000; i++){
			toSort.add(generateRandomInteger(0, 1000000));
		}
		
		SortingAlgorithm<List<Integer>, Integer> algorithm = creator.Create();
		List<Integer> sorted = algorithm.Process(toSort);
			
		for (int i = 0; i< toSort.size() - 1; i++){
			Assert.assertTrue(sorted.get(i) <= sorted.get(i+1));
		}
	}
}
