package io.filipegabriel.blog_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.filipegabriel.blog_system.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
