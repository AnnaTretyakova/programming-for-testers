package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact () throws Exception{
		int index = 0;
		app.getNavigationHelper().openMainPage();
		
		//save old state 
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//action
		app.getContactHelper().initContactModification(index);
		ContactData contact = new ContactData();
		contact.firstname = "NewName";
		contact.lastname = "NewLastName";
		contact.address = "NewAdress";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnHomePage();
		
	    //save new states
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList); 
	}
}
