package com.backend.examPortal.restController;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.examPortal.entity.Role;
import com.backend.examPortal.entity.User;
import com.backend.examPortal.entity.UserRole;
import com.backend.examPortal.service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

	
	UserService userService;
	
	@Autowired
	public UserController(UserService us)
	{
		this.userService  = us;
	}
	
	@RequestMapping("/register")
	public User registerAsUser(@RequestBody User newUser) throws Exception
	{
		/*
		User user = new User();
		user.setUsername(newUser);
		user.setFirst_name("ram");
		user.setLast_name("kapoor");
		user.setEmail("ram@email");
		user.setPassword("password");
		user.setProfile("default.png");
		*/
		if(newUser.getFirst_name()=="")
		{
			throw new Exception("First name cannot be empty!");
		}
		Role role = new Role();
		role.setRoleId(1);
		role.setRolename("USER");
		Set<UserRole>userRoles=new HashSet<UserRole>();
		
		UserRole ur = new UserRole();
		ur.setRole(role);
		userRoles.add(ur);
		
		return userService.createUser(newUser, userRoles);
	}
	@RequestMapping("/login")
	public User login(@PathVariable String username, @PathVariable String password) throws Exception
	{
		User user = userService.getUserByUsername(username);
		if(user.getPassword()==password)
			return user;
		else throw new Exception("invalid password");
	}
	
	@GetMapping("/{username}")
	public User getUserByUsername(@PathVariable String username) throws Exception
	{
		System.out.println("controlling request to get user by username "+username);
		return userService.getUserByUsername(username);
	}
	
}
