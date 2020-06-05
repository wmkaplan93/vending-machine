package com.techelevator;

public class Chip extends VendingMachineProduct{
	
	private int count = 5;
	
	public Chip(String productName, String productPrice, int count) {
		super(productName, productPrice);
		this.count = count;
	}

	@Override
	public String returnMessage() {
		System.out.println("Crunch Crunch, Yum!");
		return "Crunch Crunch, Yum!";
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
