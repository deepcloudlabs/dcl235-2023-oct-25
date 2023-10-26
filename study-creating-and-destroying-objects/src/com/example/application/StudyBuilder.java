package com.example.application;

import com.example.Customer;

public class StudyBuilder {

	public static void main(String[] args) {
		var jack = new Customer.Builder("1") // Domain Specific Language 
							   .birthYear(1976)
				               .fullname("jack bauer")
				               .sms("+90 555 5555")
				               .email("jack@example.com")
				               //.addresses("address 1", "address 2")
				               .photo("base64".getBytes())
				               .build();
		System.err.println(jack);

	}

}
