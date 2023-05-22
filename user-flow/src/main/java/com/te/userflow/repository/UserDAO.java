package com.te.userflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.userflow.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	 public User findByName(String name);

}
