package fr.but3.tp9.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class Security {
	private final DataSource dataSource;

	public Security(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public SecurityFilterChain mesautorisations(HttpSecurity http, HandlerMappingIntrospector introspector)
			throws Exception {
		// MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
		return http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/private").authenticated()
				.requestMatchers("/h2-console/**").permitAll()
				.anyRequest().permitAll())
				// .httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.logout(logoutCustomizer -> logoutCustomizer.logoutSuccessUrl("/public"))
				.rememberMe(Customizer.withDefaults())
				.csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
				.build();
	}

	// @Bean
	// public UserDetailsService mesutilisateurs() {
	// // UserDetails user1 = User.withUsername("otheruser")
	// // .password("$2a$12$I1nYVDDWB5.hRUB.QHtp5eMGe6kTqceUK28nBNWyDIQ2VFxwPIiRa")
	// // .roles("ADMIN")
	// // .build();
	// // return new InMemoryUserDetailsManager(user1);
	// return new JdbcUserDetailsManager(dataSource);
	// }

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
