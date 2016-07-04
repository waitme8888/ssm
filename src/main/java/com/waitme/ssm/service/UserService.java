package com.waitme.ssm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.waitme.core.mybatis.service.BaseService;
import com.waitme.ssm.dao.UserMapper;
import com.waitme.ssm.model.User;

@Service("userService")
public class UserService extends BaseService<User> {
	
	@Resource
	private UserMapper userMapper;



}
