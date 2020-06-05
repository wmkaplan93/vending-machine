package com.techelevator;

public class Candy extends VendingMachineProduct{
	
	private int count = 5;
	
	public Candy(String productName, String productPrice, int count) {
		super(productName, productPrice);
		this.count = count;
	}

	@Override
	public String returnMessage() {
		System.out.println("Munch Munch, Yum!");
		return "Munch Munch, Yum!";
	}
	
	public String reduceCount() {
		if(count > 0) {
			count--;
		} 
		return "Sold Out";
		
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
