package com.anis.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	
	@RequestMapping("/omikuji")
	public String form() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/processForm", method=RequestMethod.POST)
	public String form(
			@RequestParam(value="number") int number,
			@RequestParam(value="cityName") String cityName,
			@RequestParam(value="personName") String personName,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="somethingNice") String somethingNice,
			HttpSession session
			) {
		
		session.setAttribute("number", number);
		session.setAttribute("cityName", cityName);
		session.setAttribute("personName", personName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("somethingNice", somethingNice);

		
		return "redirect:/show";
	}
	@RequestMapping("/show")
	public String display() {
		
		return "show.jsp";
	}
}	
