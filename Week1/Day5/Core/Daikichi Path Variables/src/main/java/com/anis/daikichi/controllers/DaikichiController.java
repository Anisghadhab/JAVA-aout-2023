package com.anis.daikichi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	@RequestMapping("/daikichi/{value1}/{value2}")
	public String congrats(@PathVariable("value1") String value1, @PathVariable("value2") String value2) {
		return "Congratulations! You will soon " + value1 + " to " + value2 + "!";
	}
	
	@RequestMapping("/daikichi/lotto/{number}")
	public String lotto(@PathVariable("number") int number ) {
		if (number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		} else 
			return  "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		
	}

}
