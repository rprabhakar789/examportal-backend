package com.backend.examPortal.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "userrole")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userRole;
	
	@ManyToOne(fetch=FetchType.EAGER)
	User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
