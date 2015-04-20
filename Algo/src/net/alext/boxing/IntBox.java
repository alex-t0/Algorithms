package net.alext.boxing;

public class IntBox implements AddableBox<Integer> {

	private Integer instance;
	
	@Override
	public void box(Integer val) {
		instance = val;
		
	}

	@Override
	public Integer unbox() {
		return instance;
	}

	@Override
	public AddableBox<Integer> add(AddableBox<Integer> other) {
		Integer result = instance + other.unbox();
		IntBox boxResult = new IntBox();
		boxResult.box(result);
		return boxResult;
	}

}
