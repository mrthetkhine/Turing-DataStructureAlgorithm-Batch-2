package com.turing.dsa.datastructure;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PostfixConverterTest {

	PostfixConverter converter = new PostfixConverter();
	
	/*
	@Test
	public void testBaseCase()
	{
		String postfix = converter.toPostfix("a+b");
		
		assertEquals("ab+",postfix);
		assertEquals("ab*",converter.toPostfix("a*b"));
	}
	@Test
	public void testWithMultipleOperator()
	{
		String postfix = converter.toPostfix("a+b-c");
		assertEquals("ab+c-",postfix);
		
	}
	@Test
	public void testWithDifferentPrecedenceOperator()
	{
		String postfix = converter.toPostfix("a*b+c");
		assertEquals("ab*c+",postfix);	
	}
	*/
	@Test
	public void testWithDifferentPrecedenceOperator2()
	{
		String postfix = converter.toPostfix("a+b*c");
		assertEquals("abc*+",postfix);	
		//assertEquals("ab*cd*+",converter.toPostfix("a*b+c*d"));
		//assertEquals("ab/cd*+",converter.toPostfix("a/b+c*d"));
	}
	
	//@Test
	public void testWithParenthesis()
	{
		String postfix = converter.toPostfix("(a+b)*c");
		System.out.println("Postfix "+postfix);
		assertEquals("ab+c*",postfix);	
	}
}
