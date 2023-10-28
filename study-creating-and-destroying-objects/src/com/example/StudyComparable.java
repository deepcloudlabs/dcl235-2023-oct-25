package com.example;

import java.util.Set;
import java.util.TreeSet;

public class StudyComparable {

	public static void main(String[] args) {
		Set<Account> accounts = new TreeSet<>();
		accounts.add(new Account("tr1", 1_000.0));
		accounts.add(new Account("tr2", 3_000.0));
		accounts.add(new Account("tr3", 2_000.0));
		for (var account : accounts) {
			System.out.println(account);
		}
	}

}

class Account implements Comparable<Account>{
	private String iban;
	private double balance = Double.NaN;

	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

	@Override
	public int compareTo(Account other) {
		// 0 : this.equals(other)==>true
		// -1:  this < other
		// +1: other < this
		return this.iban.compareTo(other.iban);
	}

}