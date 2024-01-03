package com.jang.biz.service;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jang.biz.mapper.UserMapper;

import io.codef.api.EasyCodef;
import io.codef.api.EasyCodefServiceType;

@Service(value="CertificationService")
public class CertificationServiceImpl implements CertificationService {
	
	@Value("${codef-public-key}")
	String publicKey;
	
	@Value("${codef-client-id}")
	String clientId;
	
	@Value("${codef-client-secret}")
	String clientSecret;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insertLicense(String id) {
		return this.userMapper.insertLicense(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int licenseCertification(HashMap<String, Object> parameterMap) {

		/** 토큰 발급 */
		EasyCodef codef = new EasyCodef();
		codef.setClientInfoForDemo("clientId", "clientSecret");
		codef.setPublicKey("publicKey");
		
//		/** 요청 파라미터 설정 - 각 상품별 파라미터를 설정(https://developer.codef.io/products) */
//		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("organization", "0001"); // 기관코드 설정
//		parameterMap.put("birthDate", "");
//		parameterMap.put("licenseNo01", "");
//		parameterMap.put("licenseNo02", "");
//		parameterMap.put("licenseNo03", "");
//		parameterMap.put("licenseNo04", "");
//		parameterMap.put("serialNo", "");
//		parameterMap.put("userName", "");
//		parameterMap.put("licenseNumber", "");
//		parameterMap.put("inquiryType", "0");

		/** 코드에프 정보 조회 요청 - 서비스타입(API:정식, DEMO:데모, SANDBOX:샌드박스) */
		String productUrl = "/v1/kr/public/ef/driver-license/KoRoad-status";
		String result = null;
		try {
			result = codef.requestProduct(productUrl, EasyCodefServiceType.DEMO, parameterMap);
		} catch (JsonProcessingException | UnsupportedEncodingException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** 코드에프 정보 결과 확인 */
		System.out.println(result);

		HashMap<String, Object> responseMap = null;
		try {
			responseMap = new ObjectMapper().readValue(result, HashMap.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			HashMap<String, Object> resultMap = (HashMap<String, Object>) responseMap.get("result");

			assertEquals("코드에프 상품 요청 결과 실패(반환된 코드와 메시지 확인 필요)", "CF-00000", (String) resultMap.get("code"));
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(result);

			JSONObject dataObject = (JSONObject) jsonObject.get("data");
			String resUserNm = (String) dataObject.get("resUserNm");
			String resAuthenticityDesc2 = (String) dataObject.get("resAuthenticityDesc2");
			System.out.println("resAuthenticityDesc2: " + resAuthenticityDesc2);
			
			if(resAuthenticityDesc2.equals("도로교통공단 전산 자료와 일치합니다.")) {
				return 1;
			}else {
				return 0;
			}
			
		} catch (AssertionError | ParseException e) {
			e.printStackTrace();
			return 0;
		}		
	}
	
	
}
