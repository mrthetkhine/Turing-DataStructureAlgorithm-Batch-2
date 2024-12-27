package com.turing.dsa.datastructure.linkdedlist;

public class SortedList extends LinkedList{
	public void add(int item)
	{
		if(super.first == null)
		{
			this.addFirst(item);
		}
		else
		{
			Node current = this.first;
			Node previous = null;
			
			//find item large than this item
			while( current !=null)
			{
				if(current.value > item)
				{
					break;
				}
				previous = current;
				current = current.next;
			}
			Node nodeToInsert = new Node(item);
			nodeToInsert.setNext(current);
			
			if(previous == null)//first node
			{
				this.first = nodeToInsert;
			}
			else
			{
				previous.setNext(nodeToInsert);
			}
		}
	}
}
