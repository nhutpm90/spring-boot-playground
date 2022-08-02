package com.springboot.demo.api;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyCloakApi {

	@GetMapping("/key-cloak/callback")
	public Map<String, String> login(@RequestParam Map<String,String> requestParams) {
		return requestParams;
	}
	
	@GetMapping("/key-cloak/token")
	public Jwt getToken(@AuthenticationPrincipal Jwt jwt) {
		return jwt;
	}	

}
