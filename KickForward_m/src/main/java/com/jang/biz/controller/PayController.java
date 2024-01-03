package com.jang.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jang.biz.model.Pay;
import com.jang.biz.service.PayService;


@Controller
public class PayController {
	
	@Autowired
	private PayService payService;

	
	@RequestMapping(value="/pay", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> PayInsert(@RequestBody Pay pay) {   
	    try {
		    payService.getToken();
		    int result = payService.addBillingKey(pay.getId(),payService.getBillingKey(pay.getReceipt_id()));
            if (result != 0) {
                return new ResponseEntity<>("1", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("0", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("0", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
