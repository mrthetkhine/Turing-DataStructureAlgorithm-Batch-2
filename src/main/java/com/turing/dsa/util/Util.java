package com.turing.dsa.util;

import java.util.Random;

public class Util {
	public boolean isArraySorted(int[]arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				return false;
			}
		}
		return true;
	}
	public int[] createRandomArray(int size) {
		Random random = new Random();
		int[]arr = new int[size];
		
		for(int i=0;i< arr.length;i++)
		{
			arr[i] = random.nextInt(400);
		}
		return arr;
	}
	public String arrayToString(int[]arr)
	{
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i< arr.length;i++)
		{
			buffer.append(arr[i]+" ,");
		}
		return buffer.toString();
	}
}
