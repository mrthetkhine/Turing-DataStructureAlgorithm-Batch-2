package com.turing.dsa.sorting;

import java.util.ArrayList;

public class RadixSort {
	private static final int MAX_DIGIT = 10;

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
			//Bucket 10;
			//Initialize
			var items = new ArrayList<ArrayList<Integer>>(); 
			for(int j=0;j<MAX_DIGIT;j++)
			{
				ArrayList<Integer> list =new ArrayList<>();
				items.add(list);
			}
			//Collect digit into bucket according to position
			for(int k=0;k<arr.length;k++)
			{
				int index = this.getDigitAtPosition(arr[k], i);
				items.get(index).add(arr[k]);
			}
			//collect bucket list to single arraylist
			ArrayList<Integer> allItem = new ArrayList<>();
			for(int j=0;j<MAX_DIGIT;j++)
			{
				ArrayList<Integer> list = items.get(j);
				allItem.addAll(list);
			}
			//copied back to array
			for(int k=0;k<arr.length;k++)
			{
				arr[k] = allItem.get(k);
			}
		}
		return arr;
	}

	public int getDigitAtPosition(int num, int position) {
		String str = String.valueOf(num);
		if(position <= str.length()-1 )
		{
			int index  = str.length()-(position+1);
			char ch = str.charAt(index);
			return Integer.valueOf(ch+"");
		}
		else
		{
			return 0;
		}
		
	}
	
}
