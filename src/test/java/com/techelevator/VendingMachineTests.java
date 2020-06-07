package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTests {

	//Setup
	
	private VendingMachine testSteve;
	
	@Before
	public void setUp() {
		testSteve = new VendingMachine("vendingmachine.csv");
	}
	
	//End setup
	
	//*********************
	//Return change tests
	//*********************
	@Test
	public void return_change_0_test() {
		//Arrange
		int[] arrays = new int[4];
		
		
		//Act
		int[] actualOutput = testSteve.returnChange(0);
		
		//Assert
		Assert.assertArrayEquals(arrays, actualOutput);
	}
	
	@Test
	public void return_change_actuallyHasMoney() {
		//Arrange
		int[] arrays = new int[] {153 * 4, 0, 0, 0};
		
		//Act
		int[] actualOutput = testSteve.returnChange(153);
		
		//Assert
		Assert.assertArrayEquals(arrays, actualOutput);
	}
	
	@Test
	public void return_change_more_than_quarters() {
		//Arrange
		int[] arrays = new int[] {7, 1, 1, 1};
		
		//Act
		int[] actualOutput = testSteve.returnChange(1.91);
		
		//Assert
		Assert.assertArrayEquals(arrays, actualOutput);
	}
	
	//************************
	//Return change tests end
	//************************
	
	//************************
	//Feed Money Tests
	//************************
	
	@Test
	public void feedMoney_0_returns_0() {
		//Arrange
		int money = 0;
		
		//Act
		double actualOutput = testSteve.feedMoney(0);
		
		//Assert
		Assert.assertEquals(money, actualOutput, 0);
	}
	
	@Test
	public void feedMoney_10_returns_10() {
		//Arrange
		int money = 10;
		
		//Act
		double actualOutput = testSteve.feedMoney(10);
		
		//Assert
		Assert.assertEquals(money, actualOutput, 0);
	}
	
	//************************
	//Feed Money tests end
	//************************
	
	//************************
	//Populate Map tests
	//************************
	
	@Test
	public void populate_map() {
		//Arrange
		//testSteve.populateProductMap();
		
		//Act
		testSteve.populateProductMap();
		
		//Assert
		Assert.assertEquals(testSteve.getProductGenerator().size(), (16));
	}
	
	@Test
	public void map_contains_stuff() {
		//Arrange
		testSteve.populateProductMap();
		
		//Act
		VendingMachineProduct output = testSteve.getProductGenerator().get("B1");
		
		//Assert
		Assert.assertEquals(testSteve.getProductGenerator().get("B1"), output);
	}
	
	@Test
	public void map_contains_key() {
		//Arrange
		testSteve.populateProductMap();
		
		//Act
		
		//Assert
		Assert.assertEquals(testSteve.getProductGenerator().containsKey("B1"), true);
	}
	
	@Test
	public void map_does_not_contain_key() {
		//Arrange
		testSteve.populateProductMap();
		
		//Act
		
		//Assert
		Assert.assertEquals(testSteve.getProductGenerator().containsKey("Z100"), false);
	}
	
	//************************
	//Populate Map tests end
	//************************
	
	
}
