package com.hcl.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 8884817651792885370L;

	@Id
	@GeneratedValue
	private int roleId;

	@Column(name = "description")
	private String description;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "created_Date")
	@JsonFormat(pattern = "MM-dd-yyyy")
	private String createdDate;
	@Column(name = "modified_Date")
	@JsonFormat(pattern = "MM-dd-yyyy")
	private String modifiedDate;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
