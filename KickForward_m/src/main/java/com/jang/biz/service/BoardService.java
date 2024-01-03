package com.jang.biz.service;

import org.springframework.web.multipart.MultipartFile;

import com.jang.biz.model.Board;


public interface BoardService {

	int addBoard(Board board);
	
	public MultipartFile base64ToMultipartFile(String base64Image);
	
}
