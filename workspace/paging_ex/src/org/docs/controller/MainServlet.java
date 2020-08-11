package org.docs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.docs.cmds.CMDFactory;
import org.docs.dao.DAOFactory;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	CMDFactory.init();
    	DAOFactory.initDB(config.getInitParameter("db_type"));
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doJob(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doJob(request, response);
	}
	
	private void doJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		if(cmd == null) {
			cmd = "getAll";
			PageInfo info = (PageInfo)session.getAttribute("pageInfo");
			if(info == null) {
				info = new PageInfo("list.jsp", false);
				session.setAttribute("pageInfo", info);
			}
		}
		
		CMDFactory.doAction(cmd, request, response);
		PageInfo info = (PageInfo)session.getAttribute("pageInfo");
		
		if(!info.isRedirect()) {
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
