package com.turing.dsa.sorting;

public class QuickSort {

	public int findPivot(int[] arr) {
		int tempPivotIndex = 0;
		
		int left = tempPivotIndex;
		int right = arr.length-1;
		
		int pivot = arr[tempPivotIndex];
		while(left <arr.length && left < right)
		{
			while( left<arr.length-1 && arr[left]< pivot && left<right)
			{
				left++;
			}
			while(arr[right]>pivot && right > left)
			{
				right --;
			}
			//exchange left , right
			System.out.println("Left "+left+ " right "+right);
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		//left == right
		System.out.println("Pivot "+pivot);
		System.out.println("Left "+arr[left]);
		
		
		if(arr[left] < pivot)
		{
			int temp = arr[left];
			arr[left] = arr[tempPivotIndex];
			arr[tempPivotIndex] = temp;
			System.out.println("Return pivot "+pivot);
			return left;
		}
		return tempPivotIndex;
		
	}

}
