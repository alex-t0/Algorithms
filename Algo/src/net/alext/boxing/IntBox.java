package net.alext.boxing;

public class IntBox extends BaseBox<Integer> {

	public IntBox() {
		super();
	}

	public IntBox(Integer initValue) {
		super(initValue);
	}

	@Override
	public BaseBox<Integer> add(AddableBox<Integer> other) {
		Integer otherInt = other.unbox();
		IntBox result = new IntBox();
		result.box(otherInt + instance);
		return result;
	}

	@Override
	public BaseBox<Integer> multiply(MultiplyableBox<Integer> other) {
		Integer otherInt = other.unbox();
		IntBox result = new IntBox();
		result.box(otherInt * instance);
		return result;
	}
}
