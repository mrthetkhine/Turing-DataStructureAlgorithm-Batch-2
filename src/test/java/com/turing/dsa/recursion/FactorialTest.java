package com.turing.dsa.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactorialTest {
	Factorial fact = new Factorial();
	
	@Test 
	public void testZeroFactorial()
	{
		
		int result = fact.factorial(0);
		assertEquals(1,result);
		assertEquals(1,fact.factorial(1));
		assertEquals(6,fact.factorial(3));
		assertEquals(24,fact.factorial(4));
		
		//fact.factorial(100000);
	}
}
