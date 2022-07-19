package com.springboot.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import com.springboot.demo.testdb.TestDatabaseRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.springboot.demo.bootstrap",
							"com.springboot.demo.testdb"})
class DbConnetionTests {

	@Autowired
	TestDatabaseRepo testDbRepo;
	
	@Test
	void contextLoads() {
	}

	
	@Test
	void _01() {
		this.testDbRepo.findAll().forEach(System.out::println);
	}
	
	@Test
	void _02() {
	}
}
