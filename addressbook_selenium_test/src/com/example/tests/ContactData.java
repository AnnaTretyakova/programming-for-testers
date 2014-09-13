package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String group;
	public String address2;
	public String homephone2;

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
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}
}