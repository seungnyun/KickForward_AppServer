package com.jang.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.biz.mapper.KickBoardMapper;
import com.jang.biz.model.KickBoard;
import com.jang.biz.model.Rent;
import com.jang.biz.model.User;

@Service(value="kickBoardService")
public class KickBoardServiceImpl implements KickBoardService {
	
	@Autowired
	private KickBoardMapper kickboardMapper;
	
	@Override
	public List<KickBoard> getKickBoardList() {
		return this.kickboardMapper.getKickBoardList();
	}

	@Override
	public int rentKickBoard(String serialNumber) {
		return this.kickboardMapper.rentKickBaord(serialNumber);
	}

	@Override
	public int endRentKickBoard(String serialNumber) {
		return this.kickboardMapper.endRentKickBaord(serialNumber);
	}

	@Override
	public int insertRentLog(Rent rent) {
		return this.kickboardMapper.insertRentLog(rent);
	}

	@Override
	public  List<Rent> getRentLog(String userId) {
		return this.kickboardMapper.getRentLog(userId);
	}

	@Override
	public int insertRentKickBoard(Rent rent) {
		return this.kickboardMapper.insertRentKickBoard(rent);
	}

	@Override
	public int updateUserStateY(int userId) {
		return this.kickboardMapper.updateUserStateY(userId);
	}
	
	@Override
	public int updateUserStateN(int userId) {
		return this.kickboardMapper.updateUserStateN(userId);
	}

	@Override
	public User getUserInuseState(String id) {
		return this.kickboardMapper.getUserInuseState(id);
	}

	@Override
	public Rent getInuseData(int id) {
		return this.kickboardMapper.getInuseData(id);
	}
	
	
	
	
	
}
