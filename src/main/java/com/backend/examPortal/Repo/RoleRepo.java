package com.backend.examPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.examPortal.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Integer>{

}
