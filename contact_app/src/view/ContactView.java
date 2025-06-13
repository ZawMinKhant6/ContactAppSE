package view;

import java.util.List;
import java.util.Scanner;

import controller.ContactController;
import modal.Contact;

public class ContactView {
	
	ContactController contactController = new ContactController();
	Contact contact = new Contact();
	
	public void save(Scanner userInput) {
		System.out.println("Enter Name of the contact");
		String name = userInput.next();
		System.out.println("Enter Phone of the contact");
		String phone = userInput.next();
		userInput.nextLine();
		System.out.println("Enter Sec Phone of the contact");
		String secPhone = userInput.next();
		
		contact.setName(name);
		contact.setPhoneNumber(phone);
		contact.setSecNumber(secPhone);
		
		contactController.save(contact);
		
	}
	
	public void listContact(List<Contact> contactList) {
		
		
		if(!contactList.isEmpty()) {
			System.out.println("All Contact Data : " );
			System.out.println();
			
			for(final Contact contact:contactList) {
				
				showContact(contact);
				System.out.println();
			
			}
			
			
		
		}
		else {
			System.out.println("No Contacts is found");
		}
	}
	
	public void showContactByNames(Scanner userInput ) {
		System.out.println("Enter you search Name : ");
		userInput.nextLine();
		String charSeq= userInput.nextLine();
		List<Contact> contactList = contactController.getAllContact().stream().
				filter( (c) -> c.getName().toLowerCase().contains(charSeq)).toList();
		listContact(contactList);
	}
	
	public void showContact(Contact oldContact) {
		
		if(oldContact != null) {
			
			System.out.println(" Old name = "+ oldContact.getName());
			System.out.println(" Old number = "+ oldContact.getPhoneNumber());
			System.out.println(" Old sec Number = "+ oldContact.getSecNumber());
			
			
			
		}
		else {
			
			System.out.println("No such contact");
		}
	}
	
    public void update(Scanner userInput) {
    	System.out.println("Enter the contact Id you want to update : ");
    	Long oldId= userInput.nextLong();
    	Contact oldContact = contactController.getContactById(oldId);
    	showContact(oldContact);
		
    	if(oldContact != null) {
    		while(true) {
    			System.out.println("1.Name 2.First Number 3.Sec Number ");
    			int operation = userInput.nextInt();
    			
    			switch (operation) {
    			case 1 ->{
    				System.out.println("Name : ");
    				userInput.nextLine();
    				oldContact.setName(userInput.nextLine());
    			}
    			
    			case 2 ->{
    				System.out.println("First Number : ");
    				userInput.nextLine();
    				oldContact.setPhoneNumber(userInput.nextLine());
    				
    			}
    			
    			case 3 -> {
    				System.out.println("Sec Number : ");
    				userInput.nextLine();
    				oldContact.setSecNumber(userInput.nextLine());
    			}
    			default ->
    			throw new IllegalArgumentException("Unexpected value: " + operation);
    			}
    			System.out.println("Continue Update ? yes-y or no-n");
    			char decision = userInput.next().charAt(0);
    			
    			if(decision == 'n') {
    				
    				break;
    			}
    			
        	}
        	contactController.update(oldContact);
        	
    	}
    
		
    }
    
    public void contactList() {
		List<Contact> contactList = contactController.getAllContact();
		
		if(!contactList.isEmpty()) {
			System.out.println("All Movie Data : ");
			System.out.println();
			contactList.forEach((n) -> {;
				System.out.println("### Contact Id ### - " + n.getId());
				System.out.println("### Contact Name ### - " + n.getName());
				System.out.println("### Contact First Number ### - " + n.getPhoneNumber());
				System.out.println("### Contact Sec Number ### - " + n.getSecNumber());
				System.out.println();
				
			});
		}
	}
	
	public void Delete(Scanner userInput) {
		System.out.println("Enter contact Id to delete the contact");
		Long id = userInput.nextLong();
		contactController.delete(id);
	}
}
