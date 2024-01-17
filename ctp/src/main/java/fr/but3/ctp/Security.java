package fr.but3.ctp;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class Security
{
	private final DataSource dataSource;

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
				.anyRequest()
				.permitAll())
				.csrf(csrf -> csrf.disable())
				.formLogin(Customizer.withDefaults())
				.build();
	}

	@Bean
	public UserDetailsManager userDetailsManager()
	{
		var userManager = new JdbcUserDetailsManager(dataSource);

		return userManager;
	}

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
}
