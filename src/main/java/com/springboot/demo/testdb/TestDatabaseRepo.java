package com.springboot.demo.testdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDatabaseRepo extends JpaRepository<TestDatabase, Long> {

}
