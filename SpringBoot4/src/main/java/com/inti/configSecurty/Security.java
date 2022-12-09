package com.inti.configSecurty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService; 
@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService); 
	}
@Override
public void configure(HttpSecurity http) throws Exception
{
	http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
	.anyRequest().authenticated()
	.and().httpBasic(); 
}
@Bean
public BCryptPasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder();
}

}
