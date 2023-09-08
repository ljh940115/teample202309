package com.temple202309.mapper;

import com.temple202309.domain.MemberVO;

public interface MemberMapper {

	public MemberVO getMember(String userid);
	public int insertMember(MemberVO member);

}
