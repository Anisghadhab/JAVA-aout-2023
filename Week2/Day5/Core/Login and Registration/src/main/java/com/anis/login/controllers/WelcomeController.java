package com.anis.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anis.login.models.User;
import com.anis.login.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class WelcomeController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/welcome")
	
	public String welcome(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");

		if (userId == null) {
			return "redirect:/login";
		}
		User currentUser = userService.getUserById(userId);
		model.addAttribute("user", currentUser);
		return "welcome.jsp";
	}
}
