package com.example;

import static com.example.Operator.ADD;

public class UseEnumsInsteadOfIntegerConstants {
	public static void main(String[] args) {
		System.err.println(ADD.apply(3, 2));
		for (var status : AccountStatus.values()) {
			System.err.println(status.name() + ": " + status.ordinal() + ", " + status.getCode());
		}
		AccountStatus status = AccountStatus.ACTIVE;
		switch (status) {
		case ACTIVE:

			break;
		case BLOCKED:

			break;
		case CLOSED:

			break;
		}
	}
}

class Account {
	private AccountStatus status = AccountStatus.ACTIVE; // ACTIVE, BLOCKED, CLOSED, ...

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

}

enum AccountStatus {
	ACTIVE, BLOCKED, CLOSED;

	public int getCode() {
		return 100 * (ordinal() + 1);
	}

}

enum Operator {
	ADD("+") {

		@Override
		double apply(double x, double y) {
			return x + y;
		}

	},
	SUBTRACT("-") {

		@Override
		double apply(double x, double y) {
			return x - y;
		}

	};

	private String symbol;

	private Operator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	abstract double apply(double x, double y);
}