package com.turing.dsa.sorting;

public class RadixSort {
	public int digitLen(int[] arr) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
		
		return String.valueOf(max).length();
	}
	
	public int[] sort(int[]arr)
	{
		int length = this.digitLen(arr);
		for(int i=0;i<length;i++)
		{
			
		}
		return arr;
	}
	
}
