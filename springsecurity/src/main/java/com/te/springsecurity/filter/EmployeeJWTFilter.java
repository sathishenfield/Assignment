package com.te.springsecurity.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.te.springsecurity.jwtutil.EmployeeJWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class EmployeeJWTFilter extends OncePerRequestFilter{
	@Autowired
	private EmployeeJWTUtil employeeJWTUtil;
	
	@Autowired
	private UserDetailsService detailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("inside filter1");
		String jwt=null;
		String extractUserName=null;
		String header=request.getHeader("Authorization");
		System.out.println("inside filter2");
		if (header!=null&&header.startsWith("Bearer ")) {
			System.out.println("inside filter4");
			jwt=header.substring(7);
			
			extractUserName=employeeJWTUtil.extractUsername(jwt);
			
		}
		System.out.println("inside filter3");
		if (extractUserName!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = detailsService.loadUserByUsername(extractUserName);
			System.out.println("inside filter");
			if (employeeJWTUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authenticationToken=new 
						UsernamePasswordAuthenticationToken(null, userDetails,userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		System.out.println("inside filter5");
		filterChain.doFilter(request, response);
	}

	
	

}
