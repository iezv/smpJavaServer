package smp.contacts.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Phones {
	String prime;
	String workphone;
	String mobile;
	String fax;
	String other;
		
	public Phones() {
		super();
	}

	public Phones(String prime, String workphone, String mobile, String fax, String other) {
		super();
		this.prime = prime;
		this.workphone = workphone;
		this.mobile = mobile;
		this.fax = fax;
		this.other = other;
	}

	public String getPrime() {
		return prime;
	}

	public void setPrime(String prime) {
		this.prime = prime;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "Phones [prime=" + prime + ", workphone=" + (workphone==null?"null":workphone) + ", mobile=" 
	+ (mobile==null?"null":mobile) + ", fax=" + (fax==null?"null":fax) + ", other1=" + 
				(other==null?"null":other) + "]";
	}
	
		

}
