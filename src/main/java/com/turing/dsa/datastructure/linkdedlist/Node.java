package com.turing.dsa.datastructure.linkdedlist;

public class Node {
	int value;
	Node next;
	public Node(int value)
	{
		this.value = value;
	}
	public void setNext(Node node)
	{
		this.next= node;
	}
	public int getValue()
	{
		return this.value;
	}
}
