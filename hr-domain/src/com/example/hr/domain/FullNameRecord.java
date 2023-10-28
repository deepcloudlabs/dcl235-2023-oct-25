package com.example.hr.domain;

public record FullNameRecord(String firstName,String lastName) {

	@Override
	public String toString() {
		return "FullNameRecord [first name:" + firstName + ", last name:" + lastName + "]";
	}

		
}
