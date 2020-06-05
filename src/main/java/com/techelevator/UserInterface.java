package com.techelevator;

import java.util.Scanner;

public class UserInterface {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		
		VendingMachine steve = new VendingMachine();
		ProductMap steveMap = new ProductMap();
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("Welcome to the Vendomatic 800!");
		System.out.println("[1] See available products.");
		System.out.println("[2] Make a purchase.");
		System.out.println("[3] Exit.");
		System.out.println("Please make a selection: ");
		String userChoice = userInput.nextLine();
		
		while (userChoice != null) {
			if ("1".equals(userChoice)) {
				steve.getOptionsList();
				System.out.println("");
				System.out.println("What would you like to do next? ");
				System.out.println("[1] See available products.");
				System.out.println("[2] Make a purchase.");
				System.out.println("[3] Exit.");
				System.out.println("Please make a selection: ");
				userChoice = userInput.nextLine();
			} else if ("2".equals(userChoice)) {
				steve.purchaseMenu();
			} else if ("3".equals(userChoice)) {
				System.out.println("Thank you, come again!");
				System.exit(0);
			} else {
				System.out.println("Sorry, that's not a valid selection, please try again.");
				userChoice = userInput.nextLine();
			}
		}
		
	}
	
	
}
