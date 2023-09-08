package com.temple202309.mapper;

import java.util.List;  

import com.temple202309.domain.BoardVO;



public interface BoardMapper {

	public List<BoardVO> getList();

	public void insert(BoardVO board);

	public Integer insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);
	
	

}
