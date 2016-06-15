package com.waitme.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waitme.ssm.model.User;
import com.waitme.ssm.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Resource
	private UserService userService;

	@RequestMapping("/{id}")
	@ResponseBody
	public User getUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		
		return user;
	}
}
