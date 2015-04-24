package net.alext.helpers;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionHelper {
	public static Method getMethod(Object obj, String methodName){

		return Arrays.stream(obj.getClass().getDeclaredMethods())
			.filter(x -> { return x.getName() == methodName; }).findFirst().get();
		
	}
}
