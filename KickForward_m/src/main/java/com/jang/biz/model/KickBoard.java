package com.jang.biz.model;

public class KickBoard {
	private String serialNumber;
	private String latitude;
	private String longitude;
	private char in_use;
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public char getIn_use() {
		return in_use;
	}
	public void setIn_use(char in_use) {
		this.in_use = in_use;
	}
	
}
