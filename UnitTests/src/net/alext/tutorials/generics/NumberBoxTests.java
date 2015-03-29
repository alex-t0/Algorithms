package net.alext.tutorials.generics;

import org.junit.Test;

public class NumberBoxTests {
	
	@Test
	public void Test1(){
		@SuppressWarnings("unused")
		NumberBox<Number> n = new NumberBox<Number>(1);
		@SuppressWarnings("unused")
		NumberBox<Integer> i = new NumberBox<Integer>(1);
		
		// n = i;
	}
}
