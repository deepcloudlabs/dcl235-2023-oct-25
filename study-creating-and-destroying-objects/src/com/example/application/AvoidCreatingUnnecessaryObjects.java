package com.example.application;

public class AvoidCreatingUnnecessaryObjects {

	public static void main(String[] args) {
		new A(); // sizeof() ? header + fields -- A --> header (12Byte) - memory -> 16B
		// 64-bit system
		// Developer --> Object Pooling --> immutable
	}

}

class A {}