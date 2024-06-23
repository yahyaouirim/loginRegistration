package com.example.loginRegistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.loginRegistration.models.LoginUser;
import com.example.loginRegistration.models.User;
import com.example.loginRegistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	public User register(User newUser, BindingResult result) {
	    
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("password", "Matches", "The Confirm Password must match Password !!no match !");
        }
        // Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        }
        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        // Hash and set password, save user to database
        
    	return userRepo.save(newUser);
    }
    
    public User login(LoginUser newLoginUser, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "unique", "User not found");
    		return null;
    	}
    	User user = potentialUser.get();
    	if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "matches", "Invalid Password!!!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}else {
    		return user;
    	}
    	
    }
    
    public User findUserById(Long id) {
    	Optional<User> user = userRepo.findById(id);
    	if(user.isPresent()) {
    		return user.get();
    	}
    	else {
    		return null;
    	}
    }

}
