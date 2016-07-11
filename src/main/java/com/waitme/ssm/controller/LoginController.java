package com.waitme.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {
	
	public static final String LOGIN_PAGE = "login";
	public static final String INDEX_PAGE = "index";
	
	@RequestMapping("/login")
	public String toLoginPage() {
		
		
		return LOGIN_PAGE;
	}
	
	@RequestMapping("/index")
	public String toIndexpage() {
		
		return INDEX_PAGE;
	}

}
