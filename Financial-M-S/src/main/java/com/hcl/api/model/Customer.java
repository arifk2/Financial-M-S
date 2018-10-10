package com.hcl.api.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = -3132730108609279984L;

	@Id
	@GeneratedValue
	@Column(name = "CUST_ID")
	private Integer customerId;

	@Column(name = "CUST_NAME")
	private String customerName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_ID")
	private Set<Account> accounts;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
