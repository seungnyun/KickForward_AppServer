package com.jang.biz.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.jang.biz.model.Board;




@Mapper
public interface BoardMapper {

	int addBoard(Board board);
	
}
