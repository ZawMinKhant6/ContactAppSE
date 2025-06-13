package controller;

import modal.Contact;
import modal.ContactDAO;

public class ContactController {

	ContactDAO contactDAO = new ContactDAO();
	
	public Boolean save(Contact contact) {
		return contactDAO.saveContact(contact);
	}
	
	public Boolean delete(Long id) {
		return contactDAO.deleteContact(id);
	}
	
	public Contact getContactById(Long id) {
		return contactDAO.getContactById(id);
	}
	
	public Boolean update(Contact contact) {
		return contactDAO.updateContact(contact);
	}
}
