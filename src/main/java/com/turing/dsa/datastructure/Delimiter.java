package com.turing.dsa.datastructure;
import java.util.ArrayList;
import java.util.Stack;
public class Delimiter {
	ArrayList<Character> startTags = new ArrayList<>();
	ArrayList<Character> endTags = new ArrayList<>();
	
	public Delimiter()
	{
		startTags.add('[');
		endTags.add(']');
		
		startTags.add('{');
		endTags.add('}');
		
	}
		
	public boolean isValid(String input)
	{
		Stack<Character> stack = new Stack<>();
		for(int i=0;i< input.length();i++)
		{
			char ch = input.charAt(i);
			if(isCharStartTag(ch))
			{
				stack.push(ch);
			}
			else if(isCharEngTag(ch))
			{
				if(stack.isEmpty())
				{
					return false;
				}
				//top element must be start with balanced with ch
				if( !isTagBalanced(stack, ch))
				{
					return false;
				}
			
			}
		}
		return stack.isEmpty();
	}

	private boolean isTagBalanced(Stack<Character> stack, char ch) {
		Character topElement = stack.pop();// ] check with [
		int endTagIndex = endTags.indexOf(ch);
		int startTagIndex = startTags.indexOf(topElement);
		if(endTagIndex != startTagIndex)
		{
			return false;
		}
		return true;
	}

	private boolean isCharEngTag(char ch) {
		return endTags.contains(ch);
	}

	private boolean isCharStartTag(char ch) {
		return startTags.contains(ch);
	}
}
