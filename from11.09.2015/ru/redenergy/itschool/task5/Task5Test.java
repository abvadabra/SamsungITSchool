package ru.redenergy.itschool.task5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Task5Test {

	@Test
	public void test() {
		assertEquals(new DisplayedTime(2, 30).toString(), Task5.formatMinutsToSimpleTime(150).toString());
		assertEquals(new DisplayedTime(0, 1).toString(), Task5.formatMinutsToSimpleTime(1441).toString());
	}

}
