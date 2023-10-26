package com.example;

public class StudySealedClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

sealed class U permits P, Q, R {
}

class V {
}

class W extends V {
}

non-sealed class P extends U {
}

final class Q extends U {
}

sealed class R extends U permits S,T {
}

final class S extends R {}
final class T extends R {}