package com.temple202309.dao;

import java.util.List;

import com.temple202309.domain.BoardVO;

public interface BoardDAO {
	
	public List<BoardVO> list() throws Exception;

}
