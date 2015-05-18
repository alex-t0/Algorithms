package net.alext.boxing;

public class IntBox extends ComparableBaseBox<Integer> {

	public IntBox() {
		super(0);
	}

	public IntBox(Integer initValue) {
		super(initValue);
	}
	
	@Override
	public BaseBox<Integer> add(AddableBox<Integer> other) {
		Integer otherInt = other.unbox();
		return new IntBox(otherInt + instance);
	}

	@Override
	public BaseBox<Integer> multiply(MultiplyableBox<Integer> other) {
		Integer otherInt = other.unbox();
		return new IntBox(otherInt * instance);
	}

	@Override
	public AddableBox<Integer> getZero() {
		return new IntBox(0);
	}

	@Override
	public MultiplyableBox<Integer> getOne() {
		return new IntBox(1);
	}
}
