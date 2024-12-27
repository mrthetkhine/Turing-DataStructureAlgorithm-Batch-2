package com.turing.dsa.datastructure.linkdedlist;

import java.util.Iterator;

public class LinkedList implements Iterable{
	protected Node first;
	protected Node last;
	
	protected LinkedList()
	{
		
	}
	protected LinkedList(Node firstNode)
	{
		this.first = firstNode;
		this.last = firstNode;
	}
	protected Node getFirst()
	{
		return this.first;
	}
	protected Node getLast()
	{
		return this.last;
	}
	
	protected void addFirst(int value)
	{
		Node node = new Node(value);
		this.addFirst(node);
	}
	protected void addFirst(Node node)
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
	protected void addLast(int value)
	{
		Node node = new Node(value);
		this.addLast(node);
	}
	protected void addLast(Node node)
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
		
		
		Node previous = null;
		Node current = first;
		Node nodeToDelete =null;
		while( current !=null)
		{
			if(current.value== item)
			{
				//Found node to be deleted
				nodeToDelete = current;
				if(first== current)//it is first node
				{
					this.first = nodeToDelete.next;
					return nodeToDelete;
				}
				else if(previous != null)//middle node && last node
				{
					
					previous.next= nodeToDelete.next;
					
					if(nodeToDelete.next ==null)//last node
					{
						this.last = previous;
					}
					return nodeToDelete;
				}
				
			}
			previous = current;
			current = current.next;
		}
		return null;
	}
	
}
