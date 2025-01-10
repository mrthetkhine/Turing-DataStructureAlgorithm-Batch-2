package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.dsa.util.Util;

public class QuickSortTest {
	Util util = new Util();
	
	QuickSort algo = new QuickSort();
	
	//@Test
	public void testPartitionIssue()
	{
		int[]arr = {97 ,106 ,119 ,111 ,250 };
		
		
		int pivotIndex = algo.findPivot(arr,2,arr.length-1);
		
		System.out.println("Pivot "+arr[pivotIndex]);
		System.out.println("Partitoned "+util.arrayToString(arr));
		
		assertPviotIsCorrect(arr, pivotIndex,2,arr.length-1);
		
	}
	//@Test
	public void testPartitionBase()
	{
		int[]arr = {97 ,106 ,119 ,111 ,250 };
		
		
		int pivotIndex = algo.findPivot(arr,2,arr.length-1);
		
		System.out.println("Pivot "+arr[pivotIndex]);
		System.out.println("Partitoned "+util.arrayToString(arr));
		
		assertPviotIsCorrect(arr, pivotIndex,2,arr.length-1);
		
	}
	//@Test
	public void testPartitionBoundaryCase()
	{
		int[]arr = {209 ,64,8 ,186 ,33 ,9 };
		
		
		int pivotIndex = algo.findPivot(arr,0,arr.length-1);
		
		System.out.println("Pivot "+arr[pivotIndex]);
		System.out.println("Partitoned "+util.arrayToString(arr));
		assertPviotIsCorrect(arr, pivotIndex,0,arr.length-1);
	
	}
	@Test
	public void testPartiionOnRandomData()
	{
		int[]arr = util.createRandomArray(5);
		
		
		System.out.println("Before "+util.arrayToString(arr));
		int pivotIndex = algo.findPivot(arr,0,arr.length-1);
		
		System.out.println("Pivot "+arr[pivotIndex]);
		System.out.println("Partitoned "+util.arrayToString(arr));
		assertPviotIsCorrect(arr, pivotIndex,0,arr.length-1);
	
	}
	private void assertPviotIsCorrect(int[] arr, int pivotIndex,int start,int end) {
		int pivot= arr[pivotIndex];
		for(int i=start;i<=pivotIndex;i++)
		{
			assertTrue(arr[i]<=pivot);
		}
		for(int i=pivotIndex+1;i< end;i++)
		{
			assertTrue(arr[i]>=pivot);
		}
	}
	@Test
	public void testQuickSort()
	{
		int[]arr = util.createRandomArray(5);
		//int []arr = {8, 7, 2, 1, 0, 9, 6};
		System.out.println("Before "+util.arrayToString(arr));
		
		algo.sort(arr, 0, arr.length-1);
		
		System.out.println("After "+util.arrayToString(arr));
		assertTrue(util.isArraySorted(arr));
	}
}
