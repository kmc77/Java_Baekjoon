package ContentCategory.DB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ContentCategoryDAO {
	
	private DataSource ds;
	int result = 0;
	public ContentCategoryDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
		}
	}
	public ContentCategoryBean getCategoryList() {
		
		return null;
	}
	
	


}