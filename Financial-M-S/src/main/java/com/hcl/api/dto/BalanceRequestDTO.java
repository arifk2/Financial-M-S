package com.hcl.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BalanceRequestDTO implements Serializable {
	private static final long serialVersionUID = 4687872239355299088L;

	@JsonFormat
	private String messageId;
	@JsonFormat
	public int customerId;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
