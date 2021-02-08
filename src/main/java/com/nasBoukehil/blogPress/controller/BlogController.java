package com.nasBoukehil.blogPress.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

	private Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@GetMapping("/")
	public String showLandingPage(Model model) {
		logger.info("Show Home Method !!");
		return "home";
	}
}
