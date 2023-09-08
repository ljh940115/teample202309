package com.temple202309.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temple202309.domain.MemberVO;
import com.temple202309.mapper.MemberMapper;

@Controller
public class MemberController {
	
		@Autowired
		MemberMapper memberMapper;
		
		@RequestMapping("/login/isLogin")
		public String isLogin() {
			return "login/isLogin";
		}
		
		@GetMapping("/login/login")
		public String loginGet() {
			return "login/login";
		}
		@PostMapping("/login/login")
		public String loginPost(String userid, String userpw, HttpSession session) {
			//id, pw는 사용자가 입력한 id와 pw
			MemberVO member=memberMapper.getMember(userid);
			if(member==null) return "redirect:/login/login";
			else { //id는 맞음
				if(!member.getUserpw().equals(userpw)) { //비밀번호는 틀림
					 return "redirect:/login/login";
				}else { //비밀번호도 맞음
					session.setAttribute("MEMBER", member);
					return "redirect:/login/isLogin";
				}
			}
		}
		
		
		@RequestMapping("/login/logout")
		public String logout(HttpSession session) {
			session.removeAttribute("MEMBER");
			return "redirect:/login/isLogin";
		}
		
		
		@RequestMapping("/login/memberForm")
		public String memberForm() {
			return "login/memberForm";
		}
		
		@RequestMapping("/login/memberRegist")
		public String memberRegist(MemberVO member) {
			memberMapper.insertMember(member);
			return "home";
		}
}
