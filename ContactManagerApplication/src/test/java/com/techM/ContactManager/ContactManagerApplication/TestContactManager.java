package com.techM.ContactManager.ContactManagerApplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TestContactManager {

	ContactManager obj;
	
	
	@BeforeEach
	void setUp() throws Exception {
		obj = new ContactManager();
		obj.addContacts("Nanthene",  "Elango" , "9487381354");
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("Test for validate for first name")
	class TestValidateFirstName{
		
		@Test
		@DisplayName("Test to validate for null first name")
		void testNullFirstName() {
			assertThrows(RuntimeException.class , ()->obj.validateFirstName(null) , "it should throw a runtime exception");
		}
		
		@Test
		@DisplayName("Test to validate for empty first name")
		void testEmptyFirstName() {
			assertThrows(RuntimeException.class , ()->obj.validateFirstName("") , "it should throw a runtime exception");
		}
	}
	
	@Nested
	@DisplayName("Test to validate for last name")
	class TestValidateLastName{
		
		@Test
		@DisplayName("Test to validate for null last name")
		void testNullLastName() {
			assertThrows(RuntimeException.class , ()->obj.validateLastName(null) , "it should throw a runtime exception");
		}
		
		@Test
		@DisplayName("Test to validate for empty last name")
		void testEmptyLastName() {
			assertThrows(RuntimeException.class , ()->obj.validateLastName("") , "it should throw a runtime exception");
		}
	}
	
	@Nested
	@DisplayName("Test to validate for phone number")
	class testValidatePhoneNumber{
		
		@Test
		@DisplayName("Test to validate for null phone number")
		void testNullPhoneNumber() {
			assertThrows(RuntimeException.class , ()->obj.validatePhoneNumber(null) , "it should throw a runtime exception");
		}
		
		@Test
		@DisplayName("Test to validate for empty Phone number")
		void testEmptyPhoneNumber() {
			assertThrows(RuntimeException.class , ()->obj.validatePhoneNumber("") , "it should throw a runtime exception");
		}
		
		@Test
		@DisplayName("test to validate the length of phone number")
		void testPhoneNumberLength() {
			assertThrows(RuntimeException.class , ()->obj.validatePhoneNumber("82781729197") , "it should throw a runtime exception");
		}
		
		@Test
		@DisplayName("test to validate the values of phone number")
		void testPhoneNumberValues() {
			assertThrows(RuntimeException.class , ()->obj.validatePhoneNumber("7&afgr4B90") , "it should throw a runtime exception");
		}
		
		@Test
		@DisplayName("test to validate the phone number start value")
		void testPhoneNumberStart() {
			assertThrows(RuntimeException.class , ()->obj.validatePhoneNumber("0123456789") , "it should throw a runtime exception");
		}
	}
	
	@Nested
	@DisplayName("test add contacts method")
	class testAddContacts{
		
		@Test
		@DisplayName("Test to add contacts with null first name")
		void testNullFirstName() {
			
			assertThrows(RuntimeException.class , ()->obj.addContacts(null, "joe", "1234567890"));
		}

		@Test
		@DisplayName("Test to add contacts with null last name")
		void testNullLastName() {
			
			assertThrows(RuntimeException.class , ()->obj.addContacts("john", "", "1234567890"));
		}
		
		@Test
		@DisplayName("Test to add contacts with invalid phone number")
		void testInvalidPhoneNumber() {
			
			assertThrows(RuntimeException.class , ()->obj.addContacts("john", "joe", "123&J5-890"));
		}
	
		@Test
		@DisplayName("Test for duplicate contacts")
		void testDuplicateContacts() {
			assertThrows(RuntimeException.class , ()->obj.addContacts("Nanthene", "Elango", "9487381354"));
		}
		
		@Test
		@DisplayName("test contacts added or not")
		void testContactsAddedOrNot() {
			
			obj.addContacts("Sakthi" , "Sowmya" , "1234567890");
			obj.addContacts("Effath", "jaan", "1234567890");
			obj.addContacts("harshini", "MB", "1234567890");
			
			assertEquals(4 , obj.showContacts().size());
		}
	}
	
	@Test
	@DisplayName("Test contact already exist or not")
	void testContactExistAlready() {
		assertThrows(RuntimeException.class , ()->obj.checkContactExist(new Contact("Nanthene" , "Elango" , "1234567890")));
	}
	
}

