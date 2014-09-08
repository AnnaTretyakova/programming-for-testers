package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();	
    ContactData contact = new ContactData();
    contact.firstname = "Anna";
    contact.lastname = "Tretyakova";
    contact.address = "Saint-Petersburg, Popova street, 10";
    contact.homephone = "1478525";
    contact.mobilephone = "89501472589";
    contact.workphone = "89501234567";
    contact.email = "studentanna@rambler.ru" ;
    contact.email2 = "studentanna@yandex.ru";
    contact.bday = "1";
    contact.bmonth = "August";
    contact.byear = "1988";
    contact.group = "g 1";
    contact.address2 = "Saint-Petersburg, Popova street, 10";
    contact.homephone2 = "1478525";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitNewContact();
    app.getContactHelper().returnHomePage();
  } 
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();	
    ContactData contact = new ContactData();
   	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitNewContact();
    app.getContactHelper().returnHomePage();
  } 
}


