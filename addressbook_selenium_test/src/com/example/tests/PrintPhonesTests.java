package com.example.tests;

import java.util.List;

import org.testng.annotations.Test;

public class PrintPhonesTests extends TestBase {
	
	@Test public void testVerifyPrintPhonePage(){
		
		//String textInCell = "1\n" +"1\n" +"3\n";
		//System.out.println(textInCell);
		//textInCell.indexOf("\n");
		List<String> phonesFromPrintPhonesPage = app.getContactHelper().getPhonesFromPrintPhonesPage();
		List<String> phonesFromHomePage = app.getContactHelper().getPhonesFromHomePage();

	}
}
