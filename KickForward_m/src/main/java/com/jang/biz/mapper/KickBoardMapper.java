package com.jang.biz.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.biz.model.KickBoard;
import com.jang.biz.model.Rent;
import com.jang.biz.model.User;

@Repository(value="kickboardMapper")
public class KickBoardMapper {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<KickBoard> getKickBoardList() {
		return sqlSession.selectList("com.jang.biz.mapper.KickBoardMapper.getKickBoardList");
	}
	
	public int rentKickBaord(String serialNumber) {
		return sqlSession.update("com.jang.biz.mapper.KickBoardMapper.rentKickBoard", serialNumber);
	}
	
	public int insertRentKickBoard(Rent rent) {
		return sqlSession.insert("com.jang.biz.mapper.KickBoardMapper.insertRentKickBoard",rent);
	}
	
	public int endRentKickBaord(String serialNumber) {
		return sqlSession.update("com.jang.biz.mapper.KickBoardMapper.endRentKickBoard", serialNumber);
	}
	
	public int insertRentLog(Rent rent) {
		return sqlSession.update("com.jang.biz.mapper.KickBoardMapper.insertRentLog",rent);
	}
	
	public  List<Rent> getRentLog(String userId) {
		return sqlSession.selectList("com.jang.biz.mapper.KickBoardMapper.getRentLog",userId);
	}
	
	public int updateUserStateY(int userId) {
		return sqlSession.update("com.jang.biz.mapper.KickBoardMapper.updateUserStateY",userId);
	}
	
	public int updateUserStateN(int userId) {
		return sqlSession.update("com.jang.biz.mapper.KickBoardMapper.updateUserStateN",userId);
	}
	
	public User getUserInuseState(String id) {
		return sqlSession.selectOne("com.jang.biz.mapper.KickBoardMapper.getUserInuseState",id);
	}
	
	public Rent getInuseData(int id) {
		return sqlSession.selectOne("com.jang.biz.mapper.KickBoardMapper.getInuseData",id);
	}
	
	
}
