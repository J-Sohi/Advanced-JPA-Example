package com.fdmgroup.model;

import javax.persistence.Embeddable;

@Embeddable
public class UserProfile {

	private int age;
	private String address;
	
	public UserProfile() {
		super();
	}
	public UserProfile(int age, String address) {
		super();
		this.age = age;
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserProfile [age=" + age + ", address=" + address + "]";
	}
}
