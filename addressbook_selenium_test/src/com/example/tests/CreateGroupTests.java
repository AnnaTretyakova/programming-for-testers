package com.example.tests;

import org.testng.annotations.Test;

public class CreateGroupTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.navigationHelper.gotoGroupsPage();
    app.groupHelper.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "g 1";
    group.header = "h 1";
    group.footer = "f 1";
	app.groupHelper.fillGroupForm(app, this, group);
    app.groupHelper.submitGroupCreation();
    app.groupHelper.returnGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.navigationHelper.gotoGroupsPage();
    app.groupHelper.initGroupCreation();
    app.groupHelper.fillGroupForm(app, this, new GroupData("", "", ""));
    app.groupHelper.submitGroupCreation();
    app.groupHelper.returnGroupPage();
  }
}

