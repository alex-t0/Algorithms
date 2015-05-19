package net.alext.boxing;

import com.rits.cloning.Cloner;

public abstract class BaseBox<T> implements AddableBox<T>, MultiplyableBox<T>, Cloneable {

	protected T instance;

	public BaseBox(T initValue){
		super();
		instance = initValue;
	}
	
	public BaseBox(){
		super();
	}
	
	@Override
	public BaseBox<T> box(T t) {
		instance = t;
		return this;
	}

	@Override
	public T unbox() {
		return instance;
	}

	// seems to impossible to implement, so we make current class abstract
	@Override
	public abstract BaseBox<T> add(AddableBox<T> other);

	@Override
	public abstract BaseBox<T> multiply(MultiplyableBox<T> other);
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((instance == null) ? 0 : instance.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseBox<T> other = (BaseBox<T>) obj;
		if (instance == null) {
			if (other.instance != null)
				return false;
		} else if (!instance.equals(other.instance))
			return false;
		return true;
	}
}
