package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Admin")
public class AdminUser extends User{
	@Column(columnDefinition = "Number(1)")
	private boolean adminAccess;

	public AdminUser() {
		super();
	}

	public AdminUser(String username, String password, String firstname, String lastname, Company company,
			UserProfile profile, List<Role> roles) {
		super(username, password, firstname, lastname, company, profile, roles);
		this.adminAccess = true;
	}

	public boolean isAdminAccess() {
		return adminAccess;
	}

	public void setAdminAccess(boolean adminAccess) {
		this.adminAccess = adminAccess;
	}

	@Override
	public String toString() {
		return super.toString() +  "AdminUser [adminAccess=" + adminAccess + "]";
	}	
	

}
