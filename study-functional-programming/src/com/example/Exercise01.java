package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Exercise01 {

	public static void main(String[] args) {
		var numbers = List.of(4,8,15,16,23,42);
		var totalSum = 0;
		for (var number : numbers) { // external loop
			if (number%2 == 0) {
				var cube = number*number*number;
				totalSum += cube; // mutation
			}
		}
		Object o;
		
		System.out.println("imperative: %d".formatted(totalSum));
		// JS, Python: Generator Function
		// Java (Stream API), C# (LINQ), C++20 (Ranges Api)
		var list = numbers.stream() // internal loop
				          .parallel()
				          .filter(n -> n%2 == 0)
				          .map(u -> u*u*u)
				          .collect(Collectors.toCollection(() -> new ArrayList<>()));
				                   
	}

}

@SuppressWarnings("serial")
class A implements Serializable {}