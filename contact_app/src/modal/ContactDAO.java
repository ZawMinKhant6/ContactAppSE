package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;

public class ContactDAO {
	
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	private Connection connection;
	
	private void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public Boolean saveContact(Contact contact) {
		Boolean isSave=false;
		connection= DBConnection.getConnection();
		try {
			pStmt = connection.prepareStatement("INSERT INTO contact (name,phone_number,sec_number) VALUES (?,?,?) ;");
			pStmt.setString(1, contact.getName());
			pStmt.setString(2, contact.getPhoneNumber());
			pStmt.setString(3, contact.getSecNumber());
			int rowEff = pStmt.executeUpdate();
			if(rowEff > 0) {
				System.out.println("Contact Save Successfully");
				isSave=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error Register");
		}
		
	
		return isSave;
	}
	
	public Boolean deleteContact(Long id) {
		Boolean isDel = false;
		Connection connection = DBConnection.getConnection();
		try {
			pStmt = connection.prepareStatement("DELETE from contact where id = ? ;");
			pStmt.setLong(1,id);
			int rowEff = pStmt.executeUpdate();
			if(rowEff > 0) {
				isDel=true;
				System.out.println("Delete Contact Successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDel;
		
	}
	
	public Contact getContactById(Long id) {
		connection = DBConnection.getConnection();
		Contact contact =null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM contact where id="+"'"+id+"'"); 
			
			
			if(rs.next()) {
				 contact = new Contact(rs.getString("name") , rs.getString("phone_number"),rs.getString("sec_number"),rs.getLong("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
		
	}
	
	public Boolean updateContact(Contact contact) {
		
		connection = DBConnection.getConnection();
		Boolean isUpdated =false;
		
		try {
			pStmt = connection.prepareStatement("UPDATE contact SET name = ?, phone_number = ?, sec_number = ? where  id = ?");
			pStmt.setString(1, contact.getName());
			pStmt.setString(2, contact.getPhoneNumber());
			pStmt.setString(3, contact.getSecNumber());
			pStmt.setLong(4, contact.getId());
			int rowEff = pStmt.executeUpdate();
			if(rowEff > 0) {
				isUpdated=true;
				System.out.println("Updated Successfuly");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Fail1");
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	public List<Contact> getAllContact(){
		List<Contact> contactList = new ArrayList<Contact>();
		connection = DBConnection.getConnection();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM contact");
			
			while(rs.next()) {
				contactList.add(new Contact(
					
					rs.getString("name"),
					rs.getString("phone_number"),
					rs.getString("sec_number"),
					rs.getLong("id")
					));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return contactList;
		
	}
}
