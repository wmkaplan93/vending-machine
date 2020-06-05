package com.techelevator;

public class Drink extends VendingMachineProduct{
	
	private int count = 5;
	
	public Drink(String productName, String productPrice, int count) {
		super(productName, productPrice);
		this.count = count;
	}

	@Override
	public String returnMessage() {
		System.out.println("Glug Glug, Yum!");
		return "Glug Glug, Yum!";
	}
	
	public String reduceCount() {
		if(count > 0) {
			count--;
		} 
		return "Sold Out";
		
	}
	
	public String displayCount() {
		if(count > 0) {
			System.out.println(" " + count + " available");
		} else if (count == 0) {
			System.out.println("Sold Out");
		}
		return "";
	}

}
