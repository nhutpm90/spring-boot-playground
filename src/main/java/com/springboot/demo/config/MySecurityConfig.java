package com.springboot.demo.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.springboot.demo.config.filter.AuthoritiesLoggingAfterFilter;
import com.springboot.demo.config.filter.JWTTokenValidatorFilter;
import com.springboot.demo.config.keycloak.KeycloakRoleConverter;


@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors().configurationSource(new CorsConfigurationSource() {
				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					CorsConfiguration config = new CorsConfiguration();
	//				config.setAllowedOrigins(Collections.singletonList("http://172.16.2.29:3000"));
					config.addAllowedOriginPattern(CorsConfiguration.ALL);
					config.setAllowedMethods(Collections.singletonList("*"));
					config.setAllowCredentials(true);
					config.setAllowedHeaders(Collections.singletonList("*"));
					config.setMaxAge(3600L);
					return config;
				}
			})
			.and().csrf().disable()//			.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
//			.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers("/test-db").permitAll()
			.antMatchers("/public").permitAll()
			.antMatchers("/home").authenticated()
			.antMatchers("/operation").hasRole("OPERATION")
			.antMatchers("/manager").hasRole("MANAGER")
			.antMatchers("/admin").hasRole("ADMIN")
			.mvcMatchers("/about").permitAll()
			.and()
			.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter)
//			.and().formLogin()
//			.and().httpBasic() // allow for authentication using http header
			;
	}
	
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
    
//	@Bean
//	PasswordEncoder passwordEncoder() {
////		return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder(10);
//	}
	
//	@Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/h2-console/**");
//    }
}
