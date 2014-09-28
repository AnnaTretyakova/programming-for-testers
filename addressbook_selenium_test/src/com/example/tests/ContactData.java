package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstname;
	private String lastname;
	private String address;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String group;
	private String address2;
	private String homephone2;


	public ContactData(){
	}
	
	
	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result 
		//		+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		/*if (this.lastname == null && other.lastname != null) {
			return -1;
		} else if (other.lastname == null && this.lastname != null) {
			return 1;
		} else if (other.lastname == null && this.lastname == null) {
			return 0;
		} else {
			return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		}*/
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}
	
	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public String getAddress() {
		return this.address;
	}


	public String getHomephone() {
		return homephone;
	}


	public String getMobilephone() {
		return mobilephone;
	}


	public String getWorkphone() {
		return workphone;
	}


	public String getEmail() {
		return email;
	}


	public String getEmail2() {
		return email2;
	}


	public String getBday() {
		return bday;
	}


	public String getBmonth() {
		return bmonth;
	}


	public String getByear() {
		return byear;
	}


	public String getGroup() {
		return group;
	}


	public String getAddress2() {
		return address2;
	}


	public String getHomephone2() {
		return homephone2;
	}


	public ContactData withFirstName(String firstName) {
		this.firstname = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastname = lastName;
		return this;
	}


	public ContactData withAdress(String adress) {
		this.address = adress;
		return this;
	}


	public ContactData withHomephone(String homePhone) {
		this.homephone = homePhone;
		return this;
	}


	public ContactData withMobilephone(String mobilePhone) {
		this.mobilephone = mobilePhone;
		return this;
	}


	public ContactData withWorkphone(String workPhone) {
		workphone = workPhone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}


	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}


	public ContactData withBday(String bday ) {
		this.bday = bday;
		return this;
	}


	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}


	public ContactData withAddress2(String adress2) {
		address2 = adress2;
		return this;
	}


	public ContactData withHomephone2(String homephone2) {
		this.homephone2 = homephone2;
		return this;
	}
	
	
	
	
}