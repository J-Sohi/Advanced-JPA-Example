package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
	
	private static final String PERSISTENCE_UNIT = "AdvancedJPAExample";
	private static DbConnection con = null;
	private EntityManagerFactory emf = null;

	
	private DbConnection(){
		init();
	}
	
	private void init(){
		if (emf ==  null || !emf.isOpen()){
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
	}
	
	public static DbConnection getInstance(){
		if (con == null){
			con = new DbConnection();
		}

		return con;
	}
	
	public EntityManager getEntityManager(){
		init();
		return emf.createEntityManager();
	}
	
	public void close(){
		if (emf != null && emf.isOpen()){
			emf.close();
		}
	}
}
