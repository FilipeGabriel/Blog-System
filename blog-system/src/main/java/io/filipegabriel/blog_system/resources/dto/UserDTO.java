package io.filipegabriel.blog_system.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDTO {
	
	private Long id;
	
	private String username;
	
	private String password;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String birthDate;
	
}
