package com.temple202309.service;

import java.util.List; 

import org.springframework.stereotype.Service;
import com.temple202309.domain.BoardVO;

import com.temple202309.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {;

		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {

		return mapper.read(bno);

	}

	@Override
	public boolean modify(BoardVO board) {

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {

		return mapper.delete(bno) ;
	}

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}

	
	

}
