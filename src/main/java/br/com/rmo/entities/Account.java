package br.com.rmo.entities;

import java.io.Serializable;

import br.com.rmo.utils.AccountOperations;

public sealed abstract class Account implements AccountOperations, Serializable
		permits CheckingAccount, SavingsAccount, BusinessAccount {
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_AGENCY = 1;
	private static Integer ACCOUNT_SEQUENCE_NUMBER = 1;

	// TAXAS BANCÁRIAS:
	public static double ACC_WITHDRAW_FEE = 3.0;
	public static double ACC_TRANSFER_FEE = 5.0;

	private Integer agency;
	private Integer accountNumber;
	protected Double balance;
	private Client client;

	public Account(Client client) {
		this.client = client;
		this.agency = Account.DEFAULT_AGENCY;
		this.accountNumber = autoincrementAccountSequenceNumber();
		this.balance = 0.0;

	}

	public Account(Client client, Double balance) {
		this.client = client;
		this.balance = balance;
		this.agency = Account.DEFAULT_AGENCY;
		this.accountNumber = autoincrementAccountSequenceNumber();

	}

	// PARA AUTOINCREMENTAR O NÚMERO DA CONTA:
	private static Integer autoincrementAccountSequenceNumber() {
		if (ACCOUNT_SEQUENCE_NUMBER != 1) {
			return ACCOUNT_SEQUENCE_NUMBER;
		}

		return ACCOUNT_SEQUENCE_NUMBER++;
	}

	public Integer getAgency() {
		return agency;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public Client getClient() {
		return client;
	}

	// MÉTODOS DA INTERFACE:
	@Override
	public void withdraw(double amount) {
		balance -= amount - ACC_WITHDRAW_FEE;

	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public void transfer(double amount, Account destinationAccount) {
		// A IMPLEMENTAR
	}

	@Override
	public void printBankStatement() {
		System.out.println(String.format("Titular: %s", this.client.getName()));
		System.out.println(String.format("Agencia: %d", this.agency));
		System.out.println(String.format("Numero da conta: %d", this.accountNumber));
		System.out.println(String.format("Saldo: %.2f", this.balance));

	}

}
