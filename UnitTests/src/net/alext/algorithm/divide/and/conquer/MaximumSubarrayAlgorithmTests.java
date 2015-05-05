package net.alext.algorithm.divide.and.conquer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.alext.algorithm.bruteforce.MaximumSubarrayBruteForceAlgorithm;
import net.alext.algorithm.exceptions.AlgorithmException;
import net.alext.boxing.BaseBox;
import net.alext.boxing.IntBox;
import net.alext.helpers.ReflectionHelper;

import org.junit.Assert;
import org.junit.Test;
import net.alext.utils.RandomUtil;

public class MaximumSubarrayAlgorithmTests {
	@Test
	public void FindCrossingSubArrayMethodTest() 
			throws NoSuchMethodException, SecurityException, 
					IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		MaximumSubarrayAlgorithm<List<BaseBox<Integer>>, Integer> algorithm = new MaximumSubarrayAlgorithm<>();
		
		ArrayList<IntBox> list = new ArrayList<>();
		
		list.add(new IntBox(10));
		list.add(new IntBox(5));
		list.add(new IntBox(17));
		list.add(new IntBox(-6));
		list.add(new IntBox(3));
		list.add(new IntBox(-1));
			
		Method method = ReflectionHelper.getMethod(algorithm, "FindCrossingSubArray");
		
		Assert.assertNotNull(method);
		method.setAccessible(true);
		
		@SuppressWarnings("unchecked")
		ArrayRangeSumData<Integer> result = (ArrayRangeSumData<Integer>) method.invoke(algorithm, list, 3, new ArrayRangeSumData<Integer>(0, 5));
		
		Assert.assertEquals(new Integer(0), result.MaximumSubArrayIndexLeft);
		Assert.assertEquals(new Integer(4), result.MaximumSubArrayIndexRight);
		Assert.assertEquals(new Integer(29), result.Sum.unbox());
	}
	
	@Test
	public void AlgorithmTest() throws AlgorithmException {
		MaximumSubarrayAlgorithm<List<BaseBox<Integer>>, Integer> algorithm = new MaximumSubarrayAlgorithm<>();
		// MaximumSubarrayBruteForceAlgorithm<List<BaseBox<Integer>>, Integer> algorithm = new MaximumSubarrayBruteForceAlgorithm<>();
		List<BaseBox<Integer>> list = new ArrayList<>();
		
		list.add(new IntBox(13));
		list.add(new IntBox(-3));
		list.add(new IntBox(-25));
		list.add(new IntBox(20));
		list.add(new IntBox(-3));
		list.add(new IntBox(-16));
		list.add(new IntBox(-23));
		list.add(new IntBox(18));
		list.add(new IntBox(20));
		list.add(new IntBox(-7));
		list.add(new IntBox(12));
		list.add(new IntBox(-5));
		list.add(new IntBox(-22));
		list.add(new IntBox(15));
		list.add(new IntBox(-4));
		list.add(new IntBox(7));
		
		ArrayRangeSumData<Integer> result = algorithm.Process(list);
		
		Assert.assertEquals(new Integer(7), result.MaximumSubArrayIndexLeft);
		Assert.assertEquals(new Integer(10), result.MaximumSubArrayIndexRight);
		Assert.assertEquals(new Integer(43), result.Sum.unbox());
	}
	
	@Test
	public void CompareAlgorithmsTest() throws AlgorithmException {
		MaximumSubarrayAlgorithm<List<BaseBox<Integer>>, Integer> clever = new MaximumSubarrayAlgorithm<>();
		MaximumSubarrayBruteForceAlgorithm<List<BaseBox<Integer>>, Integer> bruteForce = new MaximumSubarrayBruteForceAlgorithm<>();
		List<BaseBox<Integer>> listClever = new ArrayList<>();
		
		int N = 1200;
		
		for (int i = 0; i < N; i++){
			listClever.add(new IntBox(RandomUtil.getRandomInt(100000)));
		}
		
		List<BaseBox<Integer>> listBruteForce = new ArrayList<>(); 
		listClever.stream().forEach(x -> { listBruteForce.add(x); });
		
		System.out.println("running clever...");
		ArrayRangeSumData<Integer> resultClever = clever.Process(listClever);
		System.out.println("clever finished");
		System.out.println("running brute force...");
		ArrayRangeSumData<Integer> resultBruteForce = bruteForce.Process(listClever);
		System.out.println("brute force finished");
		
		Assert.assertEquals(resultClever.MaximumSubArrayIndexLeft, resultBruteForce.MaximumSubArrayIndexLeft);
		Assert.assertEquals(resultClever.MaximumSubArrayIndexRight, resultBruteForce.MaximumSubArrayIndexRight);
	}
}
