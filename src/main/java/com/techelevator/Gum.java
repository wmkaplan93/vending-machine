package com.techelevator;

public class Gum extends VendingMachineProduct{
	
	public Gum(String productName, String productPrice)  {
		super(productName, productPrice);
	}

	@Override
	public String returnMessage() {
		System.out.println("Munch Munch, Yum!");
		return null;
	}
	
	

}
