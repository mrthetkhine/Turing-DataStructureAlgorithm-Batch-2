package com.turing.dsa.sorting;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.util.Util;

public class MergeSortTest {

	Util util = new Util();

	MergeSort algo = new MergeSort();
	
	@Test
	public void testMerge()
	{
		MergeSort algo = new MergeSort();
	
		int []arr1 = {1,4};
		int []arr2 = {2,5};
		int result[] = algo.merge(arr1,arr2); //[1,2,4,5]
		assertEquals(4, result.length);
		assertTrue(util.isArraySorted(result));
	}
	@Test
	public void testMergeEqual()
	{
		MergeSort algo = new MergeSort();
	
		int []arr1 = {1,4};
		int []arr2 = {1,2,5};
		int result[] = algo.merge(arr1,arr2); //[1,1,2,4,5]
		assertTrue(util.isArraySorted(result));
	}
	@Test
	public void testMergeUnEqualSize()
	{
		MergeSort algo = new MergeSort();
	
		int []arr1 = {1,4,7,9};
		int []arr2 = {1,2,5};
		int result[] = algo.merge(arr1,arr2);
		assertTrue(util.isArraySorted(result));
	}
	@Test
	public void testMergeUnEqualSizeTwo()
	{
		MergeSort algo = new MergeSort();
	
		int []arr1 = {1,4,7,9};
		int []arr2 = {1,2,5,6,10,12,20};
		int result[] = algo.merge(arr1,arr2);
		assertTrue(util.isArraySorted(result));
	}
	
	@Test
	public void testSort()
	{
		int input[] = {3,1} ;
		int result[] = algo.sort(input);
		assertTrue(util.isArraySorted(result));
	}
	@Test
	public void testSortManyItem()
	{
		int input[] = {3,1,4,2} ;
		int result[] = algo.sort(input);
		assertTrue(util.isArraySorted(result));
	}
	@Test
	public void tesSortRandomData()
	{
		int[] arr = util.createRandomArray(21);
		System.out.println("Input "+util.arrayToString(arr));
		int result [] = algo.sort(arr);
		System.out.println("Sorted "+util.arrayToString(result));
		assertTrue(util.isArraySorted(result));
		
	}
}
