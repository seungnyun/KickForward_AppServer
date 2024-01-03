package com.jang.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.biz.mapper.UserMapper;
import com.jang.biz.model.User;

@Service(value= "userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUser(String id) {
		return this.userMapper.getUser(id);
	}

	@Override
	public int insertUser(User user) {
		return this.userMapper.insertUser(user);
	}
	
	@Override
	public String findIdForCertification(String name) {
		return this.userMapper.findIdForCertification(name);
	}
	
}
