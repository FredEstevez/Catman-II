package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectadb {
	
	private final String URL = "jdbc:sqlite:E:\\Eclipse\\workspace_eclipse\\catman2\\Catman-main\\src\\CATMAN.db";
	private final String DRIVER = "org.sqlite.JDBC";
	
	
	public Connection conexionDB() throws SQLException{
		Connection c = null;
		
		try {
			try {
				Class.forName(DRIVER).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c = DriverManager.getConnection(URL);
		}catch ( SQLException e ) {
			throw new SQLException(e.getMessage());
		}
		
	return c;	
	}



	
}
