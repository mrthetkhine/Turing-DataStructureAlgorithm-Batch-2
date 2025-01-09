package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.dsa.util.Util;

public class TestPartition {
	Util util = new Util();
	
	
	@Test
	public void testPartitionBase()
	{
		int[]arr = {4,7,5,6,3,1};
		QuickSort algo = new QuickSort();
		
		int pivotIndex = algo.findPivot(arr);
		
		System.out.println("Pivot "+arr[pivotIndex]);
		System.out.println("Partitoned "+util.arrayToString(arr));
		
		assertPviotIsCorrect(arr, pivotIndex);
		
	}
	@Test
	public void testPartitionBoundaryCase()
	{
		int[]arr = {9,8,3,7,5,6,4,1};
		QuickSort algo = new QuickSort();
		
		int pivotIndex = algo.findPivot(arr);
		
		System.out.println("Pivot "+arr[pivotIndex]);
		System.out.println("Partitoned "+util.arrayToString(arr));
		assertPviotIsCorrect(arr, pivotIndex);
	
	}

	private void assertPviotIsCorrect(int[] arr, int pivotIndex) {
		int pivot= arr[pivotIndex];
		for(int i=0;i<=pivotIndex;i++)
		{
			assertTrue(arr[i]<=pivot);
		}
		for(int i=pivotIndex+1;i< arr.length;i++)
		{
			assertTrue(arr[i]>=pivot);
		}
	}
}
