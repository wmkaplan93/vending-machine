package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductMap {
	
	//Map <String, VendingMachineProduct> productGenerator = new HashMap<String, VendingMachineProduct>();
	
	public Map<String, VendingMachineProduct> populateProductMap(Map<String, VendingMachineProduct> productGenerator) {
		
		
		File inputFile = new File("vendingmachine.csv");
		try (Scanner fileInput = new Scanner(inputFile)) {
			
			
			while(fileInput.hasNextLine()) {
				
				String s = fileInput.nextLine();
				System.out.println(s);
				String[] stringArray = s.split("\\|");
				if(stringArray[3].equals("Candy")) {
					Candy productCandy = new Candy(stringArray[1], stringArray[2]);
					productGenerator.put(stringArray[0], productCandy);
				} else if(stringArray[3].equals("Chip")) {
					Chip productChip = new Chip(stringArray[1], stringArray[2]);
					productGenerator.put(stringArray[0], productChip);
				} else if(stringArray[3].equals("Gum")) {
					Gum productGum = new Gum(stringArray[1], stringArray[2]);
					productGenerator.put(stringArray[0], productGum);
				} else {
					Drink productDrink = new Drink(stringArray[1], stringArray[2]);
					productGenerator.put(stringArray[0], productDrink);
				}
				//VendingMachineProduct product1 = new VendingMachineProduct(stringArray[1], stringArray[2]);
				//productGenerator.put(stringArray[0], product1);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return productGenerator;
		
	}
}
