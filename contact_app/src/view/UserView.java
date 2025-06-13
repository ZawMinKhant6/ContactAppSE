package view;

import java.util.Scanner;

import controller.UserController;
import modal.User;

public class UserView {
	
	User user = new User();
	UserController userController = new UserController();
	
	
	public UserView() {
		
	}
	
	public Boolean Register(Scanner userInput) {
		
		System.out.println("Enter username : ");
		String name = userInput.next();
		System.out.println("Enter password : ");
		String password = userInput.next();
		user.setName(name);
		user.setPassword(password);
		return userController.Register(user);
		
		
		
	}
	
	public Boolean Login(Scanner userInput) {
		
		System.out.println("Login -- Enter Username --- ");
		String name = userInput.next();
		System.out.println("Enter password : ");
		String password = userInput.next();
		return userController.Login(name, password);
				
	}
}
