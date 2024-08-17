package io.filipegabriel.blog_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.filipegabriel.blog_system.entities.Post;
import io.filipegabriel.blog_system.resources.dto.PostDTO;
import io.filipegabriel.blog_system.services.PostService;

@RestController
@RequestMapping(value = "/v1/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Post> insert(@RequestBody PostDTO post){
		Post newpost = postService.insert(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(newpost);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable Long id){
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> posts = postService.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		postService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody PostDTO newPost){
		Post post = postService.update(id, newPost);
		return ResponseEntity.ok().body(post);
	}

}
