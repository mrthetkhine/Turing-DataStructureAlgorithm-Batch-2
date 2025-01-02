package com.turing.dsa.sorting;

public class MergeSort {

	public int[] merge(int[] arr1, int[] arr2) {
		
		int result[] = new int[arr1.length+arr2.length];
		int i=0;
		int j=0;
		
		int k=0;
		while( i < arr1.length && j< arr2.length )
		{
			if( arr1[i]== arr2[j])//equal case
			{
				result[k++] = arr1[i++];
				result[k++] = arr2[j++];
			}
			else if(arr1[i]< arr2[j])
			{
				result[k++] = arr1[i++];
			}
			else
			{
				result[k++] = arr2[j++];
			}
		}
		while(i < arr1.length)
		{
			result[k++] = arr1[i++];
		}
		while(j< arr2.length)
		{
			result[k++] = arr2[j++];
		}
		return result;
	}
	
	public int[] sort(int[] input) {
		if(input.length > 1)
		{
			//split
			int middle = input.length/2;//2
			
			//[0,middle], [middle+1,length]
			
			int[]arr1 = new int[middle];//0-middle
			int k=0;
			//copy arr1
			for(int i=0;i< arr1.length;i++)
			{
				arr1[i] = input[k++];
			}
			int []arr2 = new int [input.length- middle];
			
			//copy arr2 
			for(int j=0;j< arr2.length;j++)
			{
				arr2[j]= input[k++];
			}
			
			//merge
			int result[] = this.merge(arr1, arr2);
			return result;
		}
		else //single item
		{
			return new int[]{input[0]};
		}
		
	}

}
