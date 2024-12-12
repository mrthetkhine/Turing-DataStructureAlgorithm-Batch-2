package com.turing.dsa.tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.dsa.util.Util;

public class TestUtil {
	@Test
	public void testZeroArray()
	{
		Util util = new Util();
		int arr[]= {};
		assertTrue(util.isArraySorted(arr));
	}
	@Test
	public void testOneElementArray()
	{
		Util util = new Util();
		int arr[]= {1};
		assertTrue(util.isArraySorted(arr));
	}
	@Test
	public void testMultipleArray()
	{
		Util util = new Util();
		int arr[]= {1,2,3,5,7};
		assertTrue(util.isArraySorted(arr));
	}
	@Test
	public void testMultipleNegativeCase()
	{
		Util util = new Util();
		int arr[]= {1,2,3,5,7,0};
		assertFalse(util.isArraySorted(arr));
	}
	@Test
	public void testNaNCase()
	{
		Util util = new Util();
		int arr[]= {-0,1,2,3,5,7};
		assertTrue(util.isArraySorted(arr));
	}
}
