package com.jang.biz.service;

import java.util.List;

import com.jang.biz.model.KickBoard;
import com.jang.biz.model.Rent;
import com.jang.biz.model.User;

public interface KickBoardService {
	List<KickBoard> getKickBoardList();
	
	int rentKickBoard(String serialNumber);
	int insertRentKickBoard(Rent rent);
	
	int endRentKickBoard(String serialNumber);
	
	int insertRentLog(Rent rent);
	
	List<Rent> getRentLog(String userId);
	 
	int updateUserStateY(int userId); 
	int updateUserStateN(int userId); 
	
	User getUserInuseState(String id);
	
	Rent getInuseData(int id);
	
	
}
