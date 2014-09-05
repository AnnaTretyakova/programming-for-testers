package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
	    click(By.name("new"));
	}

	public void fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.name);
	    type(By.name("group_header"), group.header);
	    type(By.name("group_footer"), group.footer);
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void returnGroupPage() {
		click(By.linkText("group page"));
	}

	public void deleteGroup(int index) throws Exception {
		if (isCheckboxOnPage()){
			selectGroupByIndex(index);
			click(By.name("delete"));	
		} else {
			throw new Exception("there is no group to delete");
		}
	}
	
	private boolean isCheckboxOnPage() {
		return isElementPresent(By.xpath("//input[@name = 'selected[]']"));
	}
	

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name = 'selected[]'][" + index + "]"));
	}
	
	public void initGroupModification(int index) throws Exception {
		if (isCheckboxOnPage()){
		selectGroupByIndex(index);
		click(By.name("edit"));	
		} else {
			throw new Exception("there is no group to modify");
		}
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}
}
