package com.springboot.demo.jwt;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class JwtWrapper {

	@JsonInclude(Include.NON_NULL)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	private String token;
	
	@JsonInclude(Include.NON_NULL)
	private String refreshToken;
	
	@JsonInclude(Include.NON_NULL)
	private Set<String> roles;

	public JwtWrapper() {
	}

	public JwtWrapper(String email, String token, String refreshToken, Set<String> roles) {
		this.email = email;
		this.token = token;
		this.refreshToken = refreshToken;
		this.roles = roles;
	}

	public JwtWrapper(String token, String refreshToken) {
		this.token = token;
		this.refreshToken = refreshToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}