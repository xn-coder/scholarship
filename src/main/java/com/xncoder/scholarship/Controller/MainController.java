package com.xncoder.scholarship.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "signup";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}	
	
	@GetMapping("/scholarship")
	public String scholarship() {
		return "scholarship";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload-documents";
	}	
}
