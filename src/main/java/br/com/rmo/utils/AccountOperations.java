package br.com.rmo.utils;

import br.com.rmo.entities.Account;

public interface AccountOperations {

	void withdraw(double amount);

	void deposit(double amount);

	void transfer(double amount, Account destinationAccount);

	void printBankStatement();

}
