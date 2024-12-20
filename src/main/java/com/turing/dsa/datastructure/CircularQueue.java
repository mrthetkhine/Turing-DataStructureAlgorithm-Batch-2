package com.turing.dsa.datastructure;

public class CircularQueue extends Queue{
	int size = 0;
	public CircularQueue()
	{
		super();
	}
	public int size() {
		
		return this.size;	
	}
	
	boolean isEmpty()
	{
		return this.size==0;
	}
	boolean isFull()
	{
		return this.size== this.items.length;
	}
	public void enqueue(int i) {
		
		if(isFull())
		{
			throw new RuntimeException("Queue is full");
		}
		else
		{
			this.tail = this.tail % this.items.length;
			this.items[this.tail++] = i;
			
			this.size ++;
		}
			
	}
	public int dequeue() {
		
		if(this.isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		else
		{
			this.head = this.head% this.items.length;
			this.size --;
			return this.items[this.head++];
		}
		
	}
}
