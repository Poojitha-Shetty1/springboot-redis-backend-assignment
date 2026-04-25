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
@Table(name="posts")

public class postsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	private String content;
	private LocalDateTime createdAt;
	
	private int likes = 0;
	
	@ManyToOne
	@JoinColumn(name = "author_id" )
	private userEntity author;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public userEntity getAuthor() {
		return author;
	}

	public void setAuthor(userEntity author) {
		this.author = author;
	}


	
	

}
