package org.green.diTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired	//�ڵ� ���� 
	//@Qualifier("mySome") �̰� ���°� ���� ������ �ٲ��ִ°� �ξ� ���
	private Some yourSome;	//�������� ��ϵǾ� �ִ� �� �߿� Some Ÿ���� �ִ��� �������� �˻� Some Ÿ���� �ϳ��� �־�� ��
	//some���� �ɷ����� ���������� �ѹ��� �ɷ��� 

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
