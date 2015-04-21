package net.alext.boxing;

public class IntBox extends BaseBox<Integer> {

	@Override
	public BaseBox<Integer> add(AddableBox<Integer> other) {
		Integer otherInt = other.unbox();
		Integer sum = otherInt + instance;
		IntBox result = new IntBox();
		result.box(sum);
		return result;
	}
}
