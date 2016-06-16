package com.waitme.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.waitme.ssm.dao.UserMapper;
import com.waitme.ssm.model.User;
import com.waitme.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMappser;

	@Override
	public User getUser(Long id) {
		
//		return userMappser.selectByPrimaryKey(id);
		return userMappser.selectUserById(id);
	}

}
