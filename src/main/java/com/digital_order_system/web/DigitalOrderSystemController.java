package com.digital_order_system.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digital_order_system.domain.User;

@Controller
@RequestMapping(value="/")
public class DigitalOrderSystemController {

	@GetMapping(value="")
	public String navToIndex(Model model, HttpServletRequest request) {
		
		User user = (User)request.getSession().getAttribute("user");
		
		model.addAttribute("user", user);
		
		return "index";
	}
	
	@GetMapping(value="/admin")
	public String navToAdmin(Model model) {
		return "admin/additems";
	}
	
	@GetMapping(value="/signup")
	public String navToSignup(Model model) {
		return "login";
	}
	
	@GetMapping(value="/logout")
	public String logout(Model model,  HttpServletRequest request) {
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user != null){
			request.getSession().setAttribute("user",null);
		}
		
		return "index";
	}
}
