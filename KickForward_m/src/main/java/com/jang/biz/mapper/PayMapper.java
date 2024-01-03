package com.jang.biz.mapper;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="payMapper")
public class PayMapper {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	public int addBillingKey(String id, String billingKey) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("id", id);
	    param.put("billingKey", billingKey);
		return sqlSession.update("com.jang.biz.mapper.PayMapper.addBillingKey", param);
	}
}
