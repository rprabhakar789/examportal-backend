package com.backend.examPortal.service;

import java.util.Set;

import com.backend.examPortal.entity.User;
import com.backend.examPortal.entity.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole>userRoles) throws Exception;

	public User getUserByUsername(String username);
}
