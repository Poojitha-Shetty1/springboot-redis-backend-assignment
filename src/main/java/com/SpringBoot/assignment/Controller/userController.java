package com.SpringBoot.assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.assignment.Entity.userEntity;
import com.SpringBoot.assignment.repo.userRepo;

@RestController
@RequestMapping("/api/users")

public class userController {
	
	@Autowired
	private userRepo userrepo;
	
	@PostMapping
	public userEntity createUser(@RequestBody userEntity user) {
		return userrepo.save(user);
	}

}
