package net.alext.matrix;

import net.alext.boxing.IntBox;
import net.alext.utils.RandomUtil;

import org.junit.Assert;
import org.junit.Test;

public class BigMultiplyTest {
	
	private void populateMatrix(IntBox[][] matrix){
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = new IntBox(RandomUtil.getRandomInt(100));
			}
	}
	
	@Test
	public void MultiplyBigMatrixTest() throws CloneNotSupportedException {
		int N = 500;
		
		IntBox[][] m1Src = new IntBox[N][N];
		
		IntBox[][] m2Src = new IntBox[N][N];
		
		populateMatrix(m1Src);
		populateMatrix(m2Src);
		
		System.out.println("Populated. Calculating multiplication");
		
		Matrix<IntBox, Integer> m1 = new Matrix<>(m1Src);
		Matrix<IntBox, Integer> m2 = new Matrix<>(m2Src);
		
		Assert.assertNotNull(m1.multiply(m2));
		
		System.out.println("Finished.");
	}
}
