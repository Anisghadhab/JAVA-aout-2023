package com.anis.travels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anis.travels.models.Travel;
import com.anis.travels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {

	private final TravelService travelservice;

	public TravelController(TravelService travelService) {
		this.travelservice = travelService;
	}

	// Show ALL
	@GetMapping("/travels")
	public String showAll(@ModelAttribute("travel") Travel travel, Model model) {
		List<Travel> allTravels = travelservice.allTravels();
		model.addAttribute("travelList", allTravels);
		return "travels.jsp";
	}

	// Create One Travel
	@PostMapping("/travels")
	public String newtravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Travel> allTravels = travelservice.allTravels();
			model.addAttribute("travelList",allTravels);
			
			return "travels.jsp";
		} else
			travelservice.createTravel(travel);
		return "redirect:/travels";
	}

	// Show Edit One Travel
	@GetMapping("/travels/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Travel travel = travelservice.findTravel(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}

	// Update Edit one Travel
	@PostMapping("/travels/{id}/update")
	public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else
			travelservice.updateTravel(travel);
		return "redirect:/travels";
	}
	@GetMapping("/travels/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Travel travel = travelservice.findTravel(id);
		model.addAttribute("oneTravel",travel);
		return "onetravel.jsp";
	}
	@DeleteMapping("/travels/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		travelservice.deleteTravel(id);
		return "redirect:/travels";
	}
}
