package com.jang.biz.service;

public interface PayService {
	
	int addBillingKey(String id, String billingKey);
	
	void getToken();

	String getBillingKey(String reciptId);
	
	void payRequest(String billingKey,String phone,int rentalFee);

}
