package br.com.rmo.entities;

import java.io.Serializable;
import java.util.Objects;

public sealed abstract class User implements Serializable permits Client {
	private static final long serialVersionUID = 1L;

	private static Integer USER_SEQUENCE_NUMBER = 1;

	private Integer userId;
	private String name;

	public User(String name) {
		this.name = name;
		this.userId = autoincrementUserSequenceNumber();
	}

	// PARA AUTOINCREMENTAR O NÚMERO DO ID DO USUÁRIO:
	public static Integer autoincrementUserSequenceNumber() {
		if (USER_SEQUENCE_NUMBER != 1) {
			return USER_SEQUENCE_NUMBER;
		}

		return USER_SEQUENCE_NUMBER++;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

}
