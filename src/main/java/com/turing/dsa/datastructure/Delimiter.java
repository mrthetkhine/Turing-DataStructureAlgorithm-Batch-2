package com.turing.dsa.datastructure;
import java.util.Stack;
public class Delimiter {
	public boolean isValid(String input)
	{
		Stack stack = new Stack<>();
		for(int i=0;i< input.length();i++)
		{
			char ch = input.charAt(i);
			if(ch== '[')//start tag
			{
				stack.push(ch);
			}
			else if(ch==']')
			{
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
