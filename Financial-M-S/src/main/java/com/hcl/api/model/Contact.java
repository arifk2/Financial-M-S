package com.hcl.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Contact implements Serializable {

	private static final long serialVersionUID = -5717036979998619530L;
	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private int contactId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "work_conatct_number")
	private String workConatctNumber;
	@Column(name = "home_conatact_number")
	private String homeConatactNumber;
	@Column(name = "fax")
	private String fax;
	@JsonFormat(pattern = "MM-dd-yyyy")
	@Column(name = "last_login")
	private String lastLogin;
	@JsonFormat(pattern = "MM-dd-yyyy")
	@Column(name = "create_Date")
	private String createDate;

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getContactId() {
		return contactId;
	}

	public Date getCreatedDate() {
		return createDate;
	}

	public void setCreatedDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getWorkConatctNumber() {
		return workConatctNumber;
	}

	public void setWorkConatctNumber(String workConatctNumber) {
		this.workConatctNumber = workConatctNumber;
	}

	public String getHomeConatactNumber() {
		return homeConatactNumber;
	}

	public void setHomeConatactNumber(String homeConatactNumber) {
		this.homeConatactNumber = homeConatactNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}
