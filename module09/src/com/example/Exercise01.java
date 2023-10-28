package com.example;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Exercise01 {
	public static void main(String[] args) {
		var list = List.of(new A(42),new A(108));
		System.out.println(list.contains(new A(108)));
		var set = new HashSet<A>(list);
		System.out.println(set.contains(new A(108)));	
		double x = 0.0/0.0;
		System.out.println(x == x);
	}
}

class A{
	private Integer data;

	public A(int data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		System.err.println("A::hashCode");
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		System.err.println("A::equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		return Objects.equals(data, other.data);
	}

	
	
}