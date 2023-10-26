package com.example.application;

import com.example.ArithmeticCalculator;
import com.example.FullCalculator;

public class MyCalculatorApp {

	public static void main(String[] args) {
		FullCalculator calculator= new FullCalculator();
		if (calculator instanceof ArithmeticCalculator arithmeticCalculator)
		   System.out.println(arithmeticCalculator.mul(5, 8));

	}

}
