package com.hcl.api.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BalanceResponseDTO implements Serializable {
	private static final long serialVersionUID = 6986306929908919970L;

	@JsonFormat
	private int customerId;
	@JsonFormat
	private Set<AccountDTO> accounts;

	public Set<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountDTO> accounts) {
		this.accounts = accounts;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
