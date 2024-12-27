package com.turing.dsa.datastructure;

import com.turing.dsa.datastructure.linkdedlist.LinkedList;
import com.turing.dsa.datastructure.linkdedlist.Node;

public class QueueByLinkedList extends LinkedList {
	int size = 0;

	public QueueByLinkedList()
	{
		super();
	}
	public void enqueue(int i) {
		
		super.addLast(i);
		this.size ++;
	}

	public int size() {
		
		return this.size;
	}
	public int peek() {
		return super.getFirst().getValue();
	}
	public int dequeue() {
		Node firstNode = super.getFirst();
		super.deleteItem(firstNode.getValue());
		this.size--;
		return firstNode.getValue();
	}

}
