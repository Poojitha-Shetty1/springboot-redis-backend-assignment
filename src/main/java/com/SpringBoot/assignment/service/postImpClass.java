package com.SpringBoot.assignment.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.SpringBoot.assignment.Entity.commentsEntity;
import com.SpringBoot.assignment.Entity.notificationEntity;
import com.SpringBoot.assignment.Entity.postsEntity;
import com.SpringBoot.assignment.Entity.userEntity;
import com.SpringBoot.assignment.repo.commentsRepo;
import com.SpringBoot.assignment.repo.notificationRepo;
import com.SpringBoot.assignment.repo.postsRepo;
import com.SpringBoot.assignment.repo.userRepo;

@Service
public class postImpClass implements postService{
	
	@Autowired
	private userRepo userrepo;
	
	@Autowired
	private postsRepo postsrepo;
	
	@Autowired
	private commentsRepo commentsrepo;
	
	@Autowired
	private StringRedisTemplate redistemplate;
	
	@Autowired
	private notificationRepo notirepo; 
	

	@Override
	public postsEntity createPost(Long userId, String content) {

		userEntity user = userrepo.findById(userId).orElseThrow();
		
		postsEntity post = new postsEntity();
		post.setAuthor(user);
		post.setContent(content);
		post.setCreatedAt(LocalDateTime.now());
		
		return postsrepo.save(post);
	}

	@Override
	public commentsEntity addComment(Long postId, Long userId, String content) {
		
		userEntity user = userrepo.findById(userId).orElseThrow();
		postsEntity post = postsrepo.findById(postId).orElseThrow();
		
		commentsEntity comment = new commentsEntity();
		comment.setPost(post);
		comment.setAuthor(user);
		comment.setContent(content);
		comment.setDepthlevel(1);
		comment.setCreatedAt(LocalDateTime.now());
		
	    commentsrepo.save(comment);
		
	    String key = "post:" + postId + ":score";
	    Long score = redistemplate.opsForValue().increment(key, 50);
	    redistemplate.opsForZSet().add("trending", "post:"+postId, score);
	    
	    Long authorId = post.getAuthor().getUserId();

	    if (!userId.equals(authorId)) {
	        notificationEntity notif = new notificationEntity();
	        notif.setUserId(authorId);
	        notif.setMessage("User " + userId + " commented on your post");
	        notif.setCreatedAt(LocalDateTime.now());

	        notirepo.save(notif);
	    }
	    
	    return comment;
	}

	@Override
	public postsEntity likePost(Long postId , Long userId) {
		
		postsEntity post = postsrepo.findById(postId).orElseThrow();
		
//		post.setLikes(post.getLikes() +1);
//		return postsrepo.save(post);
		
		post.setLikes(post.getLikes() +1);
		postsrepo.save(post);
		
	    String key = "post:" + postId + ":score";
	    Long score = redistemplate.opsForValue().increment(key, 20);
	    redistemplate.opsForZSet().add("trending", "post:"+postId, score);
	    
	    Long authorId = post.getAuthor().getUserId();

	    if (!userId.equals(authorId)) {
	        notificationEntity notif = new notificationEntity();
	        notif.setUserId(authorId);
	        notif.setMessage("User " + userId + " liked your post");
	        notif.setCreatedAt(LocalDateTime.now());

	        notirepo.save(notif);
	    }
	    
	    return post;
		
	}
	
	

}
