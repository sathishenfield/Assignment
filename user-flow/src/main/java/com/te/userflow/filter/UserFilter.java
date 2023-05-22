package com.te.userflow.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.te.userflow.jwtutil.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("inside filter1");
		String jwt = null;
		String extractUserName = null;
		String header = request.getHeader("Authorization");
		System.out.println("inside filter2");

		if (header != null && header.startsWith("Bearer ")) {
			System.out.println("inside filter4");
			jwt = header.substring(7);

			extractUserName = jwtUtil.extractUsername(jwt);

		}
		System.out.println("inside filter3");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (extractUserName != null && authentication == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(extractUserName);
			System.out.println("inside filter");
			if (jwtUtil.validateToken(jwt, userDetails)) {
				System.out.println("inside filter 6");
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(null,
						userDetails, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				System.out.println("inside filter 7");
				System.out.println(authentication);

			}
		}

		System.out.println("inside filter5");
		filterChain.doFilter(request, response);
		System.out.println(authentication);
		System.out.println("exit");

	}

}
