package com.waitme.ssm.dao;

import com.waitme.core.mybatis.dao.BaseMapper;
import com.waitme.ssm.model.User;

public interface UserMapper extends BaseMapper<User> {
	
	public User selectUserById(Long id);
	
}