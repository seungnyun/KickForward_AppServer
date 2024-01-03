package com.jang.biz.service;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jang.biz.mapper.BoardMapper;
import com.jang.biz.model.Board;

@Service(value = "boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int addBoard(Board board) {
		return this.boardMapper.addBoard(board);
	}

	public MultipartFile base64ToMultipartFile(String base64Image) {
	    try {
	        // Base64 문자열을 바이트 배열로 디코딩
	        //byte[] imageBytes = Base64.getDecoder().decode(base64Image);
	    	byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
	    			
	        // 임시 파일 생성
	        String originalFilename = "image.jpg"; // 파일 이름 설정
	        String name = "image"; // 폼 필드 이름 설정
	        String contentType = "image/jpeg"; // 파일 컨텐츠 타입 설정

	        MultipartFile multipartFile = new MockMultipartFile(
	            name, originalFilename, contentType, imageBytes);

	        return multipartFile;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	

}
