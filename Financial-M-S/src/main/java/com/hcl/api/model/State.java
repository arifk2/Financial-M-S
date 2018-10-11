package com.hcl.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class State implements Serializable{

	private static final long serialVersionUID = 6245326498222657847L;
	
	@Id
	@GeneratedValue
	@Column(name="state_id")
	private int stateId;
	@Column(name="state_name")
	private String stateName;
	@Column(name="time_zone")
	private String timeZone;
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	
}
