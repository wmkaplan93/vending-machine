package com.techelevator;

public class Chip extends VendingMachineProduct{
	
	public Chip(String productName, String productPrice) {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		return "Crunch Crunch, Yum!";
	}
	

}
