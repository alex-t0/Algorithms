package net.alext.algorithm.divide.and.conquer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.alext.algorithm.bruteforce.MaximumSubarrayBruteForceAlgorithm;
import net.alext.algorithm.exceptions.AlgorithmException;
import net.alext.boxing.BaseBox;
import net.alext.boxing.ComparableBaseBox;
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
		MaximumSubarrayAlgorithm<List<ComparableBaseBox<Integer>>, Integer> algorithm = new MaximumSubarrayAlgorithm<>();
		
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
		MaximumSubarrayAlgorithm<List<ComparableBaseBox<Integer>>, Integer> algorithm = new MaximumSubarrayAlgorithm<>();
		// MaximumSubarrayBruteForceAlgorithm<List<BaseBox<Integer>>, Integer> algorithm = new MaximumSubarrayBruteForceAlgorithm<>();
		List<ComparableBaseBox<Integer>> list = new ArrayList<>();
		
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
		list.add(new IntBox(0));
		list.add(new IntBox(-5));
		list.add(new IntBox(-22));
		list.add(new IntBox(15));
		list.add(new IntBox(-4));
		list.add(new IntBox(7));
		
		ArrayRangeSumData<Integer> result = algorithm.Process(list);
		
		Assert.assertEquals(new Integer(7), result.MaximumSubArrayIndexLeft);
		Assert.assertEquals(new Integer(11), result.MaximumSubArrayIndexRight);
		Assert.assertEquals(new Integer(43), result.Sum.unbox());
	}
	
	@Test
	public void CompareAlgorithmsOnOneBigArrayTest() throws AlgorithmException {
		MaximumSubarrayAlgorithm<List<ComparableBaseBox<Integer>>, Integer> clever = new MaximumSubarrayAlgorithm<>();
		MaximumSubarrayBruteForceAlgorithm<List<ComparableBaseBox<Integer>>, Integer> bruteForce = new MaximumSubarrayBruteForceAlgorithm<>();
		List<ComparableBaseBox<Integer>> listClever = new ArrayList<>();
		
		int N = 1000;
		
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
		Assert.assertEquals(resultClever.Sum.unbox(), resultBruteForce.Sum.unbox());
	}
	
	@Test
	public void SpecialTest() throws AlgorithmException {
		MaximumSubarrayAlgorithm<List<ComparableBaseBox<Integer>>, Integer> clever = new MaximumSubarrayAlgorithm<>();
		MaximumSubarrayBruteForceAlgorithm<List<ComparableBaseBox<Integer>>, Integer> brute = new MaximumSubarrayBruteForceAlgorithm<>();
		List<ComparableBaseBox<Integer>> list1 = new ArrayList<>();
		List<ComparableBaseBox<Integer>> list2 = new ArrayList<>();
		
		list1.add(new IntBox(-83483));		list2.add(new IntBox(-83483));
		list1.add(new IntBox(3026));		list2.add(new IntBox(3026));
		list1.add(new IntBox(-42717));		list2.add(new IntBox(-42717));
		list1.add(new IntBox(42093));		list2.add(new IntBox(42093));
		list1.add(new IntBox(-14678));		list2.add(new IntBox(-14678));
		list1.add(new IntBox(14678));		list2.add(new IntBox(14678));
		list1.add(new IntBox(-98035));		list2.add(new IntBox(-98035));
		list1.add(new IntBox(-99417));		list2.add(new IntBox(-99417));
		list1.add(new IntBox(30257));		list2.add(new IntBox(30257));
		list1.add(new IntBox(8774));		list2.add(new IntBox(8774));
		
		ArrayRangeSumData<Integer> result1 = clever.Process(list1);
		ArrayRangeSumData<Integer> result2 = brute.Process(list2);
		
		Assert.assertEquals(result1.MaximumSubArrayIndexLeft, result2.MaximumSubArrayIndexLeft);
		Assert.assertEquals(result1.MaximumSubArrayIndexRight, result2.MaximumSubArrayIndexRight);
		Assert.assertEquals(result2.Sum.unbox(), result2.Sum.unbox());
	}

	@Test
	public void SpecialTest2() throws AlgorithmException {
		MaximumSubarrayAlgorithm<List<ComparableBaseBox<Integer>>, Integer> clever = new MaximumSubarrayAlgorithm<>();
		MaximumSubarrayBruteForceAlgorithm<List<ComparableBaseBox<Integer>>, Integer> brute = new MaximumSubarrayBruteForceAlgorithm<>();
		List<ComparableBaseBox<Integer>> list1 = new ArrayList<>();
		List<ComparableBaseBox<Integer>> list2 = new ArrayList<>();
		
		list1.add(new IntBox(-35161));		list2.add(new IntBox(-35161));
		list1.add(new IntBox(0));		list2.add(new IntBox(0));
		list1.add(new IntBox(85349));		list2.add(new IntBox(85349));
		list1.add(new IntBox(23408));		list2.add(new IntBox(23408));
		list1.add(new IntBox(19434));		list2.add(new IntBox(19434));
		list1.add(new IntBox(67831));		list2.add(new IntBox(67831));
		list1.add(new IntBox(64155));		list2.add(new IntBox(64155));
		list1.add(new IntBox(69255));		list2.add(new IntBox(69255));
		list1.add(new IntBox(95794));		list2.add(new IntBox(95794));
		list1.add(new IntBox(-76235));		list2.add(new IntBox(-76235));
		
		ArrayRangeSumData<Integer> result1 = clever.Process(list1);
		ArrayRangeSumData<Integer> result2 = brute.Process(list2);
		
		Assert.assertEquals(result1.MaximumSubArrayIndexLeft, result2.MaximumSubArrayIndexLeft);
		Assert.assertEquals(result1.MaximumSubArrayIndexRight, result2.MaximumSubArrayIndexRight);
		Assert.assertEquals(result2.Sum.unbox(), result2.Sum.unbox());
	}
	
	@Test
	public void CompareAlgorithmsOnManySmallArraysTest() throws AlgorithmException {
		MaximumSubarrayAlgorithm<List<ComparableBaseBox<Integer>>, Integer> clever = new MaximumSubarrayAlgorithm<>();
		MaximumSubarrayBruteForceAlgorithm<List<ComparableBaseBox<Integer>>, Integer> bruteForce = new MaximumSubarrayBruteForceAlgorithm<>();
		List<List<ComparableBaseBox<Integer>>> listClever = new ArrayList<>();
		List<List<ComparableBaseBox<Integer>>> listBruteForce = new ArrayList<>();
		
		int N = 50000;
		
		for (int i = 0; i < N; i++){
			
			List<ComparableBaseBox<Integer>> iterateListClever = new ArrayList<>();
			List<ComparableBaseBox<Integer>> iterateListBruteForce = new ArrayList<>();
			
			for (int j = 0; j < 10; j++){
				int intValue = RandomUtil.getRandomInt(100000);
				
				iterateListClever.add(new IntBox(intValue));
				iterateListBruteForce.add(new IntBox(intValue));
			}
			
			listClever.add(iterateListClever);
			listBruteForce.add(iterateListBruteForce);
		}
		
		List<ArrayRangeSumData<Integer>> cleverResult = new ArrayList<>();
		System.out.println("running clever...");
		for (int i = 0; i < N; i++){
			cleverResult.add(clever.Process(listClever.get(i)));
		}
		System.out.println("clever finished");
		
		List<ArrayRangeSumData<Integer>> bruteForceResult = new ArrayList<>();
		System.out.println("running brute force...");
		for (int i = 0; i < N; i++){
			bruteForceResult.add(bruteForce.Process(listBruteForce.get(i)));
		}
		System.out.println("brute force finished");
		
		for (int i = 0; i<N; i++) {
			boolean true1 = cleverResult.get(i).MaximumSubArrayIndexLeft.equals(bruteForceResult.get(i).MaximumSubArrayIndexLeft);
			boolean true2 = cleverResult.get(i).MaximumSubArrayIndexRight.equals(bruteForceResult.get(i).MaximumSubArrayIndexRight);
			boolean true3 = cleverResult.get(i).Sum.unbox().equals(bruteForceResult.get(i).Sum.unbox());
			
			if (!(true1 && true2 && true3)){
				System.out.println("Size = " + listClever.get(i).size());
				listClever.get(i).stream().forEach(x -> { System.out.println(x.unbox()); });
			}
			
			Assert.assertEquals(cleverResult.get(i).MaximumSubArrayIndexLeft, bruteForceResult.get(i).MaximumSubArrayIndexLeft);
			Assert.assertEquals(cleverResult.get(i).MaximumSubArrayIndexRight, bruteForceResult.get(i).MaximumSubArrayIndexRight);
			Assert.assertEquals(cleverResult.get(i).Sum.unbox(), bruteForceResult.get(i).Sum.unbox());
		}
	}
}
