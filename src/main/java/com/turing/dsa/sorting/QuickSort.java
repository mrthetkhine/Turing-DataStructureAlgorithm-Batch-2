package com.turing.dsa.sorting;

import com.turing.dsa.util.Util;

public class QuickSort {
	Util util = new Util();
	public void sort(int[] arr,int start,int end)
	{
		if(start < end)
		{
			System.out.println(" start "+start + " end "+end);
			int pivotIndex = findPivot(arr,start,end);
			
			System.out.println("Pivot "+arr[pivotIndex] );
			System.out.println("Partitoned "+util.arrayToString(arr));
			
			sort(arr,start,pivotIndex-1);
			sort(arr,pivotIndex+1,end);
		}
	}
	/*
	 * Reference from https://www.programiz.com/dsa/quick-sort
	 *  # choose the rightmost element as pivot
		  pivot = array[high]
		
		  # pointer for greater element
		  i = low - 1
		
		  # traverse through all elements
		  # compare each element with pivot
		  for j in range(low, high):
		    if array[j] <= pivot:
		      # if element smaller than pivot is found
		      # swap it with the greater element pointed by i
		      i = i + 1
		
		      # swapping element at i with element at j
		      (array[i], array[j]) = (array[j], array[i])
		
		  # swap the pivot element with the greater element specified by i
		  (array[i + 1], array[high]) = (array[high], array[i + 1])
		
		  # return the position from where partition is done
		  return i + 1

	 * */
	public int findPivot(int[] arr,int start,int end) {
		int pivot= arr[end];
		int i = start-1;
		
		for(int j=start;j<end;j++)
		{
			if(arr[j]<= pivot)
			{
				i ++;
				int temp= arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		
		System.out.println("PrivotIndex=> "+(i+1));
		return i+1;
				
	}

}
