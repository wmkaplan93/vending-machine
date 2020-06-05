package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
	
	Map <String, VendingMachineProduct> productGenerator = new HashMap<String, VendingMachineProduct>();
	
	public void getOptionsList() {
		File inputFile = new File("vendingmachine.csv");
		try (Scanner fileInput = new Scanner(inputFile)) {
			
			while(fileInput.hasNextLine()) {
				
				String s = fileInput.nextLine();
				System.out.println(s);
				
//				String[] stringArray = s.split("\\|");
//				VendingMachineProduct product1 = new VendingMachineProduct(stringArray[1], stringArray[2]);
//				productGenerator.put(stringArray[0], product1);
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
}
	
	
	public void purchaseMenu() {
		
		ProductMap newMap = new ProductMap();
		
		Scanner userInput = new Scanner(System.in);
		newMap.populateProductMap(productGenerator);
		
		System.out.println("");
		System.out.println("[1] add some dough");
		System.out.println("[2] choose a thing");
		System.out.println("[3] scram");
		
		String userChoice = userInput.nextLine();
		
		while(userChoice != null) {

			if("2".equals(userChoice)) {
				System.out.println("What would you like? [B1, C2 etc] ");
				String userLocation = userInput.nextLine();
				if(productGenerator.containsKey(userLocation)) {
					System.out.println();
					System.out.println("Success");
					System.out.println(productGenerator.get(userLocation));
					
					System.exit(1);
				}
				System.out.println("Not a valid selection, please try again.");
			} else if ("3".equals(userChoice)) {
				System.exit(0);
			}
		}
		
	}

}
