package fr.but3.ctp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class Security
{
	@Bean
	public SecurityFilterChain mesautorisations(HttpSecurity http,
			HandlerMappingIntrospector introspector)
			throws Exception
	{
		// MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
		return http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/activer", "/voir")
				.hasRole("ADMIN")
				.requestMatchers("/voter")
				.hasRole("USER")
				.anyRequest().permitAll()
				)
				.csrf(csrf -> csrf.disable())
				.formLogin(Customizer.withDefaults())
				.build();
	}


	@Bean
	public UserDetailsService mesutilisateurs()
	{
		UserDetails admin = User.withUsername("admin")
				.password(encoder().encode("admin"))
				.roles("ADMIN")
				.build();
		UserDetails user1 = User.withUsername("user")
				.password(encoder().encode("password"))
				.roles("USER")
				.build();

		UserDetails user2 = User.withUsername("user2")
				.password(encoder().encode("user2"))
				.roles("USER")
				.build();

		UserDetails user3 = User.withUsername("user3")
				.password(encoder().encode("user3"))
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, user1, user2, user3);
	}

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
}