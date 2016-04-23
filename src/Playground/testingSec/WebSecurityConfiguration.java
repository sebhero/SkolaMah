/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package Playground.testingSec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Sebastian Börebäck on 2016-04-22.
 */
@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	MongoUserDetailsService mongoUserDetailsService;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		auth.userDetailsService(mongoUserDetailsService).passwordEncoder(encoder);
	}

}