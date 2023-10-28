package com.example;

import java.util.List;
import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public class Exercise02 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6 }; // 12B + 4B + 24B = 40B
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6); // 12B + 6*4B + 6 * (12B + 4B)= 132B
		var result1 = numbers[0] + numbers[1];
		var result2 = list.get(0).intValue() + list.get(1).intValue();
		list.stream().filter(I::even).map(t -> t * t * t).reduce(Integer::sum);
		UnaryOperator<String> lower = String::toLowerCase;
		System.out.println(lower.apply("JACK"));

	}

}

interface I {
	static final double PI = 3.1415;
	static boolean even(int n) { return n%2 == 0;}
}