package com.turing.dsa.sorting;

import com.turing.dsa.util.Util;

public class MergeSortV2 {
	Util util = new Util();
	public void merge(int[] input, int left, int middle, int right) {
		
		//System.out.println("left "+left+" middle "+middle + " right "+right);
		int i= left;
		int j = middle+1;
		int k = 0;
		int len = right-left+1;
		int result[] = new int[len]; 
		while( i <= middle && j<= right )
		{
			if( input[i]== input[j])//equal case
			{
				result[k++] = input[i++];
				
			}
			else if(input[i]< input[j])
			{
				result[k++] = input[i++];
			}
			else
			{
				result[k++] = input[j++];
			}
		}
		while(i <=middle)
		{
			result[k++] = input[i++];
		}
		while(j<=right)
		{
			result[k++] = input[j++];
		}
		
		//System.out.println("Result "+util.arrayToString(result));
		System.arraycopy(result, 0, input, left, len);
	}

	public void mergeSort(int[]input, int left,int middle,int right)
	{
		
		//System.out.println("left "+left + " Middle "+middle+ " right "+right);
		//split,sort
		//merge
		if(left != right)
		{
			//do again;
			//[left,middle]
			int firstMiddle=  (left+middle)/2;
			this.mergeSort(input, left, firstMiddle, middle);
			//[middle+1,right]
			int secondMiddle= (middle+1+right)/2;
			this.mergeSort(input, middle+1, secondMiddle, right);
			
			//merge
			this.merge(input, left, middle, right);
		}
		else
		{
			//single item, already sorted
			//System.out.println("Single item sorted "+input[left]);
			return;
		}
	}
	public void sort(int[]input)
	{
		int left= 0;
		int right = input.length-1;
		int middle = (left+right)/2;
		this.mergeSort(input, left, middle, right);
	}
}
