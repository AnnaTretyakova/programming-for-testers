package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{

	@Test
	public void deleteSomeGroup() throws Exception{
		int index = 1;
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnGroupPage();		
	}
}
