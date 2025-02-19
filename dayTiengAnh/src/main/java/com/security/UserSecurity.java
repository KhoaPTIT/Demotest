package com.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class UserSecurity {
	@SuppressWarnings("removal")
	
//	  @Bean
//	    public InMemoryUserDetailsManager userDetailsService() {
//	        UserDetails user1 = User.withUsername("user1")
//	            .password(passwordEncoder().encode("user1Pass"))
//	            .roles("USER")
//	            .build();
//	        UserDetails user2 = User.withUsername("user2")
//	            .password(passwordEncoder().encode("user2Pass"))
//	            .roles("USER")
//	            .build();
//	        UserDetails admin = User.withUsername("admin")
//	            .password(passwordEncoder().encode("adminPass"))
//	            .roles("ADMIN")
//	            .build();
//	        return new InMemoryUserDetailsManager(user1, user2, admin);
//	    }
	
	@Autowired
	CustomerJwtFilter customerJwtFilter;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
		// http builder configurations for authorize requests and form login (see below)
		http.csrf(csrf -> csrf.disable())
//			.cors(cors -> cors.disable())
			.cors(Customizer.withDefaults())
	        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/login/**").permitAll()
	                .anyRequest().authenticated()
	            )
	        .httpBasic(Customizer.withDefaults());
		
		http.addFilterBefore(customerJwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Autowired
	CustomDetailService customDetailService;
	@Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(customDetailService).passwordEncoder(passwordEncoder());
		
		return authenticationManagerBuilder.build();
    }
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	
}
