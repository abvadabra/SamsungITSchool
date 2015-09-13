package ru.redenergy.itschool.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Task2Test {

	@Test
	public void testNumberOfTens() {
		assertEquals(5, Task2.getNumberOfTens(55));
		assertEquals(8, Task2.getNumberOfTens(86));
		assertEquals(15, Task2.getNumberOfTens(158));
		assertEquals(9, Task2.getNumberOfTens(91));
	}

}
