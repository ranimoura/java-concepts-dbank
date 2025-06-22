package br.com.rmo.entities;

import java.io.Serializable;

public final class SavingsAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private static double MONTHLY_INTEREST_RATE = 0.03;

	public SavingsAccount(Client client) {
		super(client);

	}

	public SavingsAccount(Client client, Double balance) {
		super(client, balance);
	}

	public void monthlyUpdateBalance() {
		this.balance += this.balance * MONTHLY_INTEREST_RATE;
	}

}
