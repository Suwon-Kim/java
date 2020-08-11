package org.docs.cmds;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.docs.beans.Doc;
import org.docs.controller.PageInfo;
import org.docs.dao.DAOFactory;
import org.docs.dao.IDAO;

public class GetAllCmd implements ICMD{
	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		IDAO dao = DAOFactory.getDAO();
		Connection con = dao.connect();
		
		int perPage = 3;
		
		int totalDocsCount = dao.getTotalCount(con);
		request.setAttribute("totalDocsCount", totalDocsCount);
		
		String temp = request.getParameter("pageNum");
		int pageNum = 1;
		if(temp != null) {
			pageNum = Integer.parseInt(temp);
		}
		request.setAttribute("pageNum", pageNum);
		
		Doc[] list = dao.getList(con, pageNum, 3);
		dao.disconnect(con);
		
// 페이지당 3개로 총 페이지 갯수를 구한다.
		int pageCount = totalDocsCount / perPage;
		// 보여줄 페이지 
		if(totalDocsCount % perPage > 0){
			pageCount++;
		}
		request.setAttribute("pageCount", pageCount);
		
		request.setAttribute("list", list);
		
		PageInfo info = (PageInfo) request.getSession().getAttribute("pageInfo");
		info.setRedirect(false);
		info.setBottom("list.jsp");
		
		
		
		}
}
