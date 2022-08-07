/**
 * This class is for security configuration to handle the request , 
 * this can further used to handle Authorizing requests
 * 
 * Created by  Satya Moganti
 */
package com.cs.springbootcsapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity.headers().frameOptions().disable();
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/*").permitAll();

	}
	
}
