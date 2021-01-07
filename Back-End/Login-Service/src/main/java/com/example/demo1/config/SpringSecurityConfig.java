package com.example.demo1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

@Configuration


public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	DataSource dataSource;
	
	//Fetching and authenticating user supplied credentials with the ones present in the database
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	//security configuration
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic().and().rememberMe()
        .rememberMeCookieName("javasampleapproach-remember-me")
        .tokenValiditySeconds(24 * 60 * 60) // expired time = 1 day
        .tokenRepository(persistentTokenRepository());

	}
	
	@Bean
	  public PersistentTokenRepository persistentTokenRepository() {
	        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
	        tokenRepository.setDataSource((javax.sql.DataSource) dataSource);
	        return tokenRepository;
	    }
	
	//For encoding the password
@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
