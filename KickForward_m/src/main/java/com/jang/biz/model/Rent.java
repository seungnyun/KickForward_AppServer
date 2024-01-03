package com.jang.biz.model;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class Rent {
	private Integer usageRecordId;
	private int userId;
	private String kickboardId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp rentalDatetime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp returnDatetime;
	
	private String rentalLatitude;
	private String rentalLongitude;
	private String returnLatitude;
	private String returnLongitude;
	private String rentalStatus;
	private int rentalFee;
	
	private String billingKey;
	private String phone;
	public Integer getUsageRecordId() {
		return usageRecordId;
	}
	public void setUsageRecordId(Integer usageRecordId) {
		this.usageRecordId = usageRecordId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getKickboardId() {
		return kickboardId;
	}
	public void setKickboardId(String kickboardId) {
		this.kickboardId = kickboardId;
	}
	public Timestamp getRentalDatetime() {
		return rentalDatetime;
	}
	public void setRentalDatetime(Timestamp rentalDatetime) {
		this.rentalDatetime = rentalDatetime;
	}
	public Timestamp getReturnDatetime() {
		return returnDatetime;
	}
	public void setReturnDatetime(Timestamp returnDatetime) {
		this.returnDatetime = returnDatetime;
	}
	public String getRentalLatitude() {
		return rentalLatitude;
	}
	public void setRentalLatitude(String rentalLatitude) {
		this.rentalLatitude = rentalLatitude;
	}
	public String getRentalLongitude() {
		return rentalLongitude;
	}
	public void setRentalLongitude(String rentalLongitude) {
		this.rentalLongitude = rentalLongitude;
	}
	public String getReturnLatitude() {
		return returnLatitude;
	}
	public void setReturnLatitude(String returnLatitude) {
		this.returnLatitude = returnLatitude;
	}
	public String getReturnLongitude() {
		return returnLongitude;
	}
	public void setReturnLongitude(String returnLongitude) {
		this.returnLongitude = returnLongitude;
	}
	public String getRentalStatus() {
		return rentalStatus;
	}
	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}
	public int getRentalFee() {
		return rentalFee;
	}
	public void setRentalFee(int rentalFee) {
		this.rentalFee = rentalFee;
	}
	public String getBillingKey() {
		return billingKey;
	}
	public void setBillingKey(String billingKey) {
		this.billingKey = billingKey;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
