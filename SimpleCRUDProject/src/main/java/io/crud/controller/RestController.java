package io.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String welcomePage() {
		return "welcome to home page";
	}
	
	@GetMapping("/user")
	public String userWelcome(){
		return "Welcome to page User";
	}
	
	@GetMapping("/admin")
	public String adminWelcome(){
		return "Welcome to page Admin";
	}
}
