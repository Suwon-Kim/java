package org.green.spring_test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/callTodo")	//get���� ������ post�� ������ ������� ���� ó���ϰڴ�. 
//	public String todo() {
//		return "result";	//forward �ϰ� �ȴ�.
//	}
	
	//redirect�� ��� �ұ�?
	public String todo() {
		return "redirect:redirectCall";	//redirectCall�� redirect��
	}
	@RequestMapping("/redirectCall")	//jsp ��ġ�� wdb-inf�ؿ� �־ forward�� ���ؼ� �� �� �ִ�.
	public String redirectCall() {
		return "redirect";
	}
	
	//
}
