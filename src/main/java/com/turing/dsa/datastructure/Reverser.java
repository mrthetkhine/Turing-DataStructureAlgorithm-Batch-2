package com.turing.dsa.datastructure;

import java.util.Stack;;
public class Reverser {

	public String reverse(String string) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i< string.length();i++)
		{
			stack.push(string.charAt(i));
			
		}
		String result = "";
		while(!stack.isEmpty())
		{
			result += stack.pop();
			
		}
		return result;
	}

}
