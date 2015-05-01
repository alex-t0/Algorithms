package net.alext.algorithm.divide.and.conquer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.alext.boxing.BaseBox;
import net.alext.boxing.IntBox;
import net.alext.helpers.ReflectionHelper;

import org.junit.Assert;
import org.junit.Test;

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
		ArrayRangeData<Integer> result = (ArrayRangeData<Integer>) method.invoke(algorithm, list, 3, new ArrayRangeData<Integer>(0, 5));
		
		Assert.assertEquals(0, result.Left);
		Assert.assertEquals(4, result.Right);
		Assert.assertEquals(new Integer(29), result.Sum.unbox());
	}
}
