package com.turing.dsa.datastructure;
import com.turing.dsa.datastructure.linkdedlist.*;
public class StackByLinkedList extends LinkedList{

	int size =0;
	StackByLinkedList() {
		super();
		
	}

	public void push(int i) {
		super.addLast(i);
		this.size++;
	}

	public int size() {
		return this.size;
	}

	public int peek() {
		return this.getLast().getValue();
	}
	void deleteLast()
	{
		Node lastNode = this.getLast();
		
		Node current = this.getFirst();
		Node previous = null;
		while(current!= lastNode)
		{
			previous = current;
			current = current.getNext();
		}
		if(previous !=null)
		{
			previous.setNext(null);
		}
		
		super.last = previous;
		
	}
	public int pop() {
		Node lastNode = this.getLast();
		this.deleteLast();
		this.size --;
		return lastNode.getValue();
	}

}
