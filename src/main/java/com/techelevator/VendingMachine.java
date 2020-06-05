package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
	
	/*
	 * Methods:
	 * -vend
	 * -create product map - produceProductMap 
	 *  -- This is done when the system boots.
	 * -display inventory - getOptionList()
	 * 
	 * ToDo:
	 * Vend
	 *  - Money
	 * Money System
	 * Log
	 * Tests
	 * Optional - Sales Report
	 * 
	 */
	//vending machine constructor.
	//call it in UserInterface. 
	//what belongs to vending machine, what belongs to inventory, what belongs to items
	//second map of key: location, value: count
	
	private Map <String, VendingMachineProduct> productGenerator = new HashMap<String, VendingMachineProduct>();
	private String inputFile;
	private double balance = 0.00;
	private Map<String, Integer> inventoryCount = new HashMap<String, Integer>();
	
	
	public VendingMachine(String inputFile) {
		this.inputFile = inputFile;
		
	}
	
	
	
	//*****
	public Map<String, VendingMachineProduct> getProductGenerator() {
		return productGenerator;
	}




	public String getInputFile() {
		return inputFile;
	}
	//*****



	public void getOptionsList() {
		File f = new File(inputFile);
		try (Scanner fileInput = new Scanner(f)) {
			
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
		
		System.out.println("");
		System.out.println("[1] add some dough");
		System.out.println("[2] choose a thing");
		System.out.println("[3] scram");
		
		String userChoice = userInput.nextLine();
		
			while(userChoice != null) {
	
				if("2".equals(userChoice)) {
					
					File f = new File(inputFile);
					try (Scanner fileInput = new Scanner(f)) {
						
						while(fileInput.hasNextLine()) {
							
							String s = fileInput.nextLine();
							String[] stringArray = s.split("\\|");
							System.out.print(s + ": ");
							System.out.println(inventoryCount.get(stringArray[0]));
						}			
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					System.out.println("What would you like? [B1, C2 (Or type 'Q' to return)] ");
					String userLocation = userInput.nextLine();
					if(productGenerator.containsKey(userLocation) && (int)inventoryCount.get(userLocation) != 0) {
						productGenerator.get(userLocation).getProductName();
						System.out.println("Subtracting " + productGenerator.get(userLocation).getProductPrice() + " from your balance.");
						System.out.println("Remaining Balance: " + balance);
						productGenerator.get(userLocation).returnMessage();
						System.out.println();
					} else {
						System.out.println("Sorry, " + productGenerator.get(userLocation) + " is sold out!");
						System.out.println("Please make another selection");
					}
						
					inventoryCount.put(userLocation, (inventoryCount.get(userLocation)-1) );
					purchaseMenu();

					if("Q".equals(userLocation)) {
						break;
					}

				} else if("1".equals(userChoice)) {
					feedMoney();
				} else if("3".equals(userChoice)) {
					System.exit(0);
				} else {
					System.out.println("Please enter a valid command. ");
					purchaseMenu();
				}
			}
	}
	
			
		public void populateProductMap() {
			
			
			File f = new File(inputFile);
			try (Scanner fileInput = new Scanner(f)) {
				
				
				while(fileInput.hasNextLine()) {
					
					String s = fileInput.nextLine();
					String[] stringArray = s.split("\\|");
					if(stringArray[3].equals("Candy")) {
						Candy productCandy = new Candy(stringArray[1], stringArray[2]);
						productGenerator.put(stringArray[0], productCandy);
						inventoryCount.put(stringArray[0], 5);
					} else if(stringArray[3].equals("Chip")) {
						Chip productChip = new Chip(stringArray[1], stringArray[2]);
						productGenerator.put(stringArray[0], productChip);
						inventoryCount.put(stringArray[0], 5);
					} else if(stringArray[3].equals("Gum")) {
						Gum productGum = new Gum(stringArray[1], stringArray[2]);
						productGenerator.put(stringArray[0], productGum);
						inventoryCount.put(stringArray[0], 5);
					} else {
						Drink productDrink = new Drink(stringArray[1], stringArray[2]);
						productGenerator.put(stringArray[0], productDrink);
						inventoryCount.put(stringArray[0], 5);
					}
					
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}			
		}
		
		
		//feed money method
		public void feedMoney() {
			Scanner userInput = new Scanner(System.in);
			
			System.out.println("");
			System.out.println("How much would you like to add? (1, 2, 5, 10 only) ");
			System.out.println("Or type 'Q' to return to the purchase screen. ");
			String moreMoney = userInput.nextLine();
			if ("Q".equalsIgnoreCase(moreMoney)){
				purchaseMenu();
			} else if(Integer.parseInt(moreMoney) == 1 || Integer.parseInt(moreMoney) == 2 || Integer.parseInt(moreMoney) == 5 || Integer.parseInt(moreMoney) == 10) {
				balance += Double.parseDouble(moreMoney);
				System.out.println("Current Balance: " + balance);
			} else {
				System.out.println("Please enter a valid whole dollar amount.");
			}
			
		}
		
		
}
