package org.green.diTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired	//자동 연결 
	//@Qualifier("mySome") 이거 쓰는거 보다 변수명 바꿔주는게 훨씬 깔끔
	private Some yourSome;	//스프링에 등록되어 있는 빈 중에 Some 타입이 있는지 없는지를 검사 Some 타입이 하나만 있어야 함
	//some으로 걸러내고 변수명으로 한번더 걸러냄 

	@Autowired
	private Other obj;
	
	@Autowired
	private IAnimal myCat;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		myCat.cry();
		return "home";
	}
	
}
