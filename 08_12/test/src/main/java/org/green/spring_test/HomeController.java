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
	 * ��� ���� ������ �Ǵ°�? 
	 * @PathVariable("myValue") ����� �����غ��� �ȵ� ���Ŵ� ������ �ȵ�
	 * �Ķ���ͷ� �����°Ŷ� ������ �� �� ���� ������ �Ķ���� ������ myValue�̸� ������ �ȵ� 
	 */
	@RequestMapping("/a/b/{myValue}")
	public String pathVariable(@PathVariable("myValue") String myValue) {
		System.out.println(myValue);
		return "other";
	}
	
	//String, void ModelAndView ���� Ÿ�Ը� �ϴ� �˾Ƴ��� 
	// -- ���� ���� 
	/*
	 * String : view �̸� ����
	 * ModelAndView : model + view
	 * void : URL���� ���̸��� ���� (RequestToViewResolver)
	 * View
	 * RedirectView 
	 */
	
	@RequestMapping(value = "/empty")
	public void emptyAction() {	 //viewName -- > empty 
		//void�� empty�� ���� 
	}
	/*
	 * - parameter ����
	 * request, response, session,  application�� �� ���� , OutputStream/Writer ���� ������ ���� 
	 * RequestParam("�Ķ���� �̸�(inputValue)")
	 * RequestParam("value = "�Ķ�����̸�", required = false, default = 1);//������ 1 �־�
	 * ModelAttribute("�Ӽ��̸�")
	 * CookieValue("��Ű�̸�")
	 * PathVariable("myValue") = ��û URL�� /a/b/what �϶� myValue - > what 
	 * ����¡�� �� �� �ִ� ����� ���� �ƴ�
	 */
	@RequestMapping(value =" /userInfo" , method = RequestMethod.POST)
	public String makeUser(User some, @CookieValue("what") String what) {
		System.out.println(some);
		return "other";
	}
	
	@RequestMapping(value = "/formData", method = RequestMethod.POST)
	public String parameterProcess(String inputValue) {
		//inputValue ã�Ƽ� param�� ��� �־��� ��
		//@RequestParam("inputValue") �����ϰ� param�� �̸��� ������ ���� ������
		System.out.println(inputValue);
		return "redirect:start";
	}
	
//	@RequestMapping(value = "/userInfo" ,method = RequestMethod.POST)
//	public String makeUser(String userName, int userAge) {//�ڵ����� ����ȯ���� ���� userAge
//		User user = new User();
//		user.setUserName(userName);
//		user.setUserAge(userAge);
//		System.out.println(user);
//		return "redirect:start";
//	}
	
	@RequestMapping(value = "/userInfo" ,method = RequestMethod.POST)
	public String makeUser(@ModelAttribute User user) {	//Ÿ�� ù���ڸ� �ҹ��ڷ� �ٲ� �̸��̿��� �Ѵ�
		//���࿡ �ٸ� ���� �̸����� ���� �ʹٸ�  @ModelAttribute ("otherUser")��� ���� jsp���� otherUser�� 
		//����ϸ� ����� �ȴ�. @ModelAttribute �����ؼ� �� �� �ִ�. ��ſ� �̸��� jsp�Ӽ��� ��ġ�ؾ���.
		//�Ӽ����ٰ� �־��ش� user�� 
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
//	//������ ���� ������ ���� �شٰ� ..
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView start(ModelAndView mav) {
//		mav.setViewName("hello");
//		�ؿ����� ���� ��//request.setAttribute("some", "other")
//		mav.addObject("some", "other");
//		return mav;
//	}
	//2���� ó���Ѵ�..
	@RequestMapping(value = {"/", "/start"}, method = RequestMethod.GET)
	public String start(Model model) {
		model.addAttribute("some", "other");
		return "hello";
	}
	//https://mvnrepository.com/
}
