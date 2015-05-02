package net.alext.boxing;

import com.rits.cloning.Cloner;

public abstract class BaseBox<T extends Comparable<T>> implements AddableBox<T>, Cloneable {

	protected T instance;

	public BaseBox(T initValue){
		super();
		instance = initValue;
	}
	
	public BaseBox(){
		super();
	}
	
	@Override
	public int compareTo(ComparableBox<T> other) {
		return instance.compareTo(other.unbox());
	}

	@Override
	public void box(T t) {
		instance = t;
	}

	@Override
	public T unbox() {
		return instance;
	}

	// seems to impossible to implement, so we make current class abstract
	@Override
	public abstract BaseBox<T> add(AddableBox<T> other);

	@SuppressWarnings("unchecked")
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		Cloner cloner = new Cloner();
		
		T clone = cloner.deepClone(instance);
		
		BaseBox<T> cloneObject;
		try {
			cloneObject = this.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
		
		cloneObject.box(clone);
		
		return cloneObject;
	}
}
