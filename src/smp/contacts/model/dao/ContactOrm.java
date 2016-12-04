package smp.contacts.model.dao;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import smp.contacts.entities.*;

public class ContactOrm {

	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
	EntityManager em;

	@Transactional
	public boolean addContact(Contact contact) {
		if (em.find(Contact.class, contact.getId()) != null)
			return false;
		em.persist(contact);
		return true;
	}
	
	@Transactional
	public Contact removeContact (int id){
		Contact res = em.find(Contact.class, id);
		if (res!=null) em.remove(res);
		return res;
	}
	@Transactional
	public boolean updateContact(int id, Contact contact) {
		Contact res = em.find(Contact.class, id);
		if (res==null) 
			return false;
		res.setFirstname(contact.getFirstname());
		res.setLastname(contact.getLastname());
		res.setCompany(contact.getCompany());
		res.setComment(contact.getComment());
		res.setPosition(contact.getPosition());
		res.setAddress(contact.getAddress());
		res.setEmails(contact.getEmails());
		res.setPhones(contact.getPhones());
		res.setSkype(contact.getSkype());
		return true;
	}

	public Contact getContact(int id) {
		return em.find(Contact.class, id);
	}

	
}
