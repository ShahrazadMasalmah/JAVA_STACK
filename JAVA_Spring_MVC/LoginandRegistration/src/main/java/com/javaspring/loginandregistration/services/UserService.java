package com.javaspring.loginandregistration.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javaspring.loginandregistration.models.LoginUser;
import com.javaspring.loginandregistration.models.User;
import com.javaspring.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	//return all users
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	//create a user
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	//find the user
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
	
	//update a user
	public User updateUser(User user) {
		return userRepo.save(user);
	}
		
	//delete user
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	//register
	public User register(User newUser, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "Exists", "This email is already exists!");
			return null;
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())){
			result.rejectValue("confirmPassword", "Matches", "The confirm password must match the password!");
			return null;
		}
		
		String hashPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashPassword);
		return userRepo.save(newUser);
	}
	
	//login
	public User login(LoginUser loginUser, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(loginUser.getEmail());
		
		if (optionalUser.isEmpty()) {
		     result.rejectValue("email", "Not Found", "User not found");
		     return null;
		   }
		User checkUser = optionalUser.get();
		
		if(!BCrypt.checkpw(loginUser.getPassword(), checkUser.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid password!");
			return null;
		}
		
		return checkUser;
	}
}
