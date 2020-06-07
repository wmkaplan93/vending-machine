package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTests {

	
	@Test
	public void return_change_0_test() {
		//Arrange
		VendingMachine testSteve = new VendingMachine(null);
		int[] arrays = new int[4];
		
		
		//Act
		int[] actualOutput = testSteve.returnChange((Double) null);
		
		//Assert
		Assert.assertArrayEquals(arrays, actualOutput);
	}
}
