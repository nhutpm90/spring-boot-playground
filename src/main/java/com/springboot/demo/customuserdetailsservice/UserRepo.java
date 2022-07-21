package com.springboot.demo.customuserdetailsservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username=:username")
	User findUserWithRoles(String username);
}
