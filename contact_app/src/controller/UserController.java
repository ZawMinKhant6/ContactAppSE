package controller;

import modal.User;
import modal.UserDAO;

public class UserController {
	
	UserDAO userDAO=new UserDAO();
	
	public Boolean Register(User user) {
		Boolean isRegistered= userDAO.Register(user);
		return isRegistered;
	}
	
	public Boolean Login (String username, String password) {
		Boolean isLogin= userDAO.Login(username, password);
		return isLogin;
	}
}
