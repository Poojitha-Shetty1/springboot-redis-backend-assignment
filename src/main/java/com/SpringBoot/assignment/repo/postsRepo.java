package com.SpringBoot.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.assignment.Entity.postsEntity;

public interface postsRepo extends JpaRepository<postsEntity , Long> {

}
