package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static public Connection getConnection() {
			String dbPath = "jdbc:mysql://localhost:3306/contactdb?useSSL=false";
			String user = "root";
			String password ="1234";
			Connection con = null;
					
					try {
						con = DriverManager.getConnection(dbPath, user, password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Connection Error");
						e.printStackTrace();
					}
					
					return con;
			
	}
}	
