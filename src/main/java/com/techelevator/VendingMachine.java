package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
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
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	
	
	
	
	
	//*****

	@SuppressWarnings("resource")
	public void mainMenu() {
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("Welcome to the Stupendous Tech Elevator Vending Experience [STEVE]!");
		System.out.println("How might we vend you today?");
		System.out.println("");
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
				System.out.println("[3] Finish Transaction.");
				System.out.println("Please make a selection: ");
				userChoice = userInput.nextLine();
			} else if ("2".equals(userChoice)) {
				purchaseMenu();
			} else if ("3".equals(userChoice)) {
				System.out.println("Thank you, come again!");
				returnChange();
				System.exit(0);
			} else {
				System.out.println("Sorry, that's not a valid selection, please try again.");
				userChoice = userInput.nextLine();
			}
		}
	}
	
	
	


	public void getOptionsList() {
		File f = new File(inputFile);
		try (Scanner fileInput = new Scanner(f)) {
			
			while(fileInput.hasNextLine()) {
				
				String s = fileInput.nextLine();
				String[] stringArray = s.split("\\|");
				if (inventoryCount.get(stringArray[0]) == 0) {
					System.out.println(s + ": SOLD OUT");
				} else {
					System.out.print(s + ": ");
					System.out.println(inventoryCount.get(stringArray[0]) + " available");
				}
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
}
	
	
	@SuppressWarnings("resource")
	public void purchaseMenu() {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("[1] Add money to my balance.");
		System.out.println("[2] Select an item.");
		System.out.println("[3] Return to the main menu.");
		
		String userChoice = userInput.nextLine();
		
			while(userChoice != null) {
	
				if("2".equals(userChoice)) {
					
					File f = new File(inputFile);
					try (Scanner fileInput = new Scanner(f)) {
						
						while(fileInput.hasNextLine()) {
							
							String s = fileInput.nextLine();
							String[] stringArray = s.split("\\|");
							if (inventoryCount.get(stringArray[0]) == 0) {
								System.out.println(s + ": SOLD OUT");
							} else {
								System.out.print(s + ": ");
								System.out.println(inventoryCount.get(stringArray[0]) + " available");
							}
						}			
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					try {
						System.out.println("");
						System.out.println("What would you like? [B1, C2 (Or type 'Q' to return)] ");
						System.out.println("");
						String userLocation = userInput.nextLine();
						if ("Q".equalsIgnoreCase(userLocation)) {
							purchaseMenu();
						} else if(balance >= Double.parseDouble(productGenerator.get(userLocation).getProductPrice())) {
							if(productGenerator.containsKey(userLocation) && (int)inventoryCount.get(userLocation) != 0) {
								productGenerator.get(userLocation).getProductName();
								System.out.print(" selected. ");
								productGenerator.get(userLocation).returnMessage();
								System.out.println("Subtracting " + productGenerator.get(userLocation).getProductPrice() + " from your balance.");
								System.out.println("Remaining Balance: " + (df.format(balance -= Double.parseDouble(productGenerator.get(userLocation).getProductPrice()))));
								System.out.println();
							} else if ((int)inventoryCount.get(userLocation) == 0){
								System.out.println("Sorry, " + productGenerator.get(userLocation) + " is sold out!");
								System.out.println("Please make another selection");
							}
						} else {
							System.out.println("Sorry, insufficient funds for this purchase. Please add more money and try again.");
							purchaseMenu();
						}
							
						inventoryCount.put(userLocation, (inventoryCount.get(userLocation)-1) );
						purchaseMenu();
	
						if("Q".equals(userLocation)) {
							break;
						}
					} catch (NullPointerException e) {
						System.out.println("Please make a valid selection in the form of 'B1' 'C2' etc.");
						System.out.println("");
					}

				} else if("1".equals(userChoice)) {
					feedMoney();
				} else if("3".equals(userChoice)) {
					mainMenu();
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
		@SuppressWarnings("resource")
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
				System.out.println("Current Balance: " + df.format(balance));
			} else {
				System.out.println("Please enter a valid whole dollar amount.");
			}
			
		}
		
		//change method
		
		public void returnChange() {
			int countQ = 0;
			int countD = 0;
			int countN = 0;
			int countP = 0;
			balance = Double.parseDouble(df.format(balance * 100)); //320 cents
			countQ = (int) (balance / 25); //12 quarters, 20 cents
			countD = (int) ((balance % 25) / 10); //2 dimes, 0 cents
			countN = (int) (((balance % 25) % 10) / 5);
			countP = (int) ((((balance % 25) % 10) % 5) / 1);
			System.out.println("Your change is: ");
			System.out.println(balance / 100);
			System.out.println(countQ + " Quarters");
			System.out.println(countD + " Dimes");
			System.out.println(countN + " Nickles");
			System.out.println(countP + " Pennies");
			System.out.println("");
			System.out.println("Have a Vend-tastic day!");
		}
		
		
}
