package com.example.demo.securing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests) -> requests
					.antMatchers("/", "/home").permitAll()
					.antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER") // ROLE_ 은생략가능, ROLE_ADMIN, ROLE_ADMIN 형식으로 추가 가능
					.anyRequest().authenticated())
				.formLogin((form) -> form
					.loginPage("/login")
					//.usernameParameter("userid") login.html input의 name이랑 같아야함
					.permitAll())
					.logout((logout) -> logout.permitAll());
					//.UserDetailsService(null);

		return http.build();
	}

	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
