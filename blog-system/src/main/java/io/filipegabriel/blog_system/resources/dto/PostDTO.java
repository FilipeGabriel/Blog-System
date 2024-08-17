package io.filipegabriel.blog_system.resources.dto;

import lombok.Data;

@Data
public class PostDTO {
	
	private Long id;
	
	private String author;
	
	private String message;
	
	private String image;
	
	private String postDate;
	
	private Long ownerPostId;

}
