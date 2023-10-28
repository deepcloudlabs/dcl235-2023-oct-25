package com.example.app;

import java.lang.reflect.Field;

import com.example.model.Country;

public class ReflectApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Class<?> clazz = 
				Class.forName("com.example.model.Country");
		Object obj = clazz.newInstance(); // Heap Object
		clazz.getDeclaredMethod("setCode",String.class)
		     .invoke(obj, "TUR");
		Country country = new Country();  // Heap Object
		country.setCode("TUR");
		System.out.println(country);
		System.out.println(obj);
		// JVM : GC / JIT Compiler/Class Loader (Lazy)
		// Eden + S0 + S1 + Tenure + Perm Gen/MetaSpace 
		// Class Object => Perm Gen/MetaSpace
		System.out.println(obj.getClass()); 
		for(Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			System.err.println(field.getName()+": "+field.get(obj));
			field.setAccessible(false);
		}
	}
}
