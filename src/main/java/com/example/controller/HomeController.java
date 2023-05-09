package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/home/main", "/"})
	public String showMain() {
		
		return "/usr/home/main";
	}
}