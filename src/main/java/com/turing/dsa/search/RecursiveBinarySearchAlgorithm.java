package com.turing.dsa.search;

import com.turing.dsa.searching.SearchAlgorithm;

public class RecursiveBinarySearchAlgorithm  {

	
	public int search(int[] input, int item,int left, int right) {
		if(left > right)
		{
			return -1;//not found
		}
		else{
			int middle= (left + right)/2;
			if(input[middle]== item)
			{
				return middle;//found
			}
			else
			{
				
				if( input[middle] <item)
				{
					return search(input, item, middle+1,right);
				}
				else
				{
					return search(input, item, left,middle-1);
				}
			}
		}
	}

}
