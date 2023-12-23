package fr.but3.tp9.controllers;

import java.security.Principal;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControlleur {
	private final UserDetailsManager userDetailsManager;
	private final PasswordEncoder encoder;

	public RestControlleur(UserDetailsManager userDetailsManager, PasswordEncoder encoder) {
		this.userDetailsManager = userDetailsManager;
		this.encoder = encoder;
	}

	@GetMapping(path = "/principal")
	public Principal principal(Principal principal) {
		return principal;
	}

	@PostMapping("/creer")
	public void creer(@RequestParam String login, @RequestParam String password) {
		userDetailsManager
				.createUser(User.withUsername(login).password(encoder.encode(password)).roles("USER").build());
	}
}
