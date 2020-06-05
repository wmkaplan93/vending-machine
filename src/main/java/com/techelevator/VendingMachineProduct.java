package com.techelevator;

public abstract class VendingMachineProduct {
	
	//they know what they are
	//know type (candy/soda/chips/gum)
	private String productName;
	private String productPrice;
	protected int count;
	




	public VendingMachineProduct(String productName, String productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
		//count = 5;
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
	
	public int getCount() {
		return count;
	}
	
	abstract String returnMessage();
	
	abstract String reduceCount();
	
	abstract String displayCount();

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
