package org.docs.dao;

public class DAOFactory {
	private static String db_type;
	
	public static void initDB(String db_type) {
		DAOFactory.db_type = db_type;
	}
	
	public static IDAO getDAO() {
		if(db_type.equals("mysql")) {
			return MySQLDocsDAO.getInstance();
		}
		return null;
	}
}
