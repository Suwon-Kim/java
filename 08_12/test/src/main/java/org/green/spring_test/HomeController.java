package org.green.spring_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	/*
	 * /a/b/what
	 * myValue - > what 
	 * 얘는 과연 생략이 되는가? 
	 * @PathVariable("myValue") 지우고 실행해보면 안됨 저거는 생략이 안됨
	 * 파라미터로 들어오는거랑 구분을 할 수 없기 때문에 파라미터 네임이 myValue이면 구분이 안됨 
	 */
	@RequestMapping("/a/b/{myValue}")
	public String pathVariable(@PathVariable("myValue") String myValue) {
		System.out.println(myValue);
		return "other";
	}
	
	//String, void ModelAndView 리턴 타입만 일단 알아놓자 
	// -- 리턴 종류 
	/*
	 * String : view 이름 리턴
	 * ModelAndView : model + view
	 * void : URL에서 뷰이름을 구함 (RequestToViewResolver)
	 * View
	 * RedirectView 
	 */
	
	@RequestMapping(value = "/empty")
	public void emptyAction() {	 //viewName -- > empty 
		//void는 empty를 따라감 
	}
	/*
	 * - parameter 종류
	 * request, response, session,  application은 못 구함 , OutputStream/Writer 말고도 굉장히 많음 
	 * RequestParam("파라미터 이름(inputValue)")
	 * RequestParam("value = "파라미터이름", required = false, default = 1);//없으면 1 넣어
	 * ModelAttribute("속성이름")
	 * CookieValue("쿠키이름")
	 * PathVariable("myValue") = 요청 URL이 /a/b/what 일때 myValue - > what 
	 * 페이징에 쓸 수 있다 쓰라는 말은 아님
	 */
	@RequestMapping(value =" /userInfo" , method = RequestMethod.POST)
	public String makeUser(User some, @CookieValue("what") String what) {
		System.out.println(some);
		return "other";
	}
	
	@RequestMapping(value = "/formData", method = RequestMethod.POST)
	public String parameterProcess(String inputValue) {
		//inputValue 찾아서 param에 잡아 넣어라는 뜻
		//@RequestParam("inputValue") 생략하고 param에 이름이 같으면 생략 가능함
		System.out.println(inputValue);
		return "redirect:start";
	}
	
//	@RequestMapping(value = "/userInfo" ,method = RequestMethod.POST)
//	public String makeUser(String userName, int userAge) {//자동으로 형변환까지 해줌 userAge
//		User user = new User();
//		user.setUserName(userName);
//		user.setUserAge(userAge);
//		System.out.println(user);
//		return "redirect:start";
//	}
	
	@RequestMapping(value = "/userInfo" ,method = RequestMethod.POST)
	public String makeUser(@ModelAttribute User user) {	//타입 첫글자를 소문자로 바꾼 이름이여야 한다
		//만약에 다른 변수 이름으로 쓰고 싶다면  @ModelAttribute ("otherUser")라고 쓰고 jsp에서 otherUser를 
		//출력하면 출력이 된다. @ModelAttribute 생략해서 쓸 수 있다. 대신에 이름을 jsp속성과 일치해야함.
		//속성에다가 넣어준다 user를 
		System.out.println(user);
		return "other";
	}
		
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView start(ModelAndView mav, HttpServletRequest request) {
//		//request.setAttribute("some", "other");
//		//
//		mav.setViewName("hello");
//		return mav;
//	}
//	//정보랑 다음 페이지 같이 준다고 ..
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView start(ModelAndView mav) {
//		mav.setViewName("hello");
//		밑에꺼랑 같은 말//request.setAttribute("some", "other")
//		mav.addObject("some", "other");
//		return mav;
//	}
	//2개로 처리한다..
	@RequestMapping(value = {"/", "/start"}, method = RequestMethod.GET)
	public String start(Model model) {
		model.addAttribute("some", "other");
		return "hello";
	}
	//https://mvnrepository.com/
}
