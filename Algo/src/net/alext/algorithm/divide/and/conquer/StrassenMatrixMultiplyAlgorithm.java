package net.alext.algorithm.divide.and.conquer;

import java.util.List;

import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerAlgorithmException;
import net.alext.boxing.BaseBox;
import net.alext.matrix.Matrix;

public class StrassenMatrixMultiplyAlgorithm<TValue extends BaseBox<T>, T> 
	extends DivideAndConquerAlgorithm<Matrix<TValue, T>, Matrix<TValue, T>, Matrix<TValue, T>, Matrix<TValue, T>> {

	@Override
	protected Matrix<TValue, T> ProcessSimple(Matrix<TValue, T> input,
			Matrix<TValue, T> simple) throws DivideAndConquerAlgorithmException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Matrix<TValue, T>> Divide(Matrix<TValue, T> input)
			throws DivideAndConquerAlgorithmException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Matrix<TValue, T> Conquer(Matrix<TValue, T> input,
			List<Matrix<TValue, T>> simples)
			throws DivideAndConquerAlgorithmException {
		// TODO Auto-generated method stub
		return null;
	}

}
