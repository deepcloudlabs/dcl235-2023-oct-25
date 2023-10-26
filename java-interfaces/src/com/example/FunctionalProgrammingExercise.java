package com.example;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class FunctionalProgrammingExercise {

	public static void main(String[] args) {
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		// HoF: Higher-Order Function: filter/map/reduce
		// Pure Function: Lambda Expression
		int x = 42;
		AAA a = new AAA();
		// function type -> Functional Interface -> SAM
		Predicate<Integer> if_even = u -> u % 2 == 0;
		Function<Integer, Integer> cubed = v -> v * v * v;
		BinaryOperator<Integer> add = (acc, n) -> acc + n;
		var result = numbers.stream().filter(if_even).map(cubed).reduce(0, add);
		result = numbers.stream()
				        .filter(u -> u % 2 == 0)
				        .map(v -> v * v * v)
				        .reduce(0, (acc, n) -> acc + n);
		result = numbers.stream()
						.filter(AA::even)
						.map(AA::cube)
						.reduce(0, AA::topla);
		System.out.println(result);
	}

}

class AAA {
}