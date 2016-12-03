package smp.contacts.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import smp.contacts.entities.*;
import smp.contacts.model.dao.*;

@Component
public class ContactsOrmCreation implements CommandLineRunner {
	private static final int N_CONTACTS = 10;
	private static final int N_RANDOM = 100;
	@Autowired
	ContactOrm qualityOrm;

	@Override
	public void run(String... arg0) throws Exception {
		createContacts(qualityOrm);
	}

	private void createContacts(ContactOrm qualityOrm) {
		List<Contact> contacts = randomCreateContacts();
		for (int i=0; i<contacts.size(); i++){
			qualityOrm.addContact(contacts.get(i));
		}
	}

	private List<Contact> randomCreateContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		for (int i=0; i<N_CONTACTS; i++){
			contacts.add(createrandomContact());
		}
		return contacts;
	}

	private Contact createrandomContact() {
		Random gen = new Random();
		Contact contact = new Contact("firstname"+gen.nextInt(N_RANDOM), "lastname"+gen.nextInt(N_RANDOM),
				"company"+gen.nextInt(N_RANDOM), "position"+gen.nextInt(N_RANDOM), 
				genRandomAddress(), genRandomPhones(), genRandomEmails(), 
				"skype"+gen.nextInt(N_RANDOM), "comment"+gen.nextInt(N_RANDOM));
		return contact;
	}
	
	private Emails genRandomEmails() {
		Random gen = new Random();
		Emails emails = new Emails("email1"+gen.nextInt(N_RANDOM)+"@"+"gmail.com", null);
		return emails;
	}

	private Phones genRandomPhones() {
		Random gen = new Random();
		Phones phones = new Phones("054-"+gen.nextInt(999)+"-"+gen.nextInt(99)+"-"+gen.nextInt(99), 
				"077-"+gen.nextInt(999)+"-"+gen.nextInt(99)+"-"+gen.nextInt(99), 
				"054-"+gen.nextInt(999)+"-"+gen.nextInt(99)+"-"+gen.nextInt(99), null, null);
		return phones;
	}

	private static Address genRandomAddress() {
		Random gen = new Random();
		Address address = new Address(84000+gen.nextInt(999), "city"+gen.nextInt(N_RANDOM),
				"street"+gen.nextInt(N_RANDOM), ""+gen.nextInt(N_RANDOM), ""+gen.nextInt(N_RANDOM));
		return address;
	}


}
