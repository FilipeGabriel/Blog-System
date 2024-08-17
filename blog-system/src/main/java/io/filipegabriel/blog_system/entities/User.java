package io.filipegabriel.blog_system.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	
	private Instant registerDate;
	
	@OneToMany(mappedBy = "ownerPost")
	private List<Post> posts = new ArrayList<>();
	
	@PrePersist
	public void registerDate() {
		setRegisterDate(Instant.now());
	}
	
}
