package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.dsa.util.Util;

public class RadixSortTest {
	Util util = new Util();
	RadixSort algo = new RadixSort();
	
	@Test
	public void testDigitLength()
	{
		
		int arr[] ={100,2000,3};//4
		
		assertEquals(4, algo.digitLen(arr));
		
	}

	@Test
	public void testSort()
	{
		int[]arr = {4,7,5,6,3,1};
		
		arr= algo.sort(arr);
		assertTrue(util.isArraySorted(arr));
		
		System.out.println("Sorted "+util.arrayToString(arr));
	}
	
}
