package com.backend.examPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.examPortal.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	
	public User findByUsername(String username);

}
