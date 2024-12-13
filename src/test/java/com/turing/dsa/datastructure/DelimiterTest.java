package com.turing.dsa.datastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class DelimiterTest {
	Delimiter delimiter = new Delimiter();
	
	@Test
	public void testEmpty()
	{
		boolean valid = delimiter.isValid("");
		assertTrue(valid);
	}
	
	@Test
	public void testBracket()
	{
	
		boolean valid = delimiter.isValid("c[d]");
		assertTrue(valid);
		
		
	}
	@Test
	public void testBracketNegative()
	{
		assertFalse(delimiter.isValid("c[d"));
	}
	@Test
	public void testMultipleDelitmier()
	{
		assertTrue(delimiter.isValid("a{bd}e"));
	}
	@Test
	public void testMultipleDelitmierNeg()
	{
		assertFalse(delimiter.isValid("a{bde"));
	}
}
