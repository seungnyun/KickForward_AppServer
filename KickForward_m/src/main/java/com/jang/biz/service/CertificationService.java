package com.jang.biz.service;

import java.util.HashMap;

public interface CertificationService {
	
	int licenseCertification(HashMap<String, Object> parameterMap);
	
	int insertLicense(String id);
}
