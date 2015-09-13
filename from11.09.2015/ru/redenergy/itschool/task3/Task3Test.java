package ru.redenergy.itschool.task3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Task3Test {

	@Test
	public void testSumDigits() {
		assertEquals(8 + 8 + 8, Task3.sumDigits(888));
		assertEquals(1 + 2 + 7, Task3.sumDigits(127));
		assertEquals(1, Task3.sumDigits(1000000000));
	}

}
