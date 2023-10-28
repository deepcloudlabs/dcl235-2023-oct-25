package com.example;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Exercise01 {

	public static void main(String[] args) {
		// Object Pooling -> Immutable
		int z = 42; // 4-byte
		// x -> Stack, 8-byte -> Compressed Oops -> 4B
		// new Integer(42) -> Heap ? Object Header: 12-byte + 4-byte = 16-Byte
		// new A()
		Integer x = Integer.valueOf(42); // ?
		Integer y = 42;
		Integer u = 2049;
		Integer v = 2049;
		System.err.println("x==y? %s".formatted(x == y));
		System.err.println("u==v? %s".formatted(u == v));
		List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);

		Map<String, Integer> areaCodes = Map.of("ankara", 312, "istanbul-anadolu", 216, "istanbul-avrupa", 212);
	}

}

@SuppressWarnings("unused")
class A {
	public void fun() {
		var b = new B(); // server vm, c2: escape analysis -> stack
	}
}

class B {
}

enum C {
	C1(1);

	private int data;

	private C(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

}