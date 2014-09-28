package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();   
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop(); 
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i<5; i++){
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		Random rnd = new Random();
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i<5; i++){
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString())
			.withLastName(generateRandomString())
			.withAdress(generateRandomString())
			.withHomephone(generateRandomNumber(899999999))
			.withMobilephone(generateRandomNumber(899999999))
			.withWorkphone(generateRandomNumber(899999999))
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
			.withBmonth(generateRandomMonth())
			.withByear(generateRandomByear())
			.withAddress2(generateRandomString())
			.withHomephone2(generateRandomNumber(899999999));
			if (contact.getBmonth().equals("-")){
				contact.withBday("-");
			}else if (contact.getBmonth().equals("February")){				
				contact.withBday(String.valueOf(rnd.nextInt(29)+1));
			} else if (contact.getBmonth().equals("January")||contact.getBmonth().equals("March")||contact.getBmonth().equals("May")||contact.getBmonth().equals("July")||contact.getBmonth().equals("August")||contact.getBmonth().equals("October")||contact.getBmonth().equals("December")) {
				contact.withBday(String.valueOf(rnd.nextInt(31)+1));
			} else {
				contact.withBday(String.valueOf(rnd.nextInt(30)+1));
			}
			
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		String alphabet = "qwertyuiopasdfghjklzxcvbnm";
		//String symbols = "!@#$%^&*()_+{}|:<>?-=[]\\;,./\'\" ";
		int rndValue = rnd.nextInt(3);
		if (rndValue == 0){
			 return "";
		} else {
			int length = rnd.nextInt(9)+1;
			StringBuilder word = new StringBuilder();
			for (int i = 0; i<length; i++){
				word.append(alphabet.charAt(rnd.nextInt(alphabet.length()-1)));
			}
			word.append(rnd.nextInt());
			///word.append(symbols.charAt(rnd.nextInt(symbols.length()-1)));
			return word.toString();
		}
	}
		
	public String generateRandomByear(){
		Random rnd = new Random();
		int rndValue = rnd.nextInt(3);
		if (rndValue == 0){
			 return "";
		} else {
			int byear = 1900 + rnd.nextInt(114);
			return String.valueOf(byear);
		}
	}
	
	public String generateRandomNumber(int num){
		Random rnd = new Random();
		int rndValue = rnd.nextInt(4);
		if (rndValue == 0){
			 return "";
		} else if (rndValue == 1) {
			return null;
		} else {
			return String.valueOf(rnd.nextInt(num)+1);
		}
	}
	
	public String generateRandomMonth(){
		Random rnd = new Random();
		String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int rndValue = rnd.nextInt(4);
		if (rndValue == 0){
			 return "-";
		} else {
			return months[rnd.nextInt(12)];
		}
	}
}
