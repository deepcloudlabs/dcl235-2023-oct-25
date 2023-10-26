package com.example;

import java.math.BigDecimal;
import java.util.List;

public class StudyFlyWeightExamplesInJava {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Fly-weight -> immutability
		String name1 = "jack"; // String object -> static String -> constant pool -> Metaspace
		String name2 = new String("jack"); // String object -> dynamic -> Heap
		String name3 = "jack";
		name2 = name2.intern(); // constant pool
		System.err.println("name1 == name3 ? "+(name1==name3));
		System.err.println("name1 == name2 ? "+(name1==name2));
		// object pooling -> caching -> immutable
		
		Integer x = Integer.valueOf(42); // boxing 
		Integer y = 42; // since java se6: auto-boxing
		Integer u = 549; // new Integer(549)
		Integer v = 549; // new Integer(549)
		System.err.println("x == y ? "+(x==y));
		System.err.println("u == v ? "+(u==v));

		BigDecimal fortyTwo = BigDecimal.valueOf(42); // Immutable
		System.out.println(fortyTwo);
		fortyTwo = fortyTwo.add(BigDecimal.ONE);
		System.out.println(fortyTwo);
		
		int w = 42; // 4B
		Integer wi = 42; // sizeof(header + attributes): 12B + 4B = 16B
		List<Integer> numbers; // 1M elements -> 4M -> 16M -> 12M
		// class, annotation, interface, enum, record (immutable) (java 14,15,16 preview)
		// DDD (Domain-Driven Design)
		// Tactical Patterns -> Aggregate/Entity/Value Object
		// Builder -> Entity
		// Value Object (record) -> immutable -- some --> Fly-weight 
	}

}
