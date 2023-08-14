package com.anis.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anis.login.models.LoginUser;
import com.anis.login.models.User;
import com.anis.login.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	// Add once service is implemented:
	// @Autowired
	// private UserService userServ;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());

		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// TO-DO Later -- call a register method in the service
		userService.register(newUser, result);
		// to do some extra validations and create a new user!
		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}

		// No errors!
		// TO-DO Later: Store their ID from the DB in session,
		// in other words, log them in.

		session.setAttribute("user_id", newUser.getId());
		return "redirect:/welcome";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}

		// No errors!
		// TO-DO Later: Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("user_id", user.getId());
		return "redirect:/welcome";
	}
	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		
		return "redirect:/login";
	}

}
