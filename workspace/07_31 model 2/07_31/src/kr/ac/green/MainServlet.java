package kr.ac.green;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doit(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc_kr");
		doit(request, response);
	}
	
	private void doit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		if(cmd == null) {
			cmd = "getAll";
		}
		boolean isRedirect = false;
		
		String nextPage = "list.jsp";
		if(cmd.equals("getAll")) {		
			CarDao dao = CarDao.getInstance();
			Connection con = dao.connect();
			Car[] list = dao.getAll(con);
			dao.disconnect(con);			
			request.setAttribute("list", list);
		} else if(cmd.equals("goInsert")) {
			nextPage = "insert.jsp";
		} else if(cmd.equals("insertCar")) {
			CarDao dao = CarDao.getInstance();
			Connection con = dao.connect();
			Car car = new Car();
			car.setCar_model(request.getParameter("car_model"));
			car.setCar_price(Integer.parseInt(request.getParameter("car_price")));
			car.setCar_desc(request.getParameter("car_desc"));
			int result = dao.insertCar(
				con, car				
			);
			dao.disconnect(con);
			
			System.out.println("insert result  : " + result);
			isRedirect = true;
		}
		if(isRedirect) {
			response.sendRedirect(request.getContextPath());
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}
}








