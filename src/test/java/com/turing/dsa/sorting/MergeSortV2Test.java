package com.turing.dsa.sorting;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.util.Util;

public class MergeSortV2Test {

	Util util = new Util();

	MergeSortV2 algo = new MergeSortV2();
	
	@Test
	public void testSortBaseCase()
	{
		int input[] = {3,1} ;
		algo.sort(input);
		System.out.println("Sorted "+util.arrayToString(input));
		assertTrue(util.isArraySorted(input));
		
	}
	@Test
	public void testSortBaseCaseManyItem()
	{
		int input[] = {3,1,5} ;
		algo.sort(input);
		System.out.println("Sorted "+util.arrayToString(input));
		assertTrue(util.isArraySorted(input));
		
	}
	@Test
	public void testMergeSortRandomData()
	{
		int[] arr = util.createRandomArray(15);
		System.out.println("Input "+util.arrayToString(arr));
		algo.sort(arr);
		System.out.println("Sorted "+util.arrayToString(arr));
		assertTrue(util.isArraySorted(arr));
		
	}
	//@Test
	public void testMerge()
	{
	
		//[1,2,10],[3,4,8]
		int []input = {1,3,5};
	
		//{0,2}{3,5}
		int left = 0;
		int right = input.length-1;
		int middle = (left+right)/2;
		algo.merge(input,left,middle,right );
		System.out.println("Sorted "+util.arrayToString(input));
		assertTrue(util.isArraySorted(input));
	}
	
}
