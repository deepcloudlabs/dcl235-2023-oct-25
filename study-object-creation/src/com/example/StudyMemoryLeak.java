package com.example;

import java.util.HashSet;
import java.util.Set;

public class StudyMemoryLeak {

	public static void main(String[] args) {
		Set<A> set = new HashSet<>();
		for (int i=0;i<=100;++i) {
			set.add(new A(i));
			set.remove(new A(i));
			System.out.println(set.size());
		}
	}

}

class A {
	private int id;

	public A(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "A [id=" + id + "]";
	}


	
}