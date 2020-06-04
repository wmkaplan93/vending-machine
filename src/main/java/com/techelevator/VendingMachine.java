package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Vendomatic 800!");
		System.out.println("[1] See available products.");
		System.out.println("[2] Make a purchase.");
		System.out.println("[3] Exit.");
		System.out.println("Please make a selection: ");
		String userChoice = userInput.nextLine();
		while (userChoice != null) {
			if ("1".equals(userChoice)) {
				getOptionsList();
				System.out.println("");
				System.out.println("What would you like to do next? ");
				System.out.println("[1] See available products.");
				System.out.println("[2] Make a purchase.");
				System.out.println("[3] Exit.");
				System.out.println("Please make a selection: ");
				userChoice = userInput.nextLine();
			} else if ("2".equals(userChoice)) {
				purchaseMenu();
			} else if ("3".equals(userChoice)) {
				System.out.println("Thank you, come again!");
				System.exit(0);
			} else {
				System.out.println("Sorry, that's not a valid selection, please try again.");
				userChoice = userInput.nextLine();
			}
		}
	}
		
		
	
		private static void getOptionsList() {
			File inputFile = new File("vendingmachine.csv");
			try (Scanner fileInput = new Scanner(inputFile)) {
				Map <String, VendingMachineProduct> productGenerator = new HashMap<String, VendingMachineProduct>();
				while(fileInput.hasNextLine()) {
					
					
					String s = fileInput.nextLine();
					System.out.println(s);
					
					String[] stringArray = s.split("\\|");
					VendingMachineProduct product1 = new VendingMachineProduct(stringArray[1], stringArray[2]);
					productGenerator.put(stringArray[0], product1);
					System.out.println(stringArray[0] + " " + stringArray[1]);
					System.out.println(product1);
					
					
				}
				System.out.println(productGenerator);
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
		private static void purchaseMenu() {
			
			System.out.println("Coming Soon!");
			System.exit(0);
		}

}
