package com.temple202309.member.controller;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.temple202309.member.service.MemberService;
import com.temple202309.member.vo.MemberVO;

@Controller
@RequestMapping("/member/**")
public class MemberController {
		
	@Autowired
	private MemberService service;
	
	@GetMapping("login.do")
	public void getSelectOne() throws Exception{}
	
	@PostMapping("login.do")
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		
		return "redirect:/member/loginForm";
	}

}
