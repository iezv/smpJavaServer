package smp.contacts.api;

public class IdContact {
    int id;
	String firstname;
	String lastname;
	String company;
	String position;
	String skype;
	String comment;
	
	Integer postcode;
	String city;
	String street;
	String bld;
	String appart;
	
	String email1;
	String email2;	
	
	String prime;
	String workphone;
	String mobile;
	String fax;
	String other;
	
	public IdContact(int id, String firstname, String lastname, String company, String position, String skype,
			String comment, Integer postcode, String city, String street, String bld, String appart, String email1,
			String email2, String prime, String workphone, String mobile, String fax, String other) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.company = company;
		this.position = position;
		this.skype = skype;
		this.comment = comment;
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.bld = bld;
		this.appart = appart;
		this.email1 = email1;
		this.email2 = email2;
		this.prime = prime;
		this.workphone = workphone;
		this.mobile = mobile;
		this.fax = fax;
		this.other = other;
	}
	
	public IdContact(String firstname, String lastname, String company, String position, String skype,
			String comment, Integer postcode, String city, String street, String bld, String appart, String email1,
			String email2, String prime, String workphone, String mobile, String fax, String other) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.company = company;
		this.position = position;
		this.skype = skype;
		this.comment = comment;
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.bld = bld;
		this.appart = appart;
		this.email1 = email1;
		this.email2 = email2;
		this.prime = prime;
		this.workphone = workphone;
		this.mobile = mobile;
		this.fax = fax;
		this.other = other;
	}
	
	public IdContact() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getCompany() {
		return company;
	}

	public String getPosition() {
		return position;
	}

	public String getSkype() {
		return skype;
	}

	public String getComment() {
		return comment;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getBld() {
		return bld;
	}

	public String getAppart() {
		return appart;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getPrime() {
		return prime;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getFax() {
		return fax;
	}

	public String getOther() {
		return other;
	}

	@Override
	public String toString() {
		return "IdContact [id=" + id + ", firstname=" + (firstname==null?"null":firstname) + ", lastname=" + (lastname==null?"null":lastname)+
				", company=" + (company==null?"null":company) + ", position=" + (position==null?"null":position) + ", skype=" 
				+ (skype==null?"null":skype) + ", comment=" + (comment==null?"null":comment) + ", postcode=" + (postcode==null?0:postcode)
				+ ", city=" + (city==null?"null":city) + ", street=" + (street==null?"null":street) + ", bld=" + (bld==null?"null":bld) + 
				", appart=" + (appart==null?"null":appart) + ", email1=" + (email1==null?"null":email1)	+ ", email2=" + (email2==null?"null":email2) 
				+ ", prime=" + (prime==null?"null":prime) + ", workphone=" + (workphone==null?"null":workphone) + ", mobile=" 
		        + (mobile==null?"null":mobile) + ", fax=" + (fax==null?"null":fax) + ", other=" + (other==null?"null":other) + "]";
	}
		
}
