package com.example.application;

import com.example.domain.Account;
import com.example.domain.Customer;

public class BankingApp {

	public static void main(String[] args) {
		var jack = new Customer("jack", "shephard");
		jack.getAccounts().add(new Account());
		jack.getAccounts().clear();
		jack.getFirstName().toUpperCase();

	}

}
