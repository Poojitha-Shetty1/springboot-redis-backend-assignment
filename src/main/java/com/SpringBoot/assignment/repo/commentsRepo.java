package com.SpringBoot.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.assignment.Entity.commentsEntity;

public interface commentsRepo extends JpaRepository<commentsEntity, Long> {
	
	

}
