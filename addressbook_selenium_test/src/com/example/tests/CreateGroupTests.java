package com.example.tests;

import org.testng.annotations.Test;

public class CreateGroupTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "g 1";
    group.header = "h 1";
    group.footer = "f 1";
	app.fillGroupForm(this, group);
    app.submitGroupCreation();
    app.returnGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitGroupCreation();
    app.returnGroupPage();
  }
}

