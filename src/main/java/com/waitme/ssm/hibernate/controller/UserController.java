package com.waitme.ssm.hibernate.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waitme.ssm.hibernate.model.User;
import com.waitme.ssm.hibernate.service.UserService;

@RequestMapping("/user2")
@Controller("UserController2")
public class UserController {
	
	@Resource(name="user2Service")
	private UserService userService;
	
	@RequestMapping("/list")
	public void list() {
		List<User> list = userService.findAll();
		System.out.println(list);
	}

}
