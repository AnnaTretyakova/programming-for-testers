package com.example.tests;

import java.io.File;
import java.util.List;

public class GroupDataGenerator {

	public static void main(String[] args) {
		if (args.length < 3){
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		List<GroupData> groups = generateRandomGroups(amount);
		if ("csv".equals(format)){
			saveGroupsToCsvFile(groups, file);
		} else if ("xml".equals(format)){
			saveGroupsToXMLFile(groups, file);
		} else {
			System.out.println("Unknown format " + format);
		}
	}
}
