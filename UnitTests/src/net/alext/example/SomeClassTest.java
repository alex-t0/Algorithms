package net.alext.example;

import org.junit.Assert;
import org.junit.Test;

public class SomeClassTest {
	
	@Test
	public void Test1(){
		SomeClass sc = new SomeClass();
		
		Assert.assertEquals(5, sc.return5());
	}
}
