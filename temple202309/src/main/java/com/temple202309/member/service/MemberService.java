package com.temple202309.member.service;

import java.util.Map; 

import com.temple202309.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(Map  loginMap) throws Exception;
	public void addMember(MemberVO memberVO) throws Exception;
	public String overlapped(String id) throws Exception;
}
