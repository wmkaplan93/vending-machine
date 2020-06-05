package com.techelevator;

public class Drink extends VendingMachineProduct{
	
	
	public Drink(String productName, String productPrice)  {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		System.out.println("Glug Glug, Yum!");
		return null;
	}
	

}
