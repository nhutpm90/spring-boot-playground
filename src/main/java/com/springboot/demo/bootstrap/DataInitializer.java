package com.springboot.demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springboot.demo.jdbcuserdetailsmanager.test.Authorities;
import com.springboot.demo.jdbcuserdetailsmanager.test.AuthoritiesRepo;
import com.springboot.demo.jdbcuserdetailsmanager.test.Users;
import com.springboot.demo.jdbcuserdetailsmanager.test.UsersRepo;
import com.springboot.demo.testdb.TestDatabase;
import com.springboot.demo.testdb.TestDatabaseRepo;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private TestDatabaseRepo testDbRepo;
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private AuthoritiesRepo authoritiesRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		testDbRepo.save(new TestDatabase());
		this.initJdbcUserDetailsManager();
	}
	
	private void initJdbcUserDetailsManager() {
		String password = passwordEncoder.encode("123456");
		Users dev = new Users("dev", password, 1);
		this.usersRepo.save(dev);
		
		Users admin = new Users("admin", password, 1);
		this.usersRepo.save(admin);
		
		this.authoritiesRepo.save(new Authorities(dev.getUsername(), "ROLE_USER"));
		
		this.authoritiesRepo.save(new Authorities(admin.getUsername(), "ROLE_USER"));
		this.authoritiesRepo.save(new Authorities(admin.getUsername(), "ROLE_ADMIN"));
	}
}
