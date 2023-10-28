package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseText {

	@Test
	void test1() {
		assertEquals(0.9, 2.0 - 1.1);
	}

	@Test
	void test2() {
		assertTrue((0.1 + 0.2) + 0.3 == 0.1 + (02. + 0.3));
	}

}
