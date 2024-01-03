package com.jang.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jang.biz.model.User;
import com.jang.biz.service.UserService;

@Controller
public class JoinController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> join(@RequestBody User user) {
        try {
            int result = this.userService.insertUser(user);
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
