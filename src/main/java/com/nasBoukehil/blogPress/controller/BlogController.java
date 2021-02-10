package com.nasBoukehil.blogPress.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nasBoukehil.blogPress.constants.BlogpressConstants;

@Controller
public class BlogController {

	private Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@GetMapping("/")
	public String showLandingPage(Model model) {
		logger.info("Show Home Method !!");
		setProcessingData(model, BlogpressConstants.TITLE_HOME_PAGE);
		return "home";
	}
	
	@GetMapping(value = "/controlPage")
	public String showControlPage(Model model) {
		logger.info("### This is control Page ###");
		setProcessingData(model, BlogpressConstants.TITLE_LANDING_CONTROL_PAGE);
		return "control-page";
	}

	@GetMapping(value = "/login")
	public String showLoginPage(@RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout,
								Model model) {
		logger.info("### This is Login Page URL ###");
		if (error != null) {
			model.addAttribute("error", "Invalid Credentials provided");
		}
		
		if (logout != null) {
			model.addAttribute("message", "Logged out");
		}
		
		setProcessingData(model, BlogpressConstants.TITLE_LOGIN_PAGE);
		
		return "login";
	}

	
	private void setProcessingData(Model model, String PageTitle) {
		model.addAttribute(BlogpressConstants.PAGE_TITLE, PageTitle);
	}
}
