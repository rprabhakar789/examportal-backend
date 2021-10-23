package com.backend.examPortal.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.examPortal.Repo.RoleRepo;
import com.backend.examPortal.Repo.UserRepo;
import com.backend.examPortal.entity.User;
import com.backend.examPortal.entity.UserRole;

@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		
		 
		User local = userRepo.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User already there");
			throw new Exception("username is taken");
			
		}
		else {
			for(UserRole ur:userRoles)
			{
				roleRepo.save(ur.getRole());
			}
			//user.getUserRoles().addAll(userRoles);
			local = userRepo.save(user);
		}
		return local;
	}
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		System.out.println("finding user by username "+username);
		return userRepo.findByUsername(username);
	}
	
	
}
