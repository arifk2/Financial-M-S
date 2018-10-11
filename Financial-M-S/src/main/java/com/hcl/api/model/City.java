package com.hcl.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City implements Serializable{

	private static final long serialVersionUID = -5717036979998619530L;
	
	@Id
	@GeneratedValue
	@Column(name="city_id")
	private int cityId;
	@Column(name="city_name")
	private int cityName;
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getCityName() {
		return cityName;
	}
	public void setCityName(int cityName) {
		this.cityName = cityName;
	}
	

}