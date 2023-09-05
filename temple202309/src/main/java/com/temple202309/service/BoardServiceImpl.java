package com.temple202309.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.temple202309.dao.BoardDAO;
import com.temple202309.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public List<BoardVO> list() throws Exception {

		return dao.list();
	}

}