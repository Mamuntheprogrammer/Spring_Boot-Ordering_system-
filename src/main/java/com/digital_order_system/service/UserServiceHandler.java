package com.digital_order_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.digital_order_system.domain.User;
import com.digital_order_system.repo.UserRepository;
import com.digital_order_system.web.form.UserForm;

@Service
public class UserServiceHandler implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(UserForm userForm) {
		
		User user = new User();
		user.setId(userForm.getId());
		user.setName(userForm.getName());
		user.setName1(userForm.getName1());
		user.setQuote(userForm.getQuote());
		user.setNumber(userForm.getNumber());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String hashedPassword = passwordEncoder.encode(userForm.getPassword());
	    String hashedPassword1 = passwordEncoder.encode(userForm.getPassword1());
	    
		user.setPassword(hashedPassword);
		user.setPassword1(hashedPassword1);
		user.setDob(userForm.getDob());
		
		User userExisting = userRepository.findByName1(userForm.getName1());
		
		if(userExisting != null && userExisting.getId() !=null){
			return user;
		}
		else{
		
			return userRepository.saveAndFlush(user);
		}
	}

	@Override
	public User login(String name1, String password) {
		
		User user = userRepository.findByName1(name1);
		
		if(user == null){
			return null;
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String existingPassword = password;
		String dbPassword       = user.getPassword();

		if (passwordEncoder.matches(existingPassword, dbPassword)) {
		    return user;
		} 
		
		return null;
	}

}
