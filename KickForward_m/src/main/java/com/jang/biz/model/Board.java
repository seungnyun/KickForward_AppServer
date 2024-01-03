package com.jang.biz.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int bno;
	private String title;
	private String writerId;
	private String content;
	private Date reg_Date;
	private int viewcnt = 0;
	private int replycnt = 0;
	private int recommendcnt = 0;
	private char del_yn = 'n';
	private String location;
	private String kbnumber;
	private String fileName;
	private MultipartFile uploadFile;
	private String imageData;
	
	
	
	
	public String getImageData() {
		return imageData;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(Date reg_Date) {
		this.reg_Date = reg_Date;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public int getRecommendcnt() {
		return recommendcnt;
	}
	public void setRecommendcnt(int recommendcnt) {
		this.recommendcnt = recommendcnt;
	}
	public char getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(char del_yn) {
		this.del_yn = del_yn;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getKbnumber() {
		return kbnumber;
	}
	public void setKbnumber(String kbnumber) {
		this.kbnumber = kbnumber;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}	
}
