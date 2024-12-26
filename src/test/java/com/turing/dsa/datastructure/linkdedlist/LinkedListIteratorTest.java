package com.turing.dsa.datastructure.linkdedlist;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class LinkedListIteratorTest {

	@Test
	public void testIterator()
	{
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);

		first.setNext(second);
		second.setNext(third);
		
		LinkedList list =new LinkedList();
		
		list.addFirst(first);
		
		Iterator iterator= list.iterator();
		//first->second->third
		assertEquals(first,iterator.next());
		assertEquals(second,iterator.next());
		assertEquals(third,iterator.next());
		
		
		
	}
}
