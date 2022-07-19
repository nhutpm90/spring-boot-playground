package com.springboot.demo.testdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestDbApi {
	
	@Autowired
	private TestDatabaseRepo testDbRepo;
	
	@GetMapping("/test-db")
	public List<TestDatabase> testDb() {
		log.info("+ calling /test-db");
		return testDbRepo.findAll();
	}
}