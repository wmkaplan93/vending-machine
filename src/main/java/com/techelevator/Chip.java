package com.techelevator;

public class Chip extends VendingMachineProduct{
	
	public Chip(String productName, String productPrice)  {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		System.out.println("Crunch Crunch, Yum!");
		return null;
	}
	

}
