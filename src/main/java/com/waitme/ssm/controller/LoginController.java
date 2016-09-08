package com.waitme.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {
	
	public static final String ADMIN_LOGIN_PAGE = "admin/login";
	public static final String ADMIN_INDEX_PAGE = "admin/index";
	public static final String SYS_LOGIN_PAGE = "sys/login";
	public static final String SYS_INDEX_PAGE = "sys/index";
	
	@RequestMapping("/admin/login")
	public String toLoginPage() {
		
		
		return ADMIN_LOGIN_PAGE;
	}
	
	@RequestMapping("/admin/index")
	public String toIndexpage() {
		
		return ADMIN_INDEX_PAGE;
	}
	
	@RequestMapping("/sys/login")
	public String toSysLoginPage() {
		
		
		return SYS_LOGIN_PAGE;
	}
	
	@RequestMapping("/sys/index")
	public String toSysIndexpage() {
		
		return SYS_INDEX_PAGE;
	}

}
