package io.filipegabriel.blog_system.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.filipegabriel.blog_system.entities.Post;
import io.filipegabriel.blog_system.entities.User;
import io.filipegabriel.blog_system.repositories.PostRepository;
import io.filipegabriel.blog_system.repositories.UserRepository;
import io.filipegabriel.blog_system.resources.dto.PostDTO;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Post insert(PostDTO postDTO) {
		User user = userRepository.findById(postDTO.getOwnerPostId()).orElseThrow(NoSuchElementException::new);
		Post newPost = new Post();
		
		newPost.setAuthor(user.getUsername());
		newPost.setMessage(postDTO.getMessage());
		newPost.setImage(postDTO.getImage());
		newPost.setOwnerPost(user);
		return postRepository.save(newPost);
	}
	
	public Post findById(Long id) {
		return postRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	public List<Post> findAll(){
		List<Post> posts = postRepository.findAll();
		return posts;
	}
	
	public void delete(Long id) {
		postRepository.deleteById(id);
	}
	
	public Post update(Long id, PostDTO newPost) {
		Post oldPost = postRepository.findById(id).orElseThrow(NoSuchElementException::new);
		updatePost(oldPost, newPost);
		return postRepository.save(oldPost);
	}
	
	public void updatePost(Post oldPost, PostDTO newPost) {
		oldPost.setMessage(newPost.getMessage());
	}
	
}
