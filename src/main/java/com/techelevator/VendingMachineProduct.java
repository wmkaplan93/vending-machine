package com.techelevator;

public class VendingMachineProduct {
	
	//they know what they are
	//know type (candy/soda/chips/gum)
	//knows price
	private String productName;
	//private String productType;
	private String productPrice;
	//VM knows private String productLocation;
	//VM knows private String productAmount;
	private String count;
	




	public VendingMachineProduct(String productName, String productPrice) {
		this.productName = productName;
		//this.productType = productType;
		this.productPrice = productPrice;
		//this.productLocation = productLocation;
		//this.productAmount = productAmount;
		count = "5";
	}
	
	
	
	//*********
	public String getProductName() {
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}
	
	public String toString() {
		return productName + " " + productPrice;
	}

	//*********
	
//	public String productMessage() {
//		String munch = "Munch Munch, Yum!";
//		String crunch = "";
//		String glug = "";
//		String chew = "";
//		if (productType.equals("Candy")) {
//			return munch;
//		} else if (productType.equals("Chip")) {
//			return glug;
//		} else if (productType.equals("Gum")) {
//			return chew;
//		}
//		return crunch;
//		
//	}

}
