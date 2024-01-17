package fr.but3.ctp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
public class CtpApplication implements ApplicationRunner
{
	@Autowired
	private UserDetailsManager userDetailsManager;
	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args)
	{
		SpringApplication.run(CtpApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		UserDetails admin = User.withUsername("admin")
				.password(encoder.encode("admin"))
				.roles("ADMIN")
				.build();
		UserDetails user1 = User.withUsername("user1")
				.password(encoder.encode("user1"))
				.roles("USER")
				.build();

		UserDetails user2 = User.withUsername("user2")
				.password(encoder.encode("user2"))
				.roles("USER")
				.build();

		UserDetails user3 = User.withUsername("user3")
				.password(encoder.encode("user3"))
				.roles("USER")
				.build();

		userDetailsManager.createUser(admin);
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(user2);
		userDetailsManager.createUser(user3);
	}
}
