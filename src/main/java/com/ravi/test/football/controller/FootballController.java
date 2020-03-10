package com.ravi.test.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.test.football.service.FootballService;

@RestController
@RequestMapping("/test")
public class FootballController {
	
	@Autowired
	private FootballService footballService;

	@GetMapping
	public String test(@RequestParam("countryName") String countryName, @RequestParam("leagueName")String leagueName, @RequestParam("teamName") String teamName) {
		return footballService.getResult(countryName,leagueName,teamName).toString();
		
	}
	
	
}
