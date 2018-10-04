package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Company;
import com.fdmgroup.model.CompanyType;
import com.fdmgroup.model.Role;

public class RoleDao {

	private DbConnection con;
	private EntityManager em;
	
	public RoleDao(){
		super();
		con = DbConnection.getInstance();
	}

	public boolean create(Role role){
		em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(role);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public void delete(int id){
		em = con.getEntityManager();
		Role managedRole = em.find(Role.class, id);
		em.getTransaction().begin();
		em.remove(managedRole);
		em.getTransaction().commit();
		em.close();
	}
	
	public Role findByRoleName(String name){
		em = con.getEntityManager();
		TypedQuery<Role> query = em.createNamedQuery("role.findByRoleName", Role.class);
		query.setParameter("rname", name);
		
		List<Role> roles = query.getResultList();
		em.close();
		
		if (roles != null && roles.size() == 1){
			return roles.get(0);
		}
		return null;
	}


}
