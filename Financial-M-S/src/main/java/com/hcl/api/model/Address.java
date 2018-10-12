package com.hcl.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = -1383027263450975816L;

	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private int addressId;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "longitute")
	private String longitute;
	@Column(name = "create_date")
	private String createDate;
	@Column(name = "zip")
	private String zip;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitute() {
		return longitute;
	}

	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
