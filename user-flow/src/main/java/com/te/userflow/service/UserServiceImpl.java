package com.te.userflow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.userflow.dto.UserDTO;
import com.te.userflow.entity.User;
import com.te.userflow.exception.NameAlreadyExistException;
import com.te.userflow.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDTO registerUser(UserDTO userDTO) {

		User user = dtoToEntityConverter(userDTO);
		user.setRoles("ROLE_USER");
		user.setPassword(encoder.encode(userDTO.getPassword()));
		User findByName = userDAO.findByName(user.getName());
		if (findByName == null) {

			User save = userDAO.save(user);
			return userDTO;
		} else {
			throw new NameAlreadyExistException("Name Already Exist");
		}

	}

	public User dtoToEntityConverter(UserDTO userDTO) {
		User user = mapper.map(userDTO, User.class);

		return user;
	}

	
}
