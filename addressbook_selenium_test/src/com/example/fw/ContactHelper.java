package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts(){
		if(cachedContacts == null){
			rebuildContacts();
		}
		return cachedContacts;
	}
	
	public void rebuildContacts() {
		cachedContacts = new ArrayList<ContactData>();	
		
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name]"));
		for (WebElement row : rows) {
			ContactData contact = new ContactData();
			contact.withLastName(row.findElement(By.xpath("td[2]")).getText());
			contact.withFirstName(row.findElement(By.xpath("td[3]")).getText());
			contact.withEmail(row.findElement(By.xpath("td[4]")).getText());
			contact.withHomephone(row.findElement(By.xpath("td[5]")).getText());
			cachedContacts.add(contact);
		}
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
    	fillContactForm(contact, CREATION);
    	submitNewContact();
    	returnHomePage();	
    	rebuildContacts();
    	return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) throws Exception {
		manager.navigateTo().mainPage();
		initContactModification(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnHomePage();
		rebuildContacts();
		return this;
	}
	
	public ContactHelper deleteContact(int index) throws Exception { 
		initContactModification(index);
		click(By.xpath("//input[@value = 'Delete']"));
		returnHomePage();
		rebuildContacts();
		return this;
}
	
	//------------------------------------------------------------------------------------

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHomephone());
		type(By.name("mobile"), contact.getMobilephone());
		type(By.name("work"), contact.getWorkphone());
	    type(By.name("email"), contact.getEmail());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());  
	    if (formType == CREATION){
	    	//selectByText(By.name("new_group"), contact.group); in lesson "group 1" instead of contact.group
	    }else{
	    	if (driver.findElements(By.name("new_group")).size() != 0){
	    		throw new Error ("Group selector exists in contact modification form");
	    	}	
	    }
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getHomephone2());
	    return this;
	}

	public ContactHelper submitNewContact() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnHomePage() {
		click(By.linkText("home page"));
		return this;
	}
	
	public ContactHelper initContactModification(int index) throws Exception { 
		if (isPencilOnPage()){
		click(By.xpath("//tr[" + (index + 2) + "]//a/img[@title = 'Edit']"));
		} else {
			throw new Exception("there is no contact to delete/modify");
		}
		return this;
	}
	
	private boolean isPencilOnPage() {
		return isElementPresent(By.xpath("//tr//a/img[@title = 'Edit']"));
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value = 'Update']"));
		cachedContacts = null;
		return this;
	}

	/*
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();	
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			//contact.firstname = title.substring("Select (".length(), title.length() - ")".length());
			contact.lastname = title.substring(title.lastIndexOf(" ")+1, title.length() - ")".length());
			contacts.add(contact);
		}
	*/
	
}
