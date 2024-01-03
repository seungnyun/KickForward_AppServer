package com.jang.biz.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jang.biz.model.License;
import com.jang.biz.service.CertificationService;

@Controller
public class CertificationController {
	
	@Autowired
	private CertificationService certificationService;
	
	
	@RequestMapping(value = "/certification", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> checkLicense(@RequestBody License license, BindingResult result, Model model) {
		
		try {

			HashMap<String, Object> parameterMap = new HashMap<>();
			parameterMap.put("userName", license.getUserName());
			parameterMap.put("birthDate", license.getBirthDate());
			parameterMap.put("licenseNo01", license.getLicenseNo01());
			parameterMap.put("licenseNo02", license.getLicenseNo02());
			parameterMap.put("licenseNo03", license.getLicenseNo03());
			parameterMap.put("licenseNo04", license.getLicenseNo04());
			parameterMap.put("serialNo", license.getSerialNo());

			if (certificationService.licenseCertification(parameterMap) == 1) {
				System.out.println("인증완료");
				certificationService.insertLicense(license.getId());
				return new ResponseEntity<>("1", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("0", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("0", HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
