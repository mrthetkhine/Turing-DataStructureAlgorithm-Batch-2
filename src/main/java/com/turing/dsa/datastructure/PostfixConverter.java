package com.turing.dsa.datastructure;
import java.util.HashMap;
import java.util.Stack;
public class PostfixConverter {

	HashMap<Character,Integer> precedences =new HashMap<>();
	PostfixConverter()
	{
		this.precedences.put('+',1);
		this.precedences.put('-',1);
		
		this.precedences.put('*',2);
		this.precedences.put('/',2);
	}
	// firtOperator >= secondOperator
	boolean isHigherOrEqual(char firstOperator, char secondOperator)
	{
		int firstPrecedence = this.precedences.get(firstOperator);
		int secondPrcedence = this.precedences.get(secondOperator);
		return firstPrecedence>= secondPrcedence;
	}
	boolean isOperator(char ch)
	{
		return ch=='+' || ch=='-' || ch=='*'|| ch=='/';
	}
	boolean isParanthesis(char ch)
	{
		return ch==')' || ch == '(';
	}
	boolean isOperand(char ch)
	{
		return !this.isOperator(ch) && !this.isParanthesis(ch);
	}
	
	/*
	 * Scan all the symbols one by one from left to right in the given Infix Expression.
	If the reading symbol is an operand, then immediately append it to the Postfix Expression.
	If the reading symbol is left parenthesis ‘( ‘, then Push it onto the Stack.
	If the reading symbol is right parenthesis ‘)’, 
		then Pop all the contents of the stack until the respective left parenthesis is popped and append each popped symbol to Postfix Expression.
	
	If the reading symbol is an operator (+, –, *, /), 
		then Push it onto the Stack. 
			However, first, pop the operators which are already on the stack that have higher or equal precedence than the current operator and append them to the postfix. 
			If an open parenthesis is there on top of the stack then push the operator into the stack.
	If the input is over, pop all the remaining symbols from the stack and append them to the postfix.

	 * */
	public String toPostfix(String infix) {
		
		Stack<Character> stack = new Stack<>();
		String postfix = "";
		
		for(int i=0;i< infix.length();i++)
		{
			char ch = infix.charAt(i);
			if(this.isOperand(ch))
			{
				postfix += ch;
			}
			else if(ch=='(')
			{
				stack.push(ch);
			}
			else if(ch==')')
			{
				//If the reading symbol is right parenthesis ‘)’, 
				//then Pop all the contents of the stack until the respective left parenthesis is popped and append each popped symbol to Postfix Expression.
				while( !stack.isEmpty() && stack.peek() != '(')
				{
					postfix += stack.pop();
				}
				if(!stack.isEmpty())
				{
					stack.pop();//pop (
				}
			}
			else if(this.isOperator(ch))
			{
				//pop all operator on stack which is greater than or equal to current one
				outer:{
					if(stack.isEmpty())
					{
						stack.push(ch);
					}
					else 
					{
						while(!stack.isEmpty() )
						{
							if(stack.peek() == '(')
							{
								stack.push(ch);
								break outer;
							}
							else if (this.isHigherOrEqual(stack.peek(), ch))
							{
								postfix += stack.pop();
							}
							else
							{
								stack.push(ch);
							}
							
						}
						stack.push(ch);
					}
					
				}
				
			}
		}
		while(!stack.isEmpty())
		{
			postfix+= stack.pop();
		}
		return postfix;
	}

}
