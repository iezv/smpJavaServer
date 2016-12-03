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
	public boolean updateAddress(int id, Address address){
		Contact contact = em.find(Contact.class, id);
		if (contact==null)
			return false;
		contact.setAddress(address);
		return true;
	}
	
	@Transactional
	public Contact removeContact (int id){
		Contact res = em.find(Contact.class, id);
		if (em!=null) em.remove(res);
		return res;
	}
	
	
}
