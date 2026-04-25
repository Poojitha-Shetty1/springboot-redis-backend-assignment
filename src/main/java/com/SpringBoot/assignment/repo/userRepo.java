package com.SpringBoot.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.assignment.Entity.userEntity;

public interface userRepo  extends JpaRepository<userEntity, Long>{
	

}
