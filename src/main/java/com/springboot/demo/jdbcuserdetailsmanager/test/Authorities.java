package com.springboot.demo.jdbcuserdetailsmanager.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authorities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String username;
	private String authority;

	public Authorities() {
	}

	public Authorities(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
