package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Company;
import com.fdmgroup.model.CompanyType;
import com.fdmgroup.model.User;

public class CompanyDao {

	private DbConnection con;
	private EntityManager em;
	
	public CompanyDao(){
		super();
		con = DbConnection.getInstance();
	}

	public boolean create(Company company){
		em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(company);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public void delete(int id){
		em = con.getEntityManager();
		Company managedCompany = em.find(Company.class, id);
		em.getTransaction().begin();
		em.remove(managedCompany);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Company> findByCompanyType(CompanyType type){
		em = con.getEntityManager();
		TypedQuery<Company> query = em.createNamedQuery("company.findByCompanyType", Company.class);
		query.setParameter("ctype", type);
		
		List<Company> companies = query.getResultList();
		em.close();
		return companies;
	}
}
