package com.javaspring.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javaspring.bookclub.models.LoginUser;
import com.javaspring.bookclub.models.User;
import com.javaspring.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	public User register(User newUser, BindingResult result) {
		
		if(result.hasErrors()) {
			return null;
		}
		
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Exists", "Email is already exists! ");
			return null;
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password! ");
			return null;
		}
		
		String hashPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashPassword);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		
		if(result.hasErrors()) {
			return null;
		}
		
		Optional<User> optionalUser = userRepo.findByEmail(loginUser.getEmail());
		
		if(optionalUser.isEmpty()) {
			result.rejectValue("email", "Not Found", "Email is not found! ");
			return null;
		}
		
		User checkUser = optionalUser.get();
		
		if(!BCrypt.checkpw(loginUser.getPassword(), checkUser.getPassword())) {
			result.rejectValue("password", "Invalid", "Invalid password!");
		      return null;
		}
		
		return checkUser;
	}
}
