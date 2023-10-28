package com.example;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudyComparable2 {

	public static void main(String[] args) {
//		List<Integer> numbers = List.of(1,2,3,4,5,6);
//		var immutableNumbers = Collections.unmodifiableCollection(Arrays.asList(1,2,3,4,5,6));
//		immutableNumbers.add(42);
//		numbers.add(7);
		var x = new BigDecimal("1.0");
		var y = new BigDecimal("1.00");
		Set<BigDecimal> s = new HashSet<>();
		Set<BigDecimal> t = new TreeSet<>(); // red-black tree
		System.err.println(x.equals(y));    // false
		System.err.println(x.compareTo(y)); // 0
		s.add(x); // 1 equals()
		s.add(y); // 2
		t.add(x); // 1 compareTo()
		t.add(y); // 1
		t.add(x); // 1
		t.add(y); // 1
		System.err.println(s.size()); // 2
		System.err.println(t.size()); // 1
	}

}
