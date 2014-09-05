package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContacts() throws Exception{
		int index = 1;
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().deleteContact(index);
		app.getContactHelper().returnHomePage();
	}
}
