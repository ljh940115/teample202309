package com.temple202309.member.controller;

import java.text.DateFormat; 
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.temple202309.common.base.BaseController;
import com.temple202309.main.HomeController;
import com.temple202309.member.service.MemberService;
import com.temple202309.member.vo.MemberVO;

@Controller("memberController")
@RequestMapping(value = "/member")
public class MemberControllerImpl extends BaseController implements MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {//ID와 PW를 Map에 저장
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(loginMap);//SQL문으로 전달
		if (memberVO != null && memberVO.getUserid() != null) {
			HttpSession session = request.getSession();
			session = request.getSession();
			session.setAttribute("isLogOn", true);//조회한 회원 정보를 isLogOn, true 설정
			session.setAttribute("memberInfo", memberVO);//memberInfo로 회원정보 저장

			String action = (String) session.getAttribute("action");//상품 주문 과정에서 로그인 했으면 주문 화면, 이외 메인 페이지 이동
			if (action != null && action.equals("/order/orderEachGoods.do")) {
				mav.setViewName("forward:" + action);
			} else {
				mav.setViewName("redirect:/home.jsp");
			}

		} else {
			String message = "아이디나 비밀번호가 틀립니다. 다시 로그인해주세요.";
			mav.addObject("message", message);
			mav.setViewName("/member/loginForm");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("memberInfo");
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/addMember.do", method = RequestMethod.POST)
	public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO _memberVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {//회원 가입창에서 전송된 회원 정보를 memberVO에 입력
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			memberService.addMember(_memberVO);//회원 정보 SQL문으로 전달
			message = "<script>";
			message += " alert('ȸ�� ������ ���ƽ��ϴ�.�α���â���� �̵��մϴ�.');";
			message += " location.href='" + request.getContextPath() + "/member/loginForm.do';";
			message += " </script>";

		} catch (Exception e) {
			message = "<script>";
			message += " alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
			message += " location.href='" + request.getContextPath() + "/member/memberForm.do';";
			message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	@Override
	@RequestMapping(value = "/overlapped.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String result = memberService.overlapped(id);//ID 중복 검사
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
}
