package com.waitme.ssm.mybatis.dao;

import com.waitme.core.mybatis.dao.BaseMapper;
import com.waitme.ssm.mybatis.model.User;

public interface UserMapper extends BaseMapper<User> {
	
	public User selectUserById(Long id);
	
}