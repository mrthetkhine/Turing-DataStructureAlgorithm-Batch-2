package com.turing.dsa.sorting;

public class ShellSort implements SortingAlgorithm {

	@Override
	public void sort(int[] arr) {
		int gap = arr.length/2;
		int n = arr.length;
		while(gap >0)
		{
			//System.out.println("Gap "+gap);
			for (int i = gap; i < n; i ++)
			{
				//System.out.println("Compare "+i +" with "+(i+gap));
				int temp = arr[i];
				
				int j;
		        // shift earlier gap-sorted elements up until the correct location for a[i] is found
		        for (j = i; (j >= gap) && (arr[j - gap] > temp); j -= gap)
		        {
		            arr[j] = arr[j - gap];
		        }
		        // put temp (the original a[i]) in its correct location
		        arr[j] = temp;
			}
			gap = gap/2;
		}

	}

}
