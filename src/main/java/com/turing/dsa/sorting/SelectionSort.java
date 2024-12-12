package com.turing.dsa.sorting;

public class SelectionSort implements SortingAlgorithm{

	@Override
	public void sort(int[] arr) {
		
		for(int i=0;i< arr.length-1;i++)
		{
			int minIndex = i;
			for(int j=i+1;j< arr.length;j++)
			{
				
				if(arr[j] < arr[minIndex])
				{
					minIndex = j;
				}
			}
			int temp= arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;			
			
		}
		
	}

}
