package net.alext.matrix;

import net.alext.boxing.BaseBox;

public class Matrix<TValue extends BaseBox<T>, T extends Comparable<T>> {

	private TValue[][] matrix;
	
	@SuppressWarnings("unchecked")
	public Matrix(int rowsCount, int colsCount) {
		matrix = (TValue[][]) new BaseBox[rowsCount][colsCount];
	}

	public int getX(){
		return matrix.length;
	}
	
	public int getY(){
		return matrix[0].length;
	}
	
	public T get(int x, int y){
		return matrix[x][y].unbox();
	}
	
	public void set(T val, int x, int y){
		matrix[x][y].unbox();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		Matrix<TValue, T> otherMatrix = (Matrix<TValue, T>) other;
		
		if (otherMatrix == null)
			return false;
		
		if (getX() != otherMatrix.getX() || getY() != otherMatrix.getY())
			return false;
		
		for (int i = 0; i < getX(); i++)
			for (int j = 0; i < getY(); j++)
				if (!get(i, j).equals(otherMatrix.get(i, j)))
					return false;
		
		return true;
	}
	
	public Matrix<TValue, T> add(Matrix<TValue, T> other) {
		if (getX() != other.getX() || getY() != other.getY())
			throw new IllegalStateException("Size must be identical to add");
		
		Matrix<TValue, T> result = new Matrix<TValue, T>(getX(), getY());
		
		return result;
	}
}
