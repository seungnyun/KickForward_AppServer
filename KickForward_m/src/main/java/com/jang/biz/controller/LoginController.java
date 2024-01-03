package com.jang.biz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jang.biz.model.User;
import com.jang.biz.service.JwtService;
import com.jang.biz.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtService jwtService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loginUser = this.userService.getUser(user.getId());
            
            if (loginUser != null && loginUser.getPass().equals(user.getPass())) {
                // 로그인 성공 시 JWT 토큰 생성
                String token = jwtService.createToken(loginUser, "false"); // 로그인 유지 체크 안 된 경우
                // JWT 토큰을 헤더에 추가하여 반환
                HttpHeaders headers = new HttpHeaders();
                headers.add("jwt-token", token);
                
                System.out.println("Response Data: " + loginUser.toString());
                System.out.println("Response Headers: " + headers.toString());

                return new ResponseEntity<>(loginUser, headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
	@RequestMapping(value="/checkTokenExp", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> checkTokenExp(@RequestBody Map<String, String> request) {
	    String token = request.get("token");
	    if (jwtService.checkTokenExp(token)) {
	    	return new ResponseEntity<>("1", HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>("0", HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value="/memberInfo", method= RequestMethod.POST)
    public ResponseEntity<?> memberInfo(@RequestBody User user) {
        try {
            User loginUser = this.userService.getUser(user.getId());
            
            if (loginUser != null && loginUser.getPass().equals(user.getPass())) {
                return new ResponseEntity<>(loginUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

