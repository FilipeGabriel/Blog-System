package io.filipegabriel.blog_system.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.filipegabriel.blog_system.entities.User;
import io.filipegabriel.blog_system.repositories.UserRepository;
import io.filipegabriel.blog_system.resources.dto.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void insert(UserDTO userDTO) {
		LocalDate date = LocalDate.parse(userDTO.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		User newUser = new User();
		
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(userDTO.getPassword());
		newUser.setBirthDate(date);
		userRepository.save(newUser);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	public List<User> findAll(){
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, UserDTO newUser) {
		User oldUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
		updateUser(oldUser, newUser);
		return userRepository.save(oldUser);
	}
	
	public void updateUser(User oldUser, UserDTO newUser) {
		oldUser.setPassword(newUser.getPassword());
	}

}
