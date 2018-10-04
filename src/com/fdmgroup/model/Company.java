package com.fdmgroup.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="JPA_COMPANY")
@SecondaryTable(name="JPA_COMPANY_PROFILE", pkJoinColumns = @PrimaryKeyJoinColumn)
@NamedQueries({
	@NamedQuery(name="company.findByCompanyType", query = "SELECT c From Company c WHERE c.type = :ctype")
})
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="company_id")
	private int id;
	
	private String name;
	
	@Column(table="JPA_COMPANY_PROFILE")
	private int numOfEmployees;
	
	@Column(table="JPA_COMPANY_PROFILE")
	private String address;

	@Column(table="JPA_COMPANY_PROFILE")
	private LocalDateTime established;
	
	@OneToMany(mappedBy = "company")
	private List<User> users;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Stock stock;
	
	@Column(name = "company_type")
	@Enumerated(EnumType.STRING)
	private CompanyType type;	

	public Company() {
		super();
	}
	
	public Company(String name, int numOfEmployees, String address, LocalDateTime established, Stock stock, CompanyType type) {
		super();
		this.name = name;
		this.numOfEmployees = numOfEmployees;
		this.address = address;
		this.established = established;
		this.stock = stock;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getEstablished() {
		return established;
	}

	public void setEstablished(LocalDateTime established) {
		this.established = established;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", numOfEmployees=" + numOfEmployees + ", address=" + address
				+ ", established=" + established + ", stock=" + stock + ", type=" + type + "]";
	}

	
	
	
	
}
