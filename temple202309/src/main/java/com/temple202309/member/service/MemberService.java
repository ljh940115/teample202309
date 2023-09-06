package com.temple202309.member.service;

import javax.servlet.http.HttpSession;  
import com.temple202309.member.vo.MemberVO;

public interface MemberService {
	
	public MemberVO login(MemberVO mvo) throws Exception;

}