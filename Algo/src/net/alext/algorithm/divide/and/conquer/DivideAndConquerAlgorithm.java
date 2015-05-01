package net.alext.algorithm.divide.and.conquer;

import java.util.List;
import java.util.stream.Collectors;

import net.alext.algorithm.Algorithm;
import net.alext.algorithm.divide.and.conquer.exceptions.DivideAndConquerAlgorithmException;
import net.alext.algorithm.exceptions.AlgorithmException;

public abstract class DivideAndConquerAlgorithm<TInput, TResult, TDividedInput, TDividedResult> implements Algorithm <TInput, TResult> {
	
	protected abstract TDividedResult ProcessSimple(TInput input, TDividedInput simple) throws DivideAndConquerAlgorithmException;
	
	protected abstract List<TDividedInput> Divide(TInput input) throws DivideAndConquerAlgorithmException;
	
	protected abstract TResult Conquer(TInput input, List<TDividedResult> simples) throws DivideAndConquerAlgorithmException;
	
	@Override
	public TResult Process(TInput input) throws AlgorithmException {
			return Conquer(input,
					Divide(input).stream()
						.map(x -> { 
							try {
								return ProcessSimple(input, x);
							}
							catch (AlgorithmException ae){
								return null;
							}
					}).collect(Collectors.toList()));
	}

}
