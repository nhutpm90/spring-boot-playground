package com.springboot.demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.demo.testdb.TestDatabase;
import com.springboot.demo.testdb.TestDatabaseRepo;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private TestDatabaseRepo testDbRepo;
	
	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		testDbRepo.save(new TestDatabase());
	}
}
