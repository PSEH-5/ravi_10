package com.ravi.test.football.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class FootballController {

	@GetMapping
	public String test() {
		return "how are you ravi";
	}
	
	
}
