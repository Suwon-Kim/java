package org.green.spring_test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/callTodo")	//get으로 들어오든 post로 들어오든 상관없이 쟤를 처리하겠다. 
//	public String todo() {
//		return "result";	//forward 하게 된다.
//	}
	
	//redirect는 어떻게 할까?
	public String todo() {
		return "redirect:redirectCall";	//redirectCall로 redirect함
	}
	@RequestMapping("/redirectCall")	//jsp 위치가 wdb-inf밑에 있어서 forward를 통해서 갈 수 있다.
	public String redirectCall() {
		return "redirect";
	}
	
	//
}
