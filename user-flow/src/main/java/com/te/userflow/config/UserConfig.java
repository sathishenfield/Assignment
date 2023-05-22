package com.te.userflow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.userflow.filter.UserFilter;

@Configuration
@EnableWebSecurity
public class UserConfig {

	@Autowired
	private UserFilter filter;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {

		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		    System.out.println("inside config");
	
			httpSecurity.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/getDoctor")
			.hasAnyRole("USER","DOCTOR")
			.requestMatchers("/getAllDoctor")
			.hasAnyRole("USER","DOCTOR")
			.requestMatchers("/doctorWithApp")
			.hasAnyRole("USER","DOCTOR")
			.requestMatchers("/bookAppointment")
			.hasAnyRole("USER","DOCTOR")
			.requestMatchers("/login")
			.permitAll()
			.requestMatchers("/adduser")
			.permitAll()
			.anyRequest()
			.authenticated()
//			.and()
//			.exceptionHandling()
//			.accessDeniedHandler(accessDeniedHandler)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
			return httpSecurity.build();
	}

}
