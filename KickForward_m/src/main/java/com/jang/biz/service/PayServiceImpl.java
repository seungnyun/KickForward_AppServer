package com.jang.biz.service;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jang.biz.mapper.PayMapper;

import kr.co.bootpay.Bootpay;
import kr.co.bootpay.model.request.SubscribePayload;
import kr.co.bootpay.model.request.User;

@Service(value= "payService")
public class PayServiceImpl implements PayService {
	
	
	String restapi; 
    String privateKey;
	
    private final Bootpay bootpay;

    @Autowired
    public PayServiceImpl(@Value("${bootpay-restapi}") String restapi,
                          @Value("${bootpay-private-key}") String privateKey) {
        this.restapi = restapi;
        this.privateKey = privateKey;
        this.bootpay = new Bootpay(restapi, privateKey);
    }
	
	@Autowired
	private PayMapper paymapper;

	@Override
	public int addBillingKey(String id, String billingKey) {
        return this.paymapper.addBillingKey(id, billingKey);
	}

	@Override
	public void getToken() {
		try {
            HashMap<String, Object> res = bootpay.getAccessToken();
            if(res.get("error_code") == null) { //success
                System.out.println("goGetToken success: " + res);
            } else {
                System.out.println("goGetToken false: " + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public String getBillingKey(String receiptId) {
		String billingKey = null;
		try {
			HashMap<String, Object> res = bootpay.lookupBillingKey(receiptId);
			JSONObject json = new JSONObject(res);
			System.out.printf("JSON: %s", json);
			if (res.get("error_code") == null) { // success
				System.out.println("getReceipt success: " + res);
				billingKey = json.getString("billing_key");
			} else {
				System.out.println("getReceipt false: " + res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billingKey;
	}
	
	@Override
	public void payRequest(String billingKey, String phone, int rentalFee) {
		try {
			bootpay.getAccessToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SubscribePayload payload = new SubscribePayload();
		payload.billingKey = billingKey;
		payload.orderName = "킥포워드 자동결제";
		payload.price = rentalFee;
		payload.user = new User();
		payload.user.phone = phone;
		payload.orderId = "" + (System.currentTimeMillis()/1000);
		try {
			   HashMap res = bootpay.requestSubscribe(payload);
			   JSONObject json =  new JSONObject(res);
			   System.out.printf( "JSON: %s", json);

			   if(res.get("error_code") == null) { //success
			       System.out.println("requestSubscribe success: " + res);
			   } else {
			       System.out.println("requestSubscribe false: " + res);
			   }
			} catch (Exception e) {
			   e.printStackTrace();
			}
	}
	


	
	
}

