package org.docs.cmds;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.docs.beans.Doc;
import org.docs.controller.PageInfo;
import org.docs.dao.DAOFactory;
import org.docs.dao.IDAO;

public class WriteCmd implements ICMD{
	@Override
	public void action(HttpServletRequest request , HttpServletResponse response) {
		String title = request.getParameter("d_title");
		String author = request.getParameter("d_author");
		String content = request.getParameter("d_content");
		
		Doc doc = new Doc(title, content, author);
		System.out.println(doc);
		IDAO dao = DAOFactory.getDAO();
		
		Connection con = dao.connect();
		int result = dao.writeDoc(con, doc);
		dao.disconnect(con);
		
		request.getSession().setAttribute("msg", result + "row Written!");
		PageInfo info = (PageInfo) request.getSession().getAttribute("pageInfo");
		info.setRedirect(true);
	}
}
