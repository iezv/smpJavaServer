package smp.contacts.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.*;

import smp.contacts.entities.Contact;
import smp.contacts.model.dao.ContactOrm;
import static smp.contacts.api.ContactsConstants.*;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
@RestController
public class ContactsOrmService {

	private static final String PACKAGE_CONTACT = "smp.contacts.entities.";
	@Autowired
	ContactOrm contactOrm;

	@RequestMapping(value = ADD_CONTACT, method = RequestMethod.POST)
	public String addContact(@RequestBody Map<String, Object> data) {
		try {
			Contact contact = (Contact) Class.forName(PACKAGE_CONTACT + "Contact").newInstance();
			try {
				contact.setData(data);
				System.out.println(data);
			} catch (IllegalArgumentException e) {
				return e.getMessage();
			}
			boolean res = contactOrm.addContact(contact);
			if (res == false)
				return "No added";
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return "Wrong Type of contact";
		}
		return "Success";
	}

	
	public static void main(String[] args) {
		SpringApplication.run(ContactsOrmService.class, args);
	}

}
