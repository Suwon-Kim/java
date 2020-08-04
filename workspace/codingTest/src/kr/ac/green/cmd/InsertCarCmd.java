package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.AdvancedCarDao;
import kr.ac.green.Car;

public class InsertCarCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		AdvancedCarDao dao = AdvancedCarDao.getDao();
		Connection con = dao.connect();
		Car car = new Car();
		car.setCar_model(request.getParameter("car_model"));
		car.setCar_price(Integer.parseInt(request.getParameter("car_price")));
		car.setCar_desc(request.getParameter("car_desc"));
		int result = dao.insertCar(
			con, car				
		);
		dao.disconnect(con);
		request.setAttribute("nextPage", request.getContextPath());
		request.setAttribute("isRedirect", true);
	}
	
}
