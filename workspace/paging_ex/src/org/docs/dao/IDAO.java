package org.docs.dao;

import java.sql.Connection;

import org.docs.beans.Doc;

public interface IDAO {
	Connection connect();
	
	int writeDoc(Connection con, Doc doc);
	int deleteDoc(Connection con, int d_num);
	int updateDoc(Connection con, Doc doc);
	Doc[] getAll(Connection con);
	Doc getDocByID(Connection con, int d_num);
	
	Doc[] getList(Connection con, int pageNum, int docsPerPage);
	int getTotalCount(Connection con);
	
	void disconnect(Connection con);
}
