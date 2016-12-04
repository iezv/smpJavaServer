package smp.contacts.test.client;

import org.springframework.web.client.RestTemplate;
import static smp.contacts.api.ContactsConstants.*;
import smp.contacts.api.*;
import smp.contacts.entities.Contact;

public class OrmContactClient {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		final String URL = "http://localhost:8080/";
		
		// 1 - Add Contact
		IdContact newContact = 
				new IdContact("Vasya", "Pupkin", "RogaAndKopita", "Starshiy podmetala", "skype", "no comment", 84000, "Kiev",
						"Peonerov", "13/10", "25", "newemail1", null, "054-555-55-55", null, "054-555-55-55", null, null);
		String contSt = restTemplate.postForObject(URL+ADD_CONTACT,newContact,String.class);
		System.out.println(contSt);
		
	    // 2 - UPDATE CONTACT
		IdContact uppContact = 
				new IdContact(1,"Petya", "Cheburaskin", "RogaAndKopita", "Starshiy podmetala", "skype", "no comment", 84000, "Kiev",
						"Peonerov", "13/10", "25", "newemail1", "123", "054-555-55-55", "123", "054-555-55-55", "123", "123");
		restTemplate.put(URL+UPDATE_CONTACT, uppContact);
		System.out.println("Update Success");
		
		// 3 - GET CONTACT
		restTemplate.getForObject(URL+GET_CONTACT +"?id=6", IdContact.class);
						
		// 4- DELETE
			restTemplate.delete(URL+DELETE_CONTACT+"?id=8");
			System.out.println("Delete Success");
	}
		

}
