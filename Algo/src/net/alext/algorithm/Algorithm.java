package net.alext.algorithm;

public interface Algorithm <TInput, TResult> {
	public TResult Process(TInput input);
}
