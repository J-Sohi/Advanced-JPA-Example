package com.fdmgroup.app;

import java.sql.Date;

import java.util.Arrays;
import java.util.List;

import com.fdmgroup.dao.CompanyDao;
import com.fdmgroup.dao.DbConnection;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.AdminUser;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Developer;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.Stock;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserProfile;

public class JpaApp2 {

	public static void main(String[] args) {
		UserDao dao = new UserDao();

		System.out.println("==========================");
		List<AdminUser> ausers = dao.findAllAdmins();
		System.out.println("# of Admin Users...." + ausers.size());
		ausers.stream().forEach(System.out::println);
		
		System.out.println("==========================");
		List<Developer> dusers = dao.findAllDevelopers();
		dusers.stream().forEach(System.out::println);
		
		System.out.println("==========================");
		
		List<User> users = dao.findByType(User.class);
		users.stream().forEach(System.out::println);
		DbConnection.getInstance().close();
	}
}
