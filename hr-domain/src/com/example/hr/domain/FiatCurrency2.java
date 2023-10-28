package com.example.hr.domain;

import com.example.ddd.DomainValueObject;

@DomainValueObject
public enum FiatCurrency2 {
	TL(10), USD(20), EUR(30);
	private final int data;

	private FiatCurrency2(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
	
}
