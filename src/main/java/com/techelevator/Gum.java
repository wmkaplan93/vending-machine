package com.techelevator;

public class Gum extends VendingMachineProduct{
	
	public Gum(String productName, String productPrice) {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		return "Chew Chew, Yum!";
	}
	

}
