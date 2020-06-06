package com.techelevator;

public class Gum extends VendingMachineProduct{
	
	public Gum(String productName, String productPrice)  {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		System.out.println("Chew Chew, Yum!");
		return null;
	}
	
	

}
