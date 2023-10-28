package com.example;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class StudyInteger {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// object caching: immutable
		Integer x = Integer.valueOf(42);
		Integer y = 42;
		Integer a = 549;
		Integer b = 549;
		System.out.println("x==y? " + (x == y));
		System.out.println("a==b? " + (a == b));
		String r = "Jack"; // cp: constant pool
		String s = "Jack";// cp: constant pool
		String q = new String("Jack"); // heap
		System.out.println("r==s? " + (r == s));
		q = q.intern();
		System.out.println("r==q? " + (r == q));
		// -XX:+UseG1GC
		// -XX:+UseStringDeduplication
		// -XX:+PrintStringDeduplicationStatistics
		BigInteger bi; // Immutable
		BigDecimal bd = BigDecimal.valueOf(1_000); // Immutable
		WeakReference<Object> myref = new WeakReference<Object>(new Object());
		System.out.println(myref.get());
		System.gc();
		System.out.println(myref.get());
	}

}

class Customer {
	private static Map<Integer, Customer> customers = new WeakHashMap<>();

	private int id;

	private Customer(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static Customer of(int id) {

		Customer customer = customers.get(id);
		if (Objects.nonNull(customer))
			return customer;
		Customer cust = new Customer(id);
		customers.put(id, cust);
		return cust;
	}
}
