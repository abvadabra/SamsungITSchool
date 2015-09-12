package ru.redenergy.itschool.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Task1Test {

	@Test
	public void testLastDigit() {
		assertEquals(6, Task1.getLastDigit(6));
		assertEquals(7, Task1.getLastDigit(127));
		assertEquals(9, Task1.getLastDigit(86239));
	}

}
