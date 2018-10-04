package com.fdmgroup.app;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.dao.CompanyDao;
import com.fdmgroup.dao.DbConnection;
import com.fdmgroup.dao.RoleDao;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.AdminUser;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.CompanyType;
import com.fdmgroup.model.Developer;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.Stock;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserProfile;

public class JpaApp1 {
	public static void main(String[] args) {
			
		UserDao userDao = new UserDao();
		CompanyDao companyDao = new CompanyDao();
		RoleDao roleDao = new RoleDao();
		
		Stock s1 = new Stock("GGL", 850.56);
		Stock s2 = new Stock("MS", 414.99);
		Stock s3 = new Stock("APPLE", 1500.01);
		
		Company c1 = new Company("Google", 15000, "Mountain View, CA", LocalDateTime.of(1998,  10, 1, 0, 0, 0), s1, CompanyType.CORPORATION);
		Company c2 = new Company("Microsoft", 20000, "Redmond, WA", LocalDateTime.of(1980,10,15,0,0,0), s2, CompanyType.JOINT_VENTURE);
		Company c3 = new Company("Apple", 25000, "Palo Alto, CA", LocalDateTime.of(1994,07,16,0,0,0), s3, CompanyType.SP);

		companyDao.create(c1);
		companyDao.create(c2);
		companyDao.create(c3);
		
		Role r1 = new Role("Admin");
		Role r2 = new Role("Employee");
		Role r3 = new Role("Developer");
	
		roleDao.create(r1);
		roleDao.create(r2);
		roleDao.create(r3);
		
		List<Role> roles1 = new ArrayList<>();
		List<Role> roles2 = new ArrayList<>();
		List<Role> roles3 = new ArrayList<>();
		
		roles1.add(roleDao.findByRoleName("Admin"));
		roles1.add(roleDao.findByRoleName("Developer"));
		
		roles2.add(roleDao.findByRoleName("Employee"));
		roles2.add(roleDao.findByRoleName("Developer"));
		roles2.add(roleDao.findByRoleName("Admin"));
		
		roles3.add(roleDao.findByRoleName("Admin"));
		
		User u1 = new User("jdoe", "54321", "John", "Doe", c1, new UserProfile(27,"North York, ON"), roles1);
		User u2 = new User("mjane", "1234", "Mary", "Jane", c2, new UserProfile(25,"Downtown, Toronto"), roles2);
		User u3 = new User("asmith", "abcd", "Achal", "Smith", c3, new UserProfile(22,"Scarborough, ON"), roles3);

		userDao.create(u1);
		userDao.create(u2);
		userDao.create(u3);
		System.out.println("Data inserted successfully.....");
		
		/*if (userDao.delete(11)){
			System.out.println("User with userid 11 deleted successfully....");
		}*/

		/*if (userDao.softDelete(12)){
			System.out.println("User with userid 12 soft-deleted successfully....");
		}*/
		
		AdminUser u4 = new AdminUser("ljames", "00000", "Lebron", "James",c3, new UserProfile(27,"North York, ON"), roles1);
		userDao.create(u4);
		
		Developer u5 = new Developer("snash", "00000", "steve", "nash",c2, new UserProfile(27,"North York, ON"), roles1);
		userDao.create(u5);
		
		
		Developer u6 = new Developer("scurry", "00000", "stephen", "curry",c1, new UserProfile(27,"North York, ON"), roles2);
		userDao.create(u6);
		
		
		/*List<User> users = userDao.findByType(AdminUser.class);
		users.stream().forEach(System.out::println);*/
		DbConnection.getInstance().close();
		
	}

}
