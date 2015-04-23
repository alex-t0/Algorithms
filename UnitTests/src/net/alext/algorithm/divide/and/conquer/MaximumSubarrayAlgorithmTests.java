package net.alext.algorithm.divide.and.conquer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import net.alext.boxing.BaseBox;
import net.alext.boxing.IntBox;

import org.junit.Test;

public class MaximumSubarrayAlgorithmTests {
	@Test
	public void FindCrossingSubArrayMethodTest() throws NoSuchMethodException, SecurityException{
		MaximumSubarrayAlgorithm<List<BaseBox<Integer>>, Integer> algorithm = new MaximumSubarrayAlgorithm<>();
		
		ArrayList<IntBox> list = new ArrayList<>();
		
		list.add(new IntBox(10));
		list.add(new IntBox(5));
		list.add(new IntBox(17));
		list.add(new IntBox(-6));
		list.add(new IntBox(3));
		list.add(new IntBox(-1));
			
		Method method = algorithm.getClass().getDeclaredMethod("FindCrossingSubArray", 
				((BaseBox<Integer>) new IntBox(0)).getClass(), Integer.class);
		
		Assert.assertNotNull(method);
	}
}
