package com.temple202309.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.temple202309.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.temple202309.mappers.temple202309";

	@Override
	public List<BoardVO> list() throws Exception {
		
		return sql.selectList(namespace + ".lsit");
	}

}
