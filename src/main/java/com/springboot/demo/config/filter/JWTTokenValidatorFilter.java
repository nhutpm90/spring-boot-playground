package com.springboot.demo.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {
	
	private final Logger logger = LoggerFactory.getLogger(JWTTokenValidatorFilter.class);
	
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String jwt = null;
		logger.info("--------------JWTTokenValidatorFilter--------------doFilterInternal::BEGIN token:: " + jwt);
		logger.info("--------------JWTTokenValidatorFilter--------------doFilterInternal::END");
		chain.doFilter(request, response);
	}
}