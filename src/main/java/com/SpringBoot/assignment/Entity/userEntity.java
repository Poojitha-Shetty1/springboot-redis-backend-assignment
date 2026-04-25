package com.SpringBoot.assignment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class userEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private boolean is_premium;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isIs_premium() {
		return is_premium;
	}
	public void setIs_premium(boolean is_premium) {
		this.is_premium = is_premium;
	}


	
	
	
	
}
