package com.turing.dsa.recursion;

public class Factorial {

	public int factorial(int n) {
		if(n==0)
		{
			return 1;//base case
		}
		else 
		{
			return n* factorial(n-1);
		}
	}

}
