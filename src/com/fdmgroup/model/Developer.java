package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Developer")
public class Developer extends User{
	
	public Developer() {
		super();
	}

	public Developer(String username, String password, String firstname, String lastname, Company company,
			UserProfile profile, List<Role> roles) {
		super(username, password, firstname, lastname, company, profile, roles);
	}
}

