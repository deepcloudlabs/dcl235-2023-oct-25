package com.example.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.Identity;

public class MyApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Identity myIdentity1 = Identity.valueOf("1");
		Identity myIdentity2 = Identity.valueOf("2");
		Identity myIdentity3 = Identity.valueOf("1");
		System.err.println("myIdentity1==myIdentity2 ? "+(myIdentity1==myIdentity2));
		System.err.println("myIdentity1==myIdentity3 ? "+(myIdentity1==myIdentity3));
		// BigInteger.probablePrime(...)
		// Wrapper Classes, String
		// Collections.unmodifiableList(list) -> factory method
		var numbers1 = new ArrayList<>(Arrays.asList(1,2,3,4));
		var numbers2 = List.of(1,2,3,4);
		// Factory method: valueOf, of, getXYZ, newXYZ, getInstance(), newInstance()
	}

}
