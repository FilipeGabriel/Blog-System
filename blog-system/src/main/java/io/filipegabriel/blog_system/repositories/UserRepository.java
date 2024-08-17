package io.filipegabriel.blog_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.filipegabriel.blog_system.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
