package com.turing.dsa.datastructure;

public class CircularQueue extends Queue{
	public CircularQueue()
	{
		super();
	}
	public int size() {
		
		return this.tail-this.head;
	}
	public void enqueue(int i) {
		this.tail = this.tail % this.items.length;
		this.items[this.tail++] = i;
	
		
	}
	public int dequeue() {
		
		this.head = this.head% this.items.length;
		return this.items[this.head++];
	}
}
