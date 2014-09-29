package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private List <GroupData> cachedGroups;
	
	public List<GroupData> getGroups() {
		if (cachedGroups == null){
			rebuildCache();
		}
		return cachedGroups;
	}
	
	public void rebuildCache() {
		List <GroupData> cachedGroups = new ArrayList<GroupData>();
		
		manager.navigateTo().groupsPage();	
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
	      	GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.withName(title.substring("Select (".length(), title.length()-")".length()));
			cachedGroups.add(group);
		}
	}

	public GroupHelper createGroup(GroupData group) {	
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnGroupPage();	
		rebuildCache();
		return this;
	}
		
	public GroupHelper modifyGroup(int index, GroupData group) throws Exception {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnGroupPage();	
		rebuildCache();
		return this;
	}
	
	public GroupHelper deleteGroup(int index) throws Exception {
		if (isCheckboxOnPage()){
			selectGroupByIndex(index);
			submitGroupDeletion();	
		} else {
			throw new Exception("there is no group to delete");
		}
		returnGroupPage();
		rebuildCache();
		return this;
	}
	
	//--------------------------------------------------
	
	public GroupHelper initGroupCreation() {
	    click(By.name("new"));
	    return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.getName());
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());
	    return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper returnGroupPage() {
		click(By.linkText("group page"));
		return this;
	}

	private boolean isCheckboxOnPage() {
		return isElementPresent(By.xpath("//input[@name = 'selected[]']"));
	}
	

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name = 'selected[]'][" + (index+1) + "]"));
	}
	
	public GroupHelper initGroupModification(int index) throws Exception {
		if (isCheckboxOnPage()){
		selectGroupByIndex(index);
		click(By.name("edit"));	
		} else {
			throw new Exception("there is no group to modify");
		}
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}
	
	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}

	/*
	private String getGroupHeader(int index){
		selectGroupByIndex(index);
		click(By.name("edit"));
		WebElement header = driver.findElement(By.name("group_header"));
		String h = header.getTagName();
		return h;
	}
	*/
}
