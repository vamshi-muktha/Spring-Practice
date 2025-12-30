package com.tcs.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.springsecurity.bean.User;

public interface UserRepo extends JpaRepository<User, String> {

	User findByUsername(String username);

}
 