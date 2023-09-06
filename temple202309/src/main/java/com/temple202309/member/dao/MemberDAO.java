package com.temple202309.member.dao;

import com.temple202309.member.vo.MemberVO;

public interface MemberDAO {
	
	//로그인
	public MemberVO login(MemberVO mvo) throws Exception;
}
