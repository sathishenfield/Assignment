package com.te.userflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.userflow.entity.CustomUserDetails;
import com.te.userflow.entity.User;
import com.te.userflow.exception.InvalidCredentialException;
import com.te.userflow.repository.UserDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByName(username);

		return new CustomUserDetails(user);

	}

}
