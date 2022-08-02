//package com.springboot.demo.bootstrap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.springboot.demo.customuserdetailsservice.Role;
//import com.springboot.demo.customuserdetailsservice.User;
//import com.springboot.demo.customuserdetailsservice.UserRepo;
//import com.springboot.demo.testdb.TestDatabase;
//import com.springboot.demo.testdb.TestDatabaseRepo;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//	@Autowired
//	private TestDatabaseRepo testDbRepo;
//	
//	@Autowired
//	private UserRepo userRepo;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	public DataInitializer() {
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		testDbRepo.save(new TestDatabase());
//		this.initCustomUserDetailsService();
//	}
//	
//	private void initCustomUserDetailsService() {
//		String password = passwordEncoder.encode("123456");
//		User dev = new User("user", password);
//		dev.addRole(new Role("ROLE_USER"));
//		this.userRepo.save(dev);
//
//		User admin = new User("admin", password);
//		admin.addRole(new Role("ROLE_ADMIN"));
//		admin.addRole(new Role("ROLE_OPERATION"));
//		this.userRepo.save(admin);
//	}
//	
//}
