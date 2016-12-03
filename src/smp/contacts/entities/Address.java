package smp.contacts.entities;

import javax.persistence.Embeddable;
@SuppressWarnings("serial")
@Embeddable
public class Address {
	Integer postcode;
	String city;
	String street;
	String bld;
	String appart;
	
	public Address(int postcode, String city, String street, String bld, String appart) {
		super();
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.bld = bld;
		this.appart = appart;
	}

	public Address() {
		super();
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBld() {
		return bld;
	}

	public void setBld(String bld) {
		this.bld = bld;
	}

	public String getAppart() {
		return appart;
	}

	public void setAppart(String appart) {
		this.appart = appart;
	}

	@Override
	public String toString() {
		return "Address [postcode=" + (postcode==null?"null":postcode) + ", city=" + (city==null?"null":city) +
				                 ", street=" + (street==null?"null":street) + ", bld=" + (bld==null?"null":bld) + 
				                 ", appart=" + (appart==null?"null":appart) + "]";
	}
	
}
