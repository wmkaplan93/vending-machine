package com.techelevator;

public class Drink extends VendingMachineProduct{
	
	public Drink(String productName, String productPrice) {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		return "Glug Glug, Yum!";
	}
	

}
