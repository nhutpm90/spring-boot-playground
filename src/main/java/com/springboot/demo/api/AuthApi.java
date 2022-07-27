package com.springboot.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.demo.jwt.AuthService;
import com.springboot.demo.jwt.JwtWrapper;
import com.springboot.demo.jwt.LoginRequest;
import com.springboot.demo.jwt.TokenException;

@RestController
public class AuthApi {

	@Autowired
	private AuthService authService;

	@PostMapping("/auth/login")
	public JwtWrapper login(@RequestBody LoginRequest loginRequest) throws JsonProcessingException {
		return this.authService.login(loginRequest.getUsername(), loginRequest.getPassword());
	}
	
	@PostMapping("/auth/refresh-token")
	public JwtWrapper refreshtoken(@RequestBody JwtWrapper request) throws TokenException {
		return this.authService.refreshToken(request.getRefreshToken());
	}
}