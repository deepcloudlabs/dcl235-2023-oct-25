package com.example;

public class StudyAbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

@SuppressWarnings("unused")
abstract class Flyable {
	private int data;

	public Flyable() {
	}

	public Flyable(int data) {
		this.data = data;
	}

	abstract public void fly();

	public void fun() {
	}
}

class Bird extends Flyable {
	public void fly() {
	}
}

abstract interface A {
	abstract public void fun();
	abstract void gun();
	public void sun();
	void run();
}

class AirPlane extends Flyable {
	public void fly() {
	}
}

class Superman extends Flyable {
	public void fly() {
	}
}

class Ufo extends Flyable {
	public void fly() {
	}
}