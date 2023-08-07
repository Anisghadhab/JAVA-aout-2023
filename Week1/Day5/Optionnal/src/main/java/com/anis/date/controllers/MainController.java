package com.anis.date.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String showDate(Model model) {
		Date date = new Date();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dMMM, yyyy", Locale.ENGLISH);
		
		model.addAttribute("date", dateFormat.format(date));
		return "date.jsp";
	}
	@RequestMapping("time")
	public String showTime(Model model) {
		Date date = new Date();
		 SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
		
		model.addAttribute("time", timeFormat.format(date));
		return "time.jsp";
		
	}
}
