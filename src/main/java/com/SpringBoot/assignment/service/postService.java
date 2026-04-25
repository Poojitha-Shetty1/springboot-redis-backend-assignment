package com.SpringBoot.assignment.service;

import com.SpringBoot.assignment.Entity.commentsEntity;
import com.SpringBoot.assignment.Entity.postsEntity;

public interface postService {

	postsEntity createPost(Long userId , String content);
	
	commentsEntity addComment(Long postId , Long userId , String content);
	
	postsEntity likePost(Long postId, Long userId);
	
}
