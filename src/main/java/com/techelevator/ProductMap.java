package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductMap {
	
	Map <String, VendingMachineProduct> productGenerator = new HashMap<String, VendingMachineProduct>();
	
	public void populateProductMap() {
		File inputFile = new File("vendingmachine.csv");
		try (Scanner fileInput = new Scanner(inputFile)) {
			
			while(fileInput.hasNextLine()) {
				
				String s = fileInput.nextLine();
				System.out.println(s);
				String[] stringArray = s.split("\\|");
				VendingMachineProduct product1 = new VendingMachineProduct(stringArray[1], stringArray[2]);
				productGenerator.put(stringArray[0], product1);
				System.out.println(product1);
				System.out.println(stringArray.length);
				System.out.println(productGenerator.keySet());

				
				
			}
			System.out.println(productGenerator);
			System.out.println(productGenerator.keySet());
			productGenerator.keySet().toString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
