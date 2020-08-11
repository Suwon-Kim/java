package org.docs.cmds;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.docs.controller.PageInfo;
import org.docs.dao.DAOFactory;
import org.docs.dao.IDAO;

public class DeleteCmd implements ICMD {
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		int d_num = Integer.parseInt(request.getParameter("d_num"));
		
		IDAO dao = DAOFactory.getDAO();
		Connection con = dao.connect();
		int result = dao.deleteDoc(con, d_num);
		dao.disconnect(con);
		
		request.getSession().setAttribute("msg", result + "row(s) deleted!");
		PageInfo info = (PageInfo) request.getSession().getAttribute("pageInfo");
		info.redirect = true;
	}
}
