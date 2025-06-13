package main;

import java.util.Scanner;
import sessions.Session;
import view.ContactView;
import view.UserView;

public class Entry {
	
	private static final UserView userView= new UserView();
	private static final ContactView contactView = new  ContactView();
	
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
				userView.Login(userInput);
				operations : while(Session.isUserIn) {
					System.out.println("1.Save 2.Delete 3.Update 4.List 5.Search By Names 6.Close App");
					int choice = userInput.nextInt();
					
					switch (choice) {
					case 1 -> contactView.save(userInput);
					case 2-> contactView.Delete(userInput);
					case 3-> contactView.update(userInput);
					case 4-> contactView.contactList();
					case 5-> contactView.showContactByNames(userInput);
					case 6-> {
						System.out.println("Closing App --- ");
						break Main;
					}
					
					
					default ->
					throw new IllegalArgumentException("Unexpected value: " + choice);
					}
					
				}
				
			
				
			}
			
			
			case 2 -> {
				System.out.println("Quiting Done ... ");
				break Main;
			}
			default ->
			throw new IllegalArgumentException("Unexpected value: " + userChoice);
			}
			
		}
	}
	
	

}
