package com.techelevator;

public class UserInterface {
	public static void main(String[] args) {
		
		VendingMachine steve = new VendingMachine("vendingmachine.csv");
		steve.populateProductMap();
		steve.mainMenu();
	}
}
