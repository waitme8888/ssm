package com.waitme.ssm.hibernate.service;

import org.springframework.stereotype.Service;

import com.waitme.core.hibernate.service.BaseService;
import com.waitme.ssm.hibernate.model.User;

@Service("user2Service")
public class UserService extends BaseService<User>{

	
	public void saveTest() {
		
		User user = this.get(new Long(1));
		System.out.println(user);
		this.delete(user);
		
		System.out.println(1/0);
		
	}

}
