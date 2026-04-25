package com.SpringBoot.assignment.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.assignment.Entity.commentsEntity;
import com.SpringBoot.assignment.Entity.notificationEntity;
import com.SpringBoot.assignment.Entity.postsEntity;
import com.SpringBoot.assignment.repo.notificationRepo;
import com.SpringBoot.assignment.repo.postsRepo;
import com.SpringBoot.assignment.service.postService;

@RestController
@RequestMapping("/api")

public class postController {

	@Autowired
	private postService postservice;
	
	@Autowired
	private StringRedisTemplate redistemplate;
	
	@Autowired
	private postsRepo postsrepo;
	
	@Autowired
	private notificationRepo notirepo;
	
	@PostMapping("/posts")
	public postsEntity createPost(@RequestParam Long userId,@RequestParam String content) {
		return postservice.createPost(userId, content);
	}
	
	
	@PostMapping("/posts/{postId}/comments")
	public commentsEntity addComment(@PathVariable Long postId ,@RequestParam Long userId ,@RequestParam String content) {
		
        return postservice.addComment(postId, userId, content);

	}
	
	  @PostMapping("/posts/{postId}/like")
	    public postsEntity likePost(@PathVariable Long postId,@RequestParam Long userId) {

	        return postservice.likePost(postId, userId);
	    }
	
	  @GetMapping("/posts/{postId}/score")
		  public String getScore(@PathVariable Long postId) {
			  String score = redistemplate.opsForValue().get("post:" +postId + ":score");
			  
			  return score!=null ?score:"0";
		  }
	  
		 
	  @GetMapping("/posts/trending")
	  public List<postsEntity> getTrendingPosts(){
		Set<String> postkeys = redistemplate.opsForZSet().reverseRange("trending", 0, 9);
		
		List<postsEntity> posts = new ArrayList<>();
		
		if(postkeys!=null) {
			for(String key : postkeys) {
				Long postId = Long.parseLong(key.split(":")[1]);
				
				postsEntity post = postsrepo.findById(postId).orElse(null);
				
				if(post!=null) {
					posts.add(post);
				}
			}
		}
		return posts;
	  }
	
	  
	  @GetMapping("/notifications/{userId}")
	  public List<notificationEntity> getNotification(@PathVariable Long userId){
		  return notirepo.findByUserIdOrderByCreatedAtDesc(userId);
		  
	  }
}
