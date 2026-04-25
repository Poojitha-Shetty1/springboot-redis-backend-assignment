package com.SpringBoot.assignment.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")

public class commentsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	private int depthlevel;
	private LocalDateTime createdAt;
	
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private postsEntity post;
	
	@ManyToOne
	@JoinColumn(name= "author_id")
	private userEntity author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDepthlevel() {
		return depthlevel;
	}

	public void setDepthlevel(int depthlevel) {
		this.depthlevel = depthlevel;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public postsEntity getPost() {
		return post;
	}

	public void setPost(postsEntity post) {
		this.post = post;
	}

	public userEntity getAuthor() {
		return author;
	}

	public void setAuthor(userEntity author) {
		this.author = author;
	}
	

}
