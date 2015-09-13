package ru.redenergy.itschool.task4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Task4Test {

	@Test
	public void testNextEvenNumber() {
		assertEquals(8, Task4.nextEvenNumber(7));
		assertEquals(10, Task4.nextEvenNumber(8));
		assertEquals(20, Task4.nextEvenNumber(19));
	}

}
