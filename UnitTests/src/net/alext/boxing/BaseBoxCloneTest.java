package net.alext.boxing;

import org.junit.Assert;
import org.junit.Test;

public class BaseBoxCloneTest {
	@Test
	public void CloneTest() throws CloneNotSupportedException{
		IntBox ibox = new IntBox(25);
		
		IntBox clone = (IntBox) ibox.clone();
		
		Assert.assertNotNull(clone);
		Assert.assertNotNull(clone.unbox());
	}
}
