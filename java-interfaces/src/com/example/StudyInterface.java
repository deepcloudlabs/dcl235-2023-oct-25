package com.example;

@SuppressWarnings("unused")
public class StudyInterface {

	public static void main(String[] args) {
		UU u1 = new UU();
		UU u2 = new VV();
		// UU u3 = (UU) new WW(); // static analysis
        I i1 = new WW();
        J j1 = (J) new WW();
	}

}

interface I{}
interface J{}
class UU {}
class VV extends UU {}
class WW implements I{}