package com.anis.human.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Human {
	@RequestMapping("/")
	public String human(@RequestParam(value = "name") String username,
						@RequestParam(value = "times") int times) {
        StringBuilder response = new StringBuilder();

		for(int i = 0; i < times; i++) {
			response.append(" Hello").append(username);
		}
		return response.toString();
	}
	
}


