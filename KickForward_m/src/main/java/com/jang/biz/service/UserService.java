package com.jang.biz.service;

import org.springframework.stereotype.Service;

import com.jang.biz.model.User;

@Service(value="userService")
public interface UserService {
	User getUser(String id);
	
	int insertUser(User user);
	
	String findIdForCertification(String name); //운전면허 입력을 위한 ID찾기
	
}
