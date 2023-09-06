package com.temple202309.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple202309.member.dao.MemberDAO;
import com.temple202309.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO dao;

	@Override
	public MemberVO login(MemberVO mvo) throws Exception {
		return dao.login(mvo);
	}
	
}