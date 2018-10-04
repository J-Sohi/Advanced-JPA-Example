package com.fdmgroup.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.AdminUser;
import com.fdmgroup.model.Developer;
import com.fdmgroup.model.User;

public class UserDao {
	
	private DbConnection con;
	private EntityManager em;
	
	public UserDao(){
		super();
		con = DbConnection.getInstance();
	}

	public boolean create(User user){
		System.out.println(user);
		em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public boolean delete(int id){
		em = con.getEntityManager();
		User managedUser = em.find(User.class, id);
		em.getTransaction().begin();
		em.remove(managedUser);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean softDelete(int id){
		em = con.getEntityManager();
		User managedUser = em.find(User.class, id);
		em.getTransaction().begin();
		managedUser.setActive(false);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public List<User> findAll(){
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);	
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	public List<User> findByFirstName(String fname) {
		em = con.getEntityManager();
		System.out.println("FNAME========" + fname );
		TypedQuery<User> query = em.createNamedQuery("user.findByFirstname", User.class);
		query.setParameter("fname", fname + "%");
		List<User> users = query.getResultList();
		em.close();
		
		return users;
	}
	
	public User findById(int id){
		em = con.getEntityManager();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}

	public List<User> findByUsername(String username) {
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("uname", username);
		User user = query.getSingleResult();
		List<User> users = query.getResultList();
		em.close();
		
		if (users != null && users.size() == 1){
			return users;
		}
		return null;
	}
	
	public List<User> findByType(Class type){
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByType", User.class);
		query.setParameter("type", type);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}
	
	public List<AdminUser> findAllAdmins(){
		em = con.getEntityManager();
		TypedQuery<AdminUser> query = em.createNamedQuery("user.findAllAdmins", AdminUser.class);
		query.setParameter("AdminUser", AdminUser.class);
		List<AdminUser> users = query.getResultList();
		em.close();
		return users;
	}

	public List<Developer> findAllDevelopers() {
		em = con.getEntityManager();
		TypedQuery<Developer> query = em.createNamedQuery("user.findAllDevelopers", Developer.class);
		query.setParameter("developer", Developer.class);
		List<Developer> users = query.getResultList();
		em.close();
		return users;
	}
}
