package net.alext.matrix;

import net.alext.boxing.IntBox;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
	@Test
	public void TestAddition() throws CloneNotSupportedException {
		IntBox[][] m1Src = { 
				{ new IntBox(1), new IntBox(1) },
				{ new IntBox(1), new IntBox(1) },
		};
		
		IntBox[][] m2Src = { 
				{ new IntBox(2), new IntBox(2) },
				{ new IntBox(2), new IntBox(2) },
		};
		
		Matrix<IntBox, Integer> m1 = new Matrix<>(m1Src);
		Matrix<IntBox, Integer> m2 = new Matrix<>(m2Src);
		
		IntBox[][] resultSrc = { 
				{ new IntBox(3), new IntBox(3) },
				{ new IntBox(3), new IntBox(3) },
		};
		
		Assert.assertEquals(new Matrix<IntBox, Integer>(resultSrc), m1.add(m2));
	}
	
	@Test
	public void TestMultiplication() throws CloneNotSupportedException {
		IntBox[][] m1Src = { 
				{ new IntBox(1), new IntBox(0) },
				{ new IntBox(0), new IntBox(1) },
		};
		
		IntBox[][] m2Src = { 
				{ new IntBox(2), new IntBox(1) },
				{ new IntBox(1), new IntBox(2) },
		};
		
		Matrix<IntBox, Integer> m1 = new Matrix<>(m1Src);
		Matrix<IntBox, Integer> m2 = new Matrix<>(m2Src);
		
		IntBox[][] resultSrc = { 
				{ new IntBox(2), new IntBox(1) },
				{ new IntBox(1), new IntBox(2) },
		};
		
		Assert.assertEquals(new Matrix<IntBox, Integer>(resultSrc), m1.multiply(m2));
	}
	
	@Test
	public void TestMultiplication3x2xx2x3() throws CloneNotSupportedException {
		IntBox[][] m1Src = { 
				{ new IntBox(1), new IntBox(1), new IntBox(1) },
				{ new IntBox(1), new IntBox(1), new IntBox(1) },
		};
		
		IntBox[][] m2Src = { 
				{ new IntBox(1), new IntBox(1) },
				{ new IntBox(1), new IntBox(1) },
				{ new IntBox(1), new IntBox(1) },
		};
		
		Matrix<IntBox, Integer> m1 = new Matrix<>(m1Src);
		Matrix<IntBox, Integer> m2 = new Matrix<>(m2Src);
		
		IntBox[][] resultSrc = { 
				{ new IntBox(3), new IntBox(3) },
				{ new IntBox(3), new IntBox(3) },
		};
		
		Assert.assertEquals(new Matrix<IntBox, Integer>(resultSrc), m1.multiply(m2));
	}
}
