package smp.contacts.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Emails {
	String email1;
	String email2;	
		
	public Emails(String email1, String email2) {
		super();
		this.email1 = email1;
		this.email2 = email2;
	}

	public Emails() {
		super();
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	@Override
	public String toString() {
		return "Emails [email1=" + (email1==null?"null":email1) 
				+ ", email2=" + (email2==null?"null":email2) +  "]";
	}
	
	
	
	

}
