package com.temple202309.member.vo;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	//필드값
	private String userid;
	private String userpw;
	private String username;
	private String userphone;
	private String regdate;
	private String updatedate;

	//메서드
		//게터
	public String getUserid() {return userid;}
	public String getUserpw() {return userpw;}
	public String getUsername() {return username;}
	public String getUserphone() {return userphone;}
	public String getRegdate() {return regdate;}
	public String getUpdatedate() {return updatedate;}
		//세터
	public void setUserid(String userid) {this.userid = userid;}
	public void setUserpw(String userpw) {this.userpw = userpw;}
	public void setUsername(String username) {this.username = username;}
	public void setUserphone(String userphone) {this.userphone = userphone;}
	public void setRegdate(String regdate) {this.regdate = regdate;}
	public void setUpdatedate(String updatedate) {this.updatedate = updatedate;}
}
