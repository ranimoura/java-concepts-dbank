package br.com.rmo.entities;

import java.io.Serializable;

public final class BusinessAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;

	public BusinessAccount(Client client) {
		super(client);

	}

	public BusinessAccount(Client client, Double balance) {
		super(client, balance);
	}

}
