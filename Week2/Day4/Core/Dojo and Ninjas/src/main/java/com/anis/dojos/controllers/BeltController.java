package com.anis.dojos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.anis.dojos.models.Belt;
import com.anis.dojos.models.Dojo;
import com.anis.dojos.models.User;
import com.anis.dojos.services.BeltService;
import com.anis.dojos.services.DojoService;
import com.anis.dojos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BeltController {

	@Autowired
	private BeltService beltService;
	@Autowired
	private DojoService dojoService;

	@Autowired
	private UserService userService;

// Show all Belts
	@GetMapping("/belts")
	public String showAll(Model model, HttpSession session) {
		// Grab the user_id from session
		Long userId = (Long) session.getAttribute("user_id");
		// Route Guard
		if (userId == null) {
			return "redirect:/login";
		} else {
			User user = userService.getUserById(userId);
			model.addAttribute("user", user);

			List<Belt> allBelts = beltService.allBelts();

			model.addAttribute("allBelts", allBelts);
			return "belts.jsp";
		}
	}
	
	// Show One Dojo
	
    @GetMapping("dojos/{dojoId}")
    public String getBeltsForDojo(@PathVariable Long dojoId, Model model) {
        Dojo dojo = dojoService.findDojo(dojoId);
        List <Belt> allBelts = dojo.getBelts();
        model.addAttribute("dojo", dojo);
        model.addAttribute("allBelts", allBelts);
            return "oneDojo.jsp";

    }
	
	// Show Dojo Form	
	@GetMapping("/dojos/new")
	public String showAllDojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("dojoList", allDojos);
		return "dojoForm.jsp";
	}
	// Create a Dojo
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("dojoList",allDojos);
			
			return "dojoForm.jsp";
		} else
			dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
	}

	// Show Belt Form
	@GetMapping("/belts/new")
	public String beltForm(@ModelAttribute("belt") Belt belt, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("dojoList", allDojos);
		return "beltForm.jsp";
	}
	
	// Create One Belt
	@PostMapping("belts/new")
	public String createOneBelt(@Valid @ModelAttribute("belt") Belt belt,
			BindingResult result,Model model, HttpSession session ) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("dojoList",allDojos);
			
			return "beltForm.jsp";
		} else {
			//1. grab the user_id from the session
			Long userId = (Long) session.getAttribute("user_id");
			//2. Fetch the current user by id
			User actualUser = userService.getUserById(userId);
			belt.setNinja(actualUser);
			//3. Save the belt object with the ninja_id as current id			
			beltService.createBelt(belt);
			
		return "redirect:/belts";
		}
	}
	
	// Show Edit Belt
	@GetMapping("/belts/{beltId}/edit")
	public String showEditBelt(@ModelAttribute("belt") Belt belt, @PathVariable("beltId") Long beltId, Model model, HttpSession session) {
		// Grab current user id and compare it to the belt ninja id
		Long userId = (Long) session.getAttribute("user_id");
		

		Belt thisBelt = beltService.findBelt(beltId);
		// Grab the ninja id from the thisBelt
		Long ninjaId = thisBelt.getNinja().getId();
		//Edit route guard
		if(!(userId.equals(ninjaId))) {
			return "redirect:/belts"; 
		}
		model.addAttribute("belt",thisBelt);
		return "editBelt.jsp";
	}
	// Edit Belt
	@PutMapping("/belts/{id}/edit")
	public String editBelt(@Valid @ModelAttribute("belt") Belt belt,
			BindingResult result,Model model, HttpSession session,
			@PathVariable("id") Long beltId) {
		if (result.hasErrors()) {

			return "editBelt.jsp";
		} else {
			//1. grab the user_id from the session
			Long userId = (Long) session.getAttribute("user_id");
			//2. Fetch the current user by id
			User actualUser = userService.getUserById(userId);
			//2. Fetch the dojo of the belt we want to edit
			Belt actualBelt = beltService.findBelt(beltId);
			Dojo actualDojo = actualBelt.getDojo();
			//3. Add the attribute of dojo to the belt class
			belt.setNinja(actualUser);

			belt.setDojo(actualDojo);
			//4. Save the belt object with the ninja_id as current id			
			beltService.updateBelt(belt);
		return "redirect:/belts";
		}
	}
	
	// Delete Belt
	@DeleteMapping("/belts/{beltId}/delete")
	public String deleteBelt(@PathVariable("beltId") Long beltId) {
		beltService.deleteBelt(beltId);
		return "redirect:/belts";
	}

}