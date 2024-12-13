package com.turing.dsa.datastructure;

public class Stack {

	int arr [];
	Stack(int size)
	{
		this.arr= new int[size];
	}
	int top=-1;
	
	public int size() {
		
		return top+1;
	}

	public void push(int item) {
		this.arr[++this.top] =item;
		
	}

	public int peek() {
	
		return this.arr[top];
	}

	public int pop() {
		
		return this.arr[top--];
	}
	public boolean isEmpty()
	{
		return this.top==-1;
	}

}
