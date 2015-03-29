package net.alext.tutorials.generics;

import org.junit.Test;

public class NumberBoxTests {
	
	@Test
	public void Test1(){
		NumberBox<Number> n = new NumberBox<Number>(1);
		NumberBox<Integer> i = new NumberBox<Integer>(1);
		
		// n = i;
	}
}
