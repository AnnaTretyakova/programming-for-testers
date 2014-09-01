package com.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContacts(){
		int index = 1;
		app.getNavigationHelper().openMainPage();
		if (By.xpath("//tr[" + (index + 1) + "]//a/img[@title = 'Edit']")!= null) //Test fails with "NoSuchElementException" when there is no Contact, how to make test passed in this case?
		{
			app.getContactHelper().deleteContact(index);
			app.getContactHelper().returnHomePage();
		}
		System.out.println("There is no Contact to delete");
	}
}
