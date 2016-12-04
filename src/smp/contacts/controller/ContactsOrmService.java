package smp.contacts.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.*;
import smp.contacts.api.IdContact;
import smp.contacts.entities.*;
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
	
	@RequestMapping(value = UPDATE_CONTACT, method = RequestMethod.PUT)
	public String updateContact(@RequestBody IdContact idContact) {
		boolean res = contactOrm.updateContact(idContact.getId(),
				new Contact(idContact.getFirstname(), idContact.getLastname(), idContact.getCompany(),
						idContact.getPosition(), 
						new Address(idContact.getPostcode(), idContact.getCity(), idContact.getStreet(),
						idContact.getBld(), idContact.getAppart()), 
						new Phones(idContact.getPrime(), idContact.getWorkphone(), 
						idContact.getMobile(), idContact.getFax(), idContact.getOther()), 
						new Emails(idContact.getEmail1(), idContact.getEmail2()),
						idContact.getSkype(), idContact.getComment()));
		return res?"Update Success":"Contact not found with id:" + idContact.getId();
	}
	
	@RequestMapping (value = GET_CONTACT)
	public Map<String,Object> getContact( int id ){
		Map<String,Object> res = new LinkedHashMap<>();
		Contact contact = contactOrm.getContact(id);
		if(contact==null){
			res.put(STATUS, "error");
			res.put(DATA, "contact not found " + id);
		}
		else {
		   res.put(STATUS, "success");
		   res.put(DATA, contact);}
		return res;
	}
	
	@RequestMapping (value = DELETE_CONTACT)
	public Map<String,Object> deleteContact( int id ){
		Map<String,Object> res = new LinkedHashMap<>();
		Contact contact = contactOrm.removeContact(id);
		if(contact==null){
			res.put(STATUS, "error");
			res.put(DATA, "contact not found " + id);
		}
		else {
		   res.put(STATUS, "success");
		   res.put(DATA, contact);}
		return res;
		
	}
		
	public static void main(String[] args) {
		SpringApplication.run(ContactsOrmService.class, args);
	}

}
