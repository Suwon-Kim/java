package org.green.crudEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {
	
	@Autowired
	private CarService service;
	
	@RequestMapping("/")
	public String getAll(Model model) {		
		model.addAttribute("list", service.getAll());
		return "list";
	}
	
	@RequestMapping("/insertCar")
	public String insertCar() {
		return "insert";
	}
	
	@RequestMapping(value="/doInsertCar", method=RequestMethod.POST)
	public String doInsertCar(@ModelAttribute Car car) {
		service.insertCar(car);		
		return "redirect:/";
	}
}






