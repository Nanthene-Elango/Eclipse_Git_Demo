package com.techM.ContactManager.ContactManagerApplication;

import java.util.Collection;
import java.util.HashMap;

public class ContactManager {

	HashMap<String , Contact> contactList = new HashMap<>();
	
	
	public void addContacts(String firstName , String lastName , String phoneNumber) {
		
		Contact contact = new Contact(firstName , lastName , phoneNumber);
		validateContact(contact);
		checkContactExist(contact);
		contactList.put(generateKey(contact), contact);
		
	}

	public String generateKey(Contact contact) {
		
		return String.format("%s-%s", contact.getFirstName() , contact.getLastName());
	}

	public void checkContactExist(Contact contact) {
		
		if (contactList.containsKey(generateKey(contact))) {
			throw new RuntimeException ("Contact already exist!");
		}
	}

	public void validateContact(Contact contact) {
		
		validateFirstName(contact.getFirstName());
		validateLastName(contact.getLastName());
		validatePhoneNumber(contact.getPhoneNumber());
	}
	
	public void validateFirstName(String firstName) {
		
		if (firstName == null || firstName.isBlank()) {
			throw new RuntimeException("first Name should not be empty!");
		}
		
	}

	public void validateLastName(String lastName) {
		
		if (lastName == null || lastName.isBlank()) {
			throw new RuntimeException("Last Name should not be empty!");
		}
		
	}

	public void validatePhoneNumber(String phoneNumber) {
		
		if (phoneNumber == null || phoneNumber.isBlank()) {
			throw new RuntimeException("Phone number should not be empty!");
		}
		
		
		if (phoneNumber.length() != 10) {
			throw new RuntimeException("phone number should be of length 10!");
		}
		
		if (!phoneNumber.matches("\\d+")) {
			throw new RuntimeException("phone number must contain only digits!");
		}
		
		if (phoneNumber.startsWith("0")) {
			throw new RuntimeException("phone number should not start with 0");
		}
	}

	public Collection<Contact> showContacts(){
		return contactList.values();
	}
}
