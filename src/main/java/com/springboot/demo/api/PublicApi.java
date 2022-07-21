package com.springboot.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PublicApi {
	
	@GetMapping("/public")
	public String home() {
		log.info("+ calling /public");
		return "public";
	}
}