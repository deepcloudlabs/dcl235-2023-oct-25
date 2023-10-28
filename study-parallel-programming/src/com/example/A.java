package com.example;

public class A {

	static {
		System.out.println("What is this static block?");
	}

	{
		System.out.println("What is this block #1?");
	}

	public A() {
		System.out.println("A()");
	}
	
	public A(int i) {
		System.out.println("A(int)");
	}

	public static void main(String[] args) {
		new A();
		new A(42);
	}
	
	{
		System.out.println("What is this block #2?");
	}
}
