package com.apigateway.APIGateway.security;




//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity(debug = false)
//
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		
//		http
//				.csrf().disable()
//				//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//				
//				.authorizeRequests()
////				.antMatchers("/public/**").hasRole("client")//permitAll()
////				.antMatchers("/users").hasRole("admin")
//				.anyRequest()
//				.authenticated()
//				.and()
//				//.formLogin();
//				.httpBasic();
//		
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().withUser("divakar").password(this.passswordEncoder().encode("verma")).roles("admin");
//		auth.inMemoryAuthentication().withUser("ramesh").password(this.passswordEncoder().encode("ramesh12")).roles("client");
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passswordEncoder() {
//		
//		return new BCryptPasswordEncoder(10);
//	}
//	
//	
//
//}
