package com.waitme.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {
	
	public static final String LOGIN_PAGE="login";
	
	@RequestMapping("/login")
	public String toLoginPage() {
		
		
		return LOGIN_PAGE;
	}

}
