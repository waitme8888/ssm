package com.waitme.ssm.mybatis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.waitme.core.mybatis.service.BaseService;
import com.waitme.ssm.mybatis.dao.UserMapper;
import com.waitme.ssm.mybatis.model.User;

@Service("userService")
public class UserService extends BaseService<User> {
	
	@Resource
	private UserMapper userMapper;



}
