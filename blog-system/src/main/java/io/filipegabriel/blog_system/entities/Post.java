package io.filipegabriel.blog_system.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_post")
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String author;
	
	@Column(nullable = false)
	private String message;
	
	private String image;
	
	private Instant postDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_owner", nullable = false)
	private User ownerPost;
	
	@PrePersist
	public void registerDate() {
		setPostDate(Instant.now());
	}

}
