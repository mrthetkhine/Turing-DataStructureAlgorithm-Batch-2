package com.turing.dsa.datastructure;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseTest {
	Reverser reverser = new Reverser();
	@Test
	public void testEmpty()
	{
		
		String output = reverser.reverse("");
		assertEquals("",output);
	}
	@Test
	public void testSingle()
	{
		
		String output = reverser.reverse("a");
		assertEquals("a",output);
	}
	@Test
	public void testMultiple()
	{
		
		String output = reverser.reverse("car");
		assertEquals("rac",output);
		
		output = reverser.reverse("hello");
		assertEquals("olleh",output);
	}
}

