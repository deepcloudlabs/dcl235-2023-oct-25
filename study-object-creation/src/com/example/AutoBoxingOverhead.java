package com.example;

public class AutoBoxingOverhead {

	public static void main(String[] args) {
		Integer sum = 0;
		long begin = System.currentTimeMillis();
		for (int i=0;i<=Integer.MAX_VALUE;++i)
			sum += i;
		long end = System.currentTimeMillis();
		System.out.println("sum: "+sum+" @ "+(end-begin)+ "ms.");
	}

}
