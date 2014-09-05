package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact () throws Exception{
		int index = 1;
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(index);
		ContactData contact = new ContactData();
		contact.firstname = "NewName";
		contact.address = "NewAdress";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnHomePage();
	}
}
