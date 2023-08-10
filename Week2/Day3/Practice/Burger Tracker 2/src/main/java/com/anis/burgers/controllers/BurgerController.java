package com.anis.burgers.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anis.burgers.models.Burger;
import com.anis.burgers.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	private final BurgerService burgerservice;

	public BurgerController(BurgerService burgerService) {
		this.burgerservice = burgerService;
	}

	// Show ALL
	@GetMapping("/burgers")
	public String showAll(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> allBurgers = burgerservice.allBurgers();
		model.addAttribute("burgerList", allBurgers);
		return "burgers.jsp";
	}

	// Create One Burger
	@PostMapping("/burgers")
	public String newBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Burger> allBurgers = burgerservice.allBurgers();
			model.addAttribute("burgerList",allBurgers);
			
			return "burgers.jsp";
		} else
			burgerservice.createBurger(burger);
		return "redirect:/burgers";
	}

	// Show Edit One Burger
	@GetMapping("/burgers/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerservice.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}

	// Update Edit one Burger
	@PostMapping("/burgers/{id}/update")
	public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else
			burgerservice.updateBurger(burger);
		return "redirect:/burgers";
	}
	@GetMapping("/burgers/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerservice.findBurger(id);
		model.addAttribute("oneBurger",burger);
		return "oneburger.jsp";
	}
	@DeleteMapping("/burgers/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		burgerservice.deleteBurger(id);
		return "redirect:/burgers";
	}
}
