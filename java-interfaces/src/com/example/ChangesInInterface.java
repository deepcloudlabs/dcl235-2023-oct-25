package com.example;

public class ChangesInInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface AA {
	void fun();
	default void sun() { gun(); }
	public static boolean even(int x) {
		run();
		return x%2 == 0;
	}
	public static int cube(int x) {
		run();
		return x*x*x;
	}
	public static int topla(int u,int v) {
		run();
		return u+v;
	}
	private void gun() {}
	private static void run() {}
}

interface F {
	void gun();
}

interface H extends AA, F {
}

abstract class B implements AA {

}

class C implements AA, F {

	@Override
	public void fun() {
	}

	@Override
	public void gun() {
	}

}