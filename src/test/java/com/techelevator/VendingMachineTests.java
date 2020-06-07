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
		int[] actualOutput = testSteve.returnChange(0);
		
		//Assert
		Assert.assertArrayEquals(arrays, actualOutput);
	}
	
	@Test
	public void return_change_actuallyHasMoney() {
		VendingMachine testSteve = new VendingMachine(null);
		int[] arrays = new int[] {153 * 4, 0, 0, 0};
		int[] actualOutput = testSteve.returnChange(153);
		Assert.assertArrayEquals(arrays, actualOutput);
	}
	
}
