package com.techelevator;

public abstract class VendingMachineProduct {
	
	//they know what they are
	//know type (candy/soda/chips/gum)
	private String productName;
	private String productPrice;


	public VendingMachineProduct(String productName, String productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
	
	//*********
	public String getProductName() {
		System.out.print(productName);
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}
	
	public String toString() {
		return productName + " " + productPrice;
	}

	
	abstract String returnMessage();


	//*********
	

}
