package com.digital_order_system.service;

import com.digital_order_system.domain.User;
import com.digital_order_system.web.form.UserForm;

public interface UserService {
	
	User addUser(UserForm userForm);
	
	User login(String name1, String password);

}
