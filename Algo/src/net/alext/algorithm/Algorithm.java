package net.alext.algorithm;

import net.alext.algorithm.exceptions.AlgorithmException;

public interface Algorithm <TInput, TResult> {
	public TResult Process(TInput input) throws AlgorithmException;
}
