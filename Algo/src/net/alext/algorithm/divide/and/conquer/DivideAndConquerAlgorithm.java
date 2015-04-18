package net.alext.algorithm.divide.and.conquer;

import java.util.List;
import java.util.stream.Collectors;

import net.alext.algorithm.Algorithm;
import net.alext.algorithm.exceptions.AlgorithmException;

public abstract class DivideAndConquerAlgorithm<TInput, TResult> implements Algorithm <TInput, TResult> {

	public abstract TResult ProcessSimple(TInput simple);
	
	public abstract List<TInput> Divide(TInput input);
	
	public abstract TResult Conquer(List<TResult> simples);
	
	@Override
	public TResult Process(TInput input) throws AlgorithmException {
		return Conquer(
				Divide(input).stream()
					.map(x -> ProcessSimple(x))
						.collect(Collectors.toList()) 
				);
	}

}
