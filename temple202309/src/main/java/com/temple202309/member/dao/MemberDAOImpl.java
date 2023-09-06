package com.temple202309.member.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.temple202309.member.vo.MemberVO;

@Repository // 현재 클래스를 dao bean으로 등록
public class MemberDAOImpl implements MemberDAO {

	private SqlSession sqlSession;
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sqlSession.selectOne("memberMapper.login", vo);
	}
}