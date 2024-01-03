package com.jang.biz.model;

import javax.validation.constraints.NotEmpty;

public class License {
	@NotEmpty(message = "생년월일을 입력하세요")
	private String birthDate;
	
	@NotEmpty(message = "지역코드를 입력하세요")
	private String licenseNo01;
	
	@NotEmpty(message = "년도 입력하세요")
	private String licenseNo02;
	
	@NotEmpty(message = "6자리 숫자를 입력하세요")
	private String licenseNo03;
	
	@NotEmpty(message = "2자리 숫자를 입력하세요")
	private String licenseNo04;
	
	@NotEmpty(message = "암호일련번호를 입력하세요")
	private String serialNo;
	
	@NotEmpty(message = "이름을 입력하세요")
	private String userName;
	
	private String id;
	
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getLicenseNo01() {
		return licenseNo01;
	}
	public void setLicenseNo01(String licenseNo01) {
		this.licenseNo01 = licenseNo01;
	}
	public String getLicenseNo02() {
		return licenseNo02;
	}
	public void setLicenseNo02(String licenseNo02) {
		this.licenseNo02 = licenseNo02;
	}
	public String getLicenseNo03() {
		return licenseNo03;
	}
	public void setLicenseNo03(String licenseNo03) {
		this.licenseNo03 = licenseNo03;
	}
	public String getLicenseNo04() {
		return licenseNo04;
	}
	public void setLicenseNo04(String licenseNo04) {
		this.licenseNo04 = licenseNo04;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
