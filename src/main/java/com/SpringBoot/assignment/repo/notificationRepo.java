package com.SpringBoot.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.assignment.Entity.notificationEntity;

public interface notificationRepo extends JpaRepository<notificationEntity, Long > {

	List<notificationEntity> findByUserIdOrderByCreatedAtDesc(Long userId);
	
}
