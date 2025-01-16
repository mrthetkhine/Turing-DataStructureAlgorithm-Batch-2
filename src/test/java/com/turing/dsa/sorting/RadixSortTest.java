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
		
		int arr2[]= {10,200,3};//3
		assertEquals(3, algo.digitLen(arr2));
	}
	@Test
	public void testGetDigitAtIndex()
	{
		assertEquals(3,algo.getDigitAtPosition(3,0));
		assertEquals(0,algo.getDigitAtPosition(3,1));
		assertEquals(0,algo.getDigitAtPosition(3,2));//003->3
		
		assertEquals(0,algo.getDigitAtPosition(1,1));
		assertEquals(1,algo.getDigitAtPosition(13,1));
		assertEquals(2,algo.getDigitAtPosition(23,1));
		assertEquals(2,algo.getDigitAtPosition(123,1));
		
		assertEquals(0,algo.getDigitAtPosition(1,2));
		assertEquals(1,algo.getDigitAtPosition(123,2));
		assertEquals(3,algo.getDigitAtPosition(323,2));
	}

	@Test
	public void testSort()
	{
		int[]arr = {4,7,5,6,3,1};
		
		arr= algo.sort(arr);
		assertTrue(util.isArraySorted(arr));
		
		System.out.println("Sorted "+util.arrayToString(arr));
	}
	@Test
	public void testSortRandomData()
	{
		int[]arr = util.createRandomArray(20);
		
		arr= algo.sort(arr);
		assertTrue(util.isArraySorted(arr));
		
		System.out.println("Sorted "+util.arrayToString(arr));
	}
	
}
