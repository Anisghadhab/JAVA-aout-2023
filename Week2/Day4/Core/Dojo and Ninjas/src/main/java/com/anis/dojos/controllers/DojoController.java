//package com.anis.dojos.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.anis.dojos.models.Dojo;
//import com.anis.dojos.models.Ninja;
//import com.anis.dojos.models.User;
//import com.anis.dojos.services.DojoService;
//import com.anis.dojos.services.NinjaService;
//import com.anis.dojos.services.UserService;
//
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//
//@Controller
//public class DojoController {
//	@Autowired
//	private DojoService dojoService;
//
//	@Autowired
//	private NinjaService ninjaService;
//	@Autowired
//	private UserService userService;
//
//	// Show All Dojos
//	@GetMapping("/dojos")
//	public String showAll(Model model, HttpSession session) {
//		// Grab the user_id from session
//		Long userId = (Long) session.getAttribute("user_id");
//		// Route Guard
//		if (userId == null) {
//			return "redirect:/login";
//		} else {
//			User user = userService.getUserById(userId);
//			model.addAttribute("user", user);
//
//			List<Dojo> allDojos = dojoService.allDojos();
//
//			model.addAttribute("allDojos", allDojos);
//			return "dojos.jsp";
//		}
//	}
//
//	// Show Dojo Form
//	@GetMapping("/dojos/new")
//	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
//		return "dojoForm.jsp";
//	}
//
//	// Create One Dojo
//	@PostMapping("dojos/new")
//	public String createOneDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
//		if (result.hasErrors()) {
//			return "dojoForm.jsp";
//		} else
//			dojoService.createDojo(dojo);
//		return "redirect:/dojos";
//	}
//
//	// Show Ninja Form
//	@GetMapping("/ninjas/new")
//	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
//		List<Dojo> allDojos = dojoService.allDojos();
//		model.addAttribute("dojoList", allDojos);
//		return "ninjaForm.jsp";
//	}
//
//	// Create Ninja
//	@PostMapping("/ninjas/new")
//	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			List<Dojo> allDojos = dojoService.allDojos();
//			model.addAttribute("dojoList", allDojos);
//
//			return "ninjaForm.jsp";
//		} else
//			ninjaService.createNinja(ninja);
//		return "redirect:/dojos";
//	}
//
//	@GetMapping("dojos/{id}")
//	public String showOneDojo(@PathVariable("id") Long id, Model model) {
//		Dojo oneDojo = dojoService.findDojo(id);
//		model.addAttribute("oneDojo", oneDojo);
//		return "oneDojo.jsp";
//	}
//
//}
