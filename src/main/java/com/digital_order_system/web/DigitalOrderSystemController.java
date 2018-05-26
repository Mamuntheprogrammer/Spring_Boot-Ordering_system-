package com.digital_order_system.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class DigitalOrderSystemController {

	@GetMapping(value="")
	public String navToIndex(Model model) {
		return "index";
	}
	
	@GetMapping(value="/admin")
	public String navToAdmin(Model model) {
		return "admin/additems";
	}
}
