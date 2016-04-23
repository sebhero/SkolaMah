/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package Playground.testingSec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ServerSecuritytestApplication implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository;


	public static void main(String[] args) {
		SpringApplication.run(ServerSecuritytestApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Account defaultUser = accountRepository.findByUsername("user");
		if (defaultUser == null) {
			System.out.println("CREATING DEFAULT USER");
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			String pass = encoder.encode("pass");
			accountRepository.save(new Account("user", pass,
					AuthorityUtils.createAuthorityList("USER")));
		}
		else {
			System.out.println("USER ALLREADY in DB");
		}

	}
}