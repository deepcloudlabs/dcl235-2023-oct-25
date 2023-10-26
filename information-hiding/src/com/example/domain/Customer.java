package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public final class Customer {
	private String firstName;
	private String lastName;
	private final List<Account> accounts; // never let accounts escape outside

	{
		accounts = new ArrayList<>();
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void removeAccount(Account account) {
		accounts.remove(account);
	}
	
	public List<Account> getAccounts() {
		return List.copyOf(accounts);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
