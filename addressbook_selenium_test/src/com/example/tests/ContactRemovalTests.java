package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContacts() throws Exception{
		int index = 0;
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//action
		app.getContactHelper().deleteContact(index);
		app.getContactHelper().returnHomePage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states  
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}
}
