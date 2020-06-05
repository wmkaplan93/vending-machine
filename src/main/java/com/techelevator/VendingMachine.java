package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
	
//	public void inventoryList() {
//		ProductMap newMap = new ProductMap();
//		newMap.populateProductMap(productGenerator);
//	}
	
	
	
	Map <String, VendingMachineProduct> productGenerator = new HashMap<String, VendingMachineProduct>();
	
	public void getOptionsList() {
		File inputFile = new File("vendingmachine.csv");
		try (Scanner fileInput = new Scanner(inputFile)) {
			
			while(fileInput.hasNextLine()) {
				
				String s = fileInput.nextLine();
				System.out.println(s);
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
}
	
	
	@SuppressWarnings("resource")
	public void purchaseMenu() {
		
		Scanner userInput = new Scanner(System.in);
		
		
		ProductMap newMap = new ProductMap();
		newMap.populateProductMap(productGenerator);
		
		
		System.out.println("");
		System.out.println("[1] add some dough");
		System.out.println("[2] choose a thing");
		System.out.println("[3] scram");
		
		String userChoice = userInput.nextLine();
		

		
			while(userChoice != null) {
	
				while("2".equals(userChoice) && !"Q".equalsIgnoreCase(userChoice)) {
					System.out.println("What would you like? [B1, C2 (Or type 'Q' to return)] ");
					String userLocation = userInput.nextLine();
					if(productGenerator.containsKey(userLocation)) {
						productGenerator.get(userLocation).returnMessage();
						System.out.println();
						if (productGenerator.get(userLocation).getCount() == 0) {
							System.out.println("Sorry, sold out!");
							System.out.println("Please make another selection");
						}
						productGenerator.get(userLocation).reduceCount();
						System.out.println("Please make another selection, or type 'Q' to return. ");
						userLocation = userInput.nextLine();
						if("Q".equals(userLocation)) {
							break;
						}

//					} else if ("Q".equalsIgnoreCase(userLocation)) {
//						continue;
//
//					} else {
//						System.out.println("Not a valid selection, please try again.");
//					}


					}
				
				
//				} else if ("3".equals(userChoice)) {
//					System.exit(0);
				}
				break;
			}
	}

}
