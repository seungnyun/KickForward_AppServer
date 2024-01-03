package com.jang.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jang.biz.model.KickBoard;
import com.jang.biz.model.Rent;
import com.jang.biz.model.Report;
import com.jang.biz.model.User;
import com.jang.biz.service.KickBoardService;
import com.jang.biz.service.PayService;

@Controller
public class KickBoardController {
	
	@Autowired
	private KickBoardService kickboardService;
	
	@Autowired
	private PayService payService;
	
	@RequestMapping(value="/getKickBoardList", method= RequestMethod.POST)
	public ResponseEntity<List<KickBoard>> getKickBoard() {
	    List<KickBoard> kickBoardList = kickboardService.getKickBoardList();
	    if (kickBoardList != null) {
	        return new ResponseEntity<>(kickBoardList, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
    @RequestMapping(value = "/rentKickboard", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> rentKickboard(@RequestBody Rent rent) {
        try {
        	int result = kickboardService.rentKickBoard(rent.getKickboardId());
        	int result2 = kickboardService.insertRentKickBoard(rent);
        	int result3 = kickboardService.updateUserStateY(rent.getUserId());
        	int usageRecordId = rent.getUsageRecordId();
            if (result!=0 && result2 != 0 && result3 != 0) {
                return new ResponseEntity<>(String.valueOf(usageRecordId), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("0", HttpStatus.OK);
            }
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>("0", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/endRentKickboard", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> endRentKickboard(@RequestBody Rent rent) {
        try {
        	int result = kickboardService.endRentKickBoard(rent.getKickboardId());
        	int rentLog = kickboardService.insertRentLog(rent);
        	int result2 = kickboardService.updateUserStateN(rent.getUserId());
        	payService.payRequest(rent.getBillingKey(), rent.getPhone(), rent.getRentalFee());
            if (result!=0 && rentLog != 0 && result2 != 0) {
                return new ResponseEntity<>("1", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("0", HttpStatus.OK);
            }
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>("0", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value="/rentLogList", method=RequestMethod.POST)
    public ResponseEntity<?> rentLogList(@RequestBody Report report) {
        List<Rent> rentLogList = this.kickboardService.getRentLog(report.getWriterId());
        
        if (!rentLogList.isEmpty()) {
            return new ResponseEntity<>(rentLogList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
	@RequestMapping(value="/checkInuse", method= RequestMethod.POST)
    public ResponseEntity<?> checkInuse(@RequestBody User user) {
        try {
        	User inuseUser = this.kickboardService.getUserInuseState(user.getId());
        	Rent inuseData = null;

        	if (inuseUser != null) {
        		System.out.println(inuseUser.getNo());
        	    inuseData = this.kickboardService.getInuseData(inuseUser.getNo());
        	    
        	}

        	if (inuseUser != null && inuseData != null) {
        	    return new ResponseEntity<>(inuseData, HttpStatus.OK);
        	} else {
        		System.out.println("N");
        	    return new ResponseEntity<>("N", HttpStatus.OK);
        	}
        } catch (EmptyResultDataAccessException e) {
        	e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
