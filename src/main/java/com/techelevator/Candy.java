package com.techelevator;

public class Candy extends VendingMachineProduct{
	
	
	
	public Candy(String productName, String productPrice) {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		return "Munch Munch, Yum!";
	}
	
	

}
