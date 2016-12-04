package smp.contacts.entities;

import java.util.Map;
import javax.persistence.*;
import static smp.contacts.api.ContactsConstants.*;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	int id;
	
	String firstname;
	String lastname;
	String company;
	String position;
	
	@Embedded
	Address address;
	
	@Embedded
	Phones phones;
	
	@Embedded
	Emails emails;
	
	String skype;
	String comment;
	
	public Contact(String firstname, String lastname, String company, String position, Address address, Phones phones,
			Emails emails, String skype, String comment) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.company = company;
		this.position = position;
		this.address = address;
		this.phones = phones;
		this.emails = emails;
		this.skype = skype;
		this.comment = comment;
	}

	public Contact() {
		super();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phones getPhones() {
		return phones;
	}

	public void setPhones(Phones phones) {
		this.phones = phones;
	}

	public Emails getEmails() {
		return emails;
	}

	public void setEmails(Emails emails) {
		this.emails = emails;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + 
				", company=" + (company==null?"null":company) + ", position=" 
				+ (position==null?"null":position) + ", address=" + address + ", phones=" + phones.prime 
				+ ", emails=" + emails.email1 + ", skype=" + (skype==null?"null":skype) 
				+ ", comment=" + (comment==null?"null":comment) + "]";
	}

	public void setData(Map<String,Object>data) throws IllegalArgumentException {
		if( data==null ) 
			new IllegalArgumentException("Data is null");
		try {
			if( id==0 ) {
				Integer Id=(Integer) data.get(ID);
				if ( Id!=0 ) 
					id = Id;
			}
			firstname = (String) data.get( FIRSTNAME );
			lastname = (String) data.get( LASTNAME );
			company = (String) data.get( COMPANY );
			position = (String) data.get( POSITION );
			skype = (String) data.get( SKYPE );
			comment = (String) data.get( COMMENT );
			Integer postcode = (Integer) data.get( POSTCODE );	
			String street = (String) data.get( STREET );
			String city = (String) data.get( CITY );
			String bld = (String) data.get( BUILDING );
			String appart = (String) data.get( APPARTMENT );
			address = new Address(postcode==null?0:postcode, city==null?"null":city, 
					street==null?"null":street, bld==null?"null":bld, appart==null?"null":appart);
			String prime = (String) data.get( PRIME );
			String  workphone = (String) data.get( WORKPHONE );
			String  mobile = (String) data.get( MOBILE );
			String  fax = (String) data.get( FAX );
			String other = (String) data.get( OTHER );
			phones = new Phones(prime, workphone, mobile, fax, other);
			String email1 = (String) data.get( EMAIL1 );
			String email2 = (String) data.get( EMAIL2 );
			emails = new Emails(email1, email2);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong data in the map");
		}	
	}

}
