package com.jang.biz.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.biz.model.User;

@Repository(value="userMapper")
public class UserMapper {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public User getUser(String id) {
		return sqlSession.selectOne("com.jang.biz.mapper.UserMapper.getUser", id);
	}
	
	public int insertUser(User user) {
		return sqlSession.insert("com.jang.biz.mapper.UserMapper.insertUser", user);
	}
	
	public int insertLicense(String id) {
		return sqlSession.update("com.jang.biz.mapper.UserMapper.insertLicense", id);
	}
	
	public String findIdForCertification(String name) {
		return sqlSession.selectOne("com.jang.biz.mapper.UserMapper.findIdForCertification", name);
	}

	
}
