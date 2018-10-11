package com.hcl.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country implements Serializable{

	private static final long serialVersionUID = -5717036979998619530L;
	
	@Id
	@GeneratedValue
	@Column(name="country_id")
	private int countryId;
	@Column(name="country_name")
	private String countryName;

	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	

}
