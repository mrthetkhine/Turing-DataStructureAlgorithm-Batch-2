package com.turing.dsa.sorting;

public class InsertionSort implements SortingAlgorithm{

	@Override
	public void sort(int[] arr) {
		
		for(int i=1;i< arr.length;i++)
		{
			int j=i;
			while(j>0 && arr[j]<arr[j-1])
			{
				//swap
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}	
		}
		
	}

}
