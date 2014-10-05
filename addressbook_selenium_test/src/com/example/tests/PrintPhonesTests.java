package com.example.tests;

import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;

public class PrintPhonesTests extends TestBase {
	
	@Test public void testVerifyPrintPhonePage(){
		
		SortedListOf<String> phonesFromPrintPhonesPage = app.getContactHelper().getPhonesFromPrintPhonesPage();
		SortedListOf<String> phonesFromHomePage = app.getContactHelper().getPhonesFromHomePage();

		assertThat(phonesFromPrintPhonesPage, equalTo(phonesFromHomePage));
	}
}
