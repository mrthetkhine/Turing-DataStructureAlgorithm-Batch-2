package com.turing.dsa.datastructure.linkdedlist;

import java.util.Iterator;

public class LinkedList implements Iterable{
	Node first;
	Node last;
	
	LinkedList()
	{
		
	}
	LinkedList(Node firstNode)
	{
		this.first = firstNode;
		this.last = firstNode;
	}
	void addFirst(int value)
	{
		Node node = new Node(value);
		this.addFirst(node);
	}
	void addFirst(Node node)
	{
		if(this.first==null)//first time 
		{
			this.first = node;
			this.last = node;
		}
		else
		{
			node.setNext(this.first);
			this.first = node;
		}
	}
	void addLast(int value)
	{
		Node node = new Node(value);
		this.addLast(node);
	}
	void addLast(Node node)
	{
		if(this.last ==null && this.first==null)//first time
		{
			this.last = node;
			this.first = node;
		}
		else
		{
			this.last.setNext(node);
			this.last = node;
		}
		
	}
	@Override
	public Iterator iterator() {
		
		return new ListIterator();
	}
	class ListIterator implements Iterator
	{
		Node current;
		ListIterator()
		{
			this.current = first;
		}
		
		
		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public Node next() {
			Node temp = current;
			if(current!=null)
			{
				current = current.next;	
			}
			return temp;
		}
		
	}
	
	public static void main(String[]args)
	{
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);

		first.setNext(second);
		second.setNext(third);
		
		LinkedList list =new LinkedList();
		
		list.addFirst(first);
		
		Iterator iterator= list.iterator();
		while(iterator.hasNext())
		{
			Node node = (Node) iterator.next();
			System.out.println("item "+node.getValue());
		}
	}
	public Node find(int item) {
		Node current = this.first;
		while(current!=null)
		{
			int currentValue = current.value;
			if(currentValue == item)
			{
				return current;
			}
			current = current.next;
		}
		return null;
	}
	public Node deleteItem(int item) {
		System.out.println("First value "+this.first.value);
		Node nodeToDelete = this.find(item);
		if(nodeToDelete !=null)//positive case.
		{
			System.out.println("Node value "+nodeToDelete.value + " first node value "+this.first.value);
			System.out.println("Node found to delete nodeToDelete "+nodeToDelete + " first "+this.first);
			if(this.first == nodeToDelete)//first item
			{
				System.out.println("Delete First Node is first node");
				if(first== last)//single item
				{
					System.out.println("only single item");
					this.first = null;
					this.last= null;
					return nodeToDelete;
				}
				else //many item
				{
					this.first = nodeToDelete.next;
					System.out.println("Delete First many item");
					return nodeToDelete;
				}
				
			}
		}
		return null;
	}
	
}
