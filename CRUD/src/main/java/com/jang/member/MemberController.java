package com.jang.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "login";
	} 
	
	// 로그인
	@RequestMapping(value="/login_check", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession,
			@RequestParam("mem_id")String mem_id,
			@RequestParam("mem_pw")String mem_pw
			) throws IOException {
		
		System.out.println(mem_id);
		System.out.println(mem_pw);
	
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("mem_id", mem_id);
		map.put("mem_pw", mem_pw);
			
		Member am = memberService.memberLogin(map);
		
		if(am != null){  //로그인 성공
			//세션에 아이디와 이름을 넣는다
			httpSession.setAttribute("am_id", am.getMem_id());
			httpSession.setAttribute("am_name", am.getMem_name());
					
//			return "redirect:main";
//			String s_url = (String)httpSession.getAttribute("s_url");
			return "redirect:home";
			
		}else{//로그인 실패하면 null
			//주소창의 변화는 없다 디스패쳐처럼
			//return "login";
			//로그인실패시 경고창
//			System.out.println("null임");
//				response.setContentType("text/html; charset=EUC-KR");
//				PrintWriter out = response.getWriter();
//				out.println("<script>alert('아이디 또는 비밀번호를 다시 확인하세요.'); history.go(-1);</script>");
//				out.flush();

			//a태그 이동처럼 주소를 먼저 바꾸고 이동
		return "redirect:loginForm";

		}	
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogout(HttpSession httpSession){
		
//		String s_url = (String)httpSession.getAttribute("s_url");
		
		httpSession.invalidate();
		
		return "redirect:home";
	}
	
//	@RequestMapping("/loginOk")
//	public String loginOk(HttpSession httpSession, 
//				@ModelAttribute Member member
//			) {
//		
//		Member ret = memberService.loginCheck(member);
//		
//		if(ret == null) {
//			return "redirect:loginForm";
//		}else {
//			String mem_id = null; 
//			String mem_pw = null;
//			
//			httpSession.setAttribute("_mem_id", mem_id);
//			httpSession.setAttribute("_mem_pw", mem_pw);
//		
//		return "redirect:home";
//		}
//	}
	  
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "join";
	}
	
	@RequestMapping("/joinCheck")
	public String joinCheck() {
		
		
		return "join";
	}
	
	//회원가입시 아이디 중복확인
	@RequestMapping(value="/app_checkid", 
			method={ RequestMethod.GET, RequestMethod.POST},produces = "application/json")  //앱의 99%로는 이렇게되어있음
	public @ResponseBody HashMap<String, String> getCheckId( 		
			@RequestParam("mem_id") String mem_id,
			HttpServletResponse response) {
		
		//웹 개발할때 크로스 도메인 문제 해결
		 response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		 response.setHeader("Access-Control-Max-Age", "3600");
		 response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setContentType("application/json");
		 response.setCharacterEncoding("EUC-KR");
	 
		HashMap<String, String> map = new HashMap<String, String>();
		int ret = memberService.getCheckId(mem_id);
		System.out.println(ret);
		if(ret == 1){
			map.put("ret", "y"); //{"ret":"y"} 
		} else {
			map.put("ret", "n"); //{"ret":"n"}
		}
		
		return map;
	}
	
	@RequestMapping("/insertJoin")
	public String insertJoin(
				@ModelAttribute Member member
			) {
		
		memberService.insertBoard(member);
		
//		String id = "d";
//		String pw = "1";
//		
//		String url = null;
//		if(id.equals(pw)) {
//			url = "redirect:home";
//		} else { 
//			url = "joinForm";
//		}
//		
//		return url;
		
		return "redirect:loginForm";
	}
}
