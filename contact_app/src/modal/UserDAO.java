package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import connection.DBConnection;
import sessions.Session;

public class UserDAO {
	
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	private Connection connection;
	
	
	
	
	public Boolean Register(User user) {
		Boolean isRegister=false;
		connection= DBConnection.getConnection();
		try {
			pStmt = connection.prepareStatement("INSERT INTO user (username,password) VALUES (?,?) ;");
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPassword());
			int rowEff = pStmt.executeUpdate();
			if(rowEff > 0) {
				System.out.println("Register Successfully");
				isRegister=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error Register");
		}
		
	
		return isRegister;
		
	}
	

	
	public Boolean Login (String username, String password) {
		Boolean isLoginTrue = false;
		connection = DBConnection.getConnection();
		
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where username="+"'"+username+"'" + "AND password = " + password); 
			
			
			if(rs.next()) {
				
				
					isLoginTrue=true;
					Session.isUserIn=isLoginTrue;
					Session.currentUser=username;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isLoginTrue;
		
	}
}
