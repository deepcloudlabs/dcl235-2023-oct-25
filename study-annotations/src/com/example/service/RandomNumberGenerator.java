package com.example.service;

import java.util.Random;
import java.util.stream.Collectors;

import com.example.model.RandomNumber;

public class RandomNumberGenerator {
	public static void generate(Object o) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = o.getClass();
		for (var field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				var rn = field.getAnnotation(RandomNumber.class);
				var stream = new Random().ints(rn.min(), rn.max());
				if (rn.distinct())
					stream = stream.distinct();
				stream = stream.limit(rn.size());
				if (rn.sorted())
					stream = stream.sorted();
				var numbers = stream.boxed().collect(Collectors.toList());
				field.setAccessible(true);
				field.set(o, numbers);
				field.setAccessible(false);
			}
		}

	}
}
