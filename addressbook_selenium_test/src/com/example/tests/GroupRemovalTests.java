package com.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{

	@Test
	public void deleteSomeGroup(){
		int index = 1;
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
		if (By.xpath("//input[@name = 'selected[]'][" + index + "]")!= null) //Test fails when there is no Groups, how to make it passed?
		{
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnGroupPage();		
		}
		System.out.println("There is no Group to delete");
	}
}
