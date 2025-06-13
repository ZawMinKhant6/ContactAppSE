package main;

import java.util.Scanner;


import sessions.Session;
import view.UserView;

public class Entry {
	
	private static final UserView userView= new UserView();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operate();
	}
	
	
	static public void Operate() {
		System.out.println("--- Contact App ---");
		
		Main : while(true) {
			Scanner userInput= new Scanner(System.in);
			System.out.println("0.Register 1.Login 2.Quite");
			int userChoice= userInput.nextInt();
			
			switch (userChoice) {
			
			case 0 ->  {
				if(userView.Register(userInput)) {			
					continue;
				}
			}
			case 1 ->
			
			 {
				 
				System.out.println("Login To Your acc");
				if(userView.Login(userInput)) {
					System.out.println("1.Save 2.Delete 3.Update 4.List");
					int choice = userInput.nextInt();
					
					switch (choice) {
					case 1 -> {}
					
					
					
					default ->
					throw new IllegalArgumentException("Unexpected value: " + choice);
					}
				}
			
				
			}
			
			
			case 2 -> {
				System.out.println("Quiting");
				break Main;
			}
			default ->
			throw new IllegalArgumentException("Unexpected value: " + userChoice);
			}
			
		}
	}
	
	static public Boolean userMiddleware() {
		return Session.isUserIn;
	}

}
