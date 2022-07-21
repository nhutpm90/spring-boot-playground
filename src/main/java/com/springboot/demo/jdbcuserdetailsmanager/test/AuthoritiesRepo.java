package com.springboot.demo.jdbcuserdetailsmanager.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepo extends JpaRepository<Authorities, Long> {

}
