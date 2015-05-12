package net.alext.matrix;

import net.alext.boxing.BaseBox;

public class Matrix<TValue extends BaseBox<T>, T extends Comparable<T>> {

	private TValue[][] matrix;
	
	@SuppressWarnings("unchecked")
	public Matrix(int rowsCount, int colsCount) {
		matrix = (TValue[][]) new BaseBox[rowsCount][colsCount];
	}

	public Matrix(TValue[][] data) {
		this(data.length, data[0].length);
		
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++){
				matrix[i][j] = data[i][j];
			}
	}
	
	public int getX(){
		return matrix.length;
	}
	
	public int getY(){
		return matrix[0].length;
	}
	
	public TValue get(int x, int y){
		return matrix[x][y];
	}
	
	public void set(TValue val, int x, int y){
		matrix[x][y] = val;
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
			for (int j = 0; j < getY(); j++){
				if (get(i, j) == null || otherMatrix.get(i, j) == null)
					return false;
				
				if (!get(i, j).equals(otherMatrix.get(i, j)))
					return false;
			}
				
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public Matrix<TValue, T> add(Matrix<TValue, T> other) throws CloneNotSupportedException {
		if (getX() != other.getX() || getY() != other.getY())
			throw new IllegalStateException("Size must be identical to add");
		
		Matrix<TValue, T> result = new Matrix<TValue, T>(getX(), getY());
		
		for (int i = 0; i < getX(); i++)
			for (int j = 0; j < getY(); j++)
			{
				if (get(i, j) == null || other.get(i, j) == null)
					throw new IllegalStateException("Values of matrix must be not null");
				
				TValue sum = (TValue) get(i, j).clone();
				
				sum.box(get(i, j).add(other.get(i, j)).unbox());
				
				result.set(sum, i, j);
			}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Matrix<TValue, T> multiply(Matrix<TValue, T> other) throws CloneNotSupportedException {
		if (getX() != other.getY())
			throw new IllegalStateException("Illegal number of rows and columns of matrices");
		
		Matrix<TValue, T> result = new Matrix<TValue, T>(getX(), other.getY());
		
		BaseBox<T> zero = (BaseBox<T>) get(0, 0).getZero();
		
		for (int i = 0; i < getX(); i++){
			for (int j = 0; j < getY(); j++)
			{
				// result.set((TValue)zero.clone(), i, j);
				
				if (get(i, j) == null || other.get(j, i) == null)
					throw new IllegalStateException("Values of matrix must be not null");
				
				TValue current = result.get(i, j);
				
				if (current == null){
					current = (TValue) zero.clone();
					result.set(current, i, j);
				}
				
				current = (TValue) current.add(get(i, j).multiply(other.get(j, i)));
				
				// result.set(current, i, j);
			}
		}
		
		return result;
	}
}
