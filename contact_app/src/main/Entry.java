package main;

import java.util.Scanner;

public class Entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operate();
	}
	
	
	static public void Operate() {
		System.out.println("--- Contact App ---");
		
		Main : while(true) {
			Scanner userInput= new Scanner(System.in);
			System.out.println("1.Login 2.Quite");
			int userChoice= userInput.nextInt();
			
			switch (userChoice) {
			case 1 ->
			
			{
				System.out.println("1.Save 2.Delete 3.Update 4.List");
				int choice = userInput.nextInt();
				
				switch (choice) {
				case 1 -> {}
				
				
				
				default ->
				throw new IllegalArgumentException("Unexpected value: " + choice);
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

}
