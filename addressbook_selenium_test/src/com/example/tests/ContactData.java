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
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", homephone=" + homephone
				+ ", mobilephone=" + mobilephone + ", workphone=" + workphone
				+ ", email=" + email + ", email2=" + email2 + ", bday=" + bday
				+ ", bmonth=" + bmonth + ", byear=" + byear + ", group="
				+ group + ", address2=" + address2 + ", homephone2="
				+ homephone2 + "]";
	}
	
}