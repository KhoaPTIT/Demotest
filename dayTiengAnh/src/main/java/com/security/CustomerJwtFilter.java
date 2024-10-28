package com.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.JutHelper.JutHelper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomerJwtFilter extends OncePerRequestFilter{

	@Autowired
	JutHelper jutHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		
		final String header = request.getHeader("Authorization");
		System.out.println("header " + header);
		String token = null;
		if(header != null && header.startsWith("Bearer ")) {
			token = header.substring(7);
		}
		if(jutHelper.verifyToken(token)) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("","", new ArrayList<>());
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(usernamePasswordAuthenticationToken);
		}

		filterChain.doFilter(request, response);
		
	}
	
}
