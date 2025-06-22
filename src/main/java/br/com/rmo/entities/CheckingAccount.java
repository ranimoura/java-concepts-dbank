package br.com.rmo.entities;

import java.io.Serializable;

public final class CheckingAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private static double LOAN_FEE = 10.0;

	private Double loanLimit;

	public CheckingAccount(Client client) {
		super(client);

	}

	public CheckingAccount(Client client, Double balance) {
		super(client, balance);
		this.loanLimit = 0.0;

	}

	public CheckingAccount(Client client, Double balance, Double loanLimit) {
		super(client, balance);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(double amount) {
		if (amount <= loanLimit) {
			this.balance += amount - LOAN_FEE;
		}
	}
}
