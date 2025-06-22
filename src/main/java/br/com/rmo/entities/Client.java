package br.com.rmo.entities;

import java.io.Serializable;

import br.com.rmo.entities.enums.MaritalStatus;

public non-sealed class Client extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private MaritalStatus maritalStatus;

	public Client(String name, String email, MaritalStatus maritalStatus) {
		super(name);
		this.email = email;
		this.maritalStatus = maritalStatus;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

}
