package com.example.tests;

import org.testng.annotations.Test;

public class AlsoCreateGroupTests extends TestBase {
  
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "g 1";
    group.header = "h 1";
    group.footer = "f 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnGroupPage();
  }
}

