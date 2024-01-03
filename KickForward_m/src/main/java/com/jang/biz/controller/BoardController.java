package com.jang.biz.controller;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jang.biz.model.Board;
import com.jang.biz.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService; 
	
	
	@RequestMapping(value="/insertBoard", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> insertBoard(@RequestBody Board board) {   
	    try {
	    	String imageData = board.getImageData();
	    	imageData = imageData.replaceAll("\\r\\n|\\r|\\n","");
	    	String fileName = null;
	    	MultipartFile uploadFile = boardService.base64ToMultipartFile(imageData);
	    	if (!uploadFile.isEmpty()) {
				String originalFileName = uploadFile.getOriginalFilename();
				String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
				UUID uuid = UUID.randomUUID();	//UUID 구하기
				fileName=uuid+"."+ext;
				uploadFile.transferTo(new File("C:\\upload\\" + fileName));
			}
	    	board.setFileName(fileName);
	    	int result = boardService.addBoard(board);
            if (result != 0) {
                return new ResponseEntity<>("1", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("0", HttpStatus.OK);
            }
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>("0", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

}
