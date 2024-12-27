package com.turing.dsa.datastructure.linkdedlist;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

	@Test
	public void testInsertFirst()
	{
		LinkedList list = new LinkedList();
		Node first =new Node(10);
		list.addFirst(first);
		
		Node second = new Node(20);
		list.addFirst(second);
		
		Iterator iterator = list.iterator();
		//[second->first]
		assertEquals(second,iterator.next());
		assertEquals(first,iterator.next());
	}
	
	@Test
	public void testInsertFirstMany()
	{
		LinkedList list = new LinkedList();
		Node first =new Node(10);
		list.addFirst(first);
		
		Node second = new Node(20);
		list.addFirst(second);
		
		Node third = new Node(30);
		list.addFirst(third);
		
		Iterator iterator = list.iterator();
		//[third->second->first]
		assertEquals(third,iterator.next());
		assertEquals(second,iterator.next());
		assertEquals(first,iterator.next());
	}
	@Test
	public void testInsertAndIterate()
	{
		LinkedList list = new LinkedList();
		for(int i=0;i<10;i++)
		{
			list.addFirst(new Node(i));
		}
		//[9->8-...1]
		int i=9;
		Iterator iterator = list.iterator();
		while(iterator.hasNext())
		{
			Node node = (Node)iterator.next();
			assertEquals(i--,node.getValue());
		}
	}
	@Test
	public void testInsertLast()
	{
		LinkedList list = new LinkedList();
		Node first =new Node(10);
		list.addLast(first);
		
		Node second = new Node(20);
		list.addLast(second);
		
		Iterator iterator = list.iterator();
		//[first->second]
		assertEquals(first,iterator.next());
		assertEquals(second,iterator.next());
		
	}
	@Test
	public void testInsertLastMany()
	{
		LinkedList list = new LinkedList();
		Node first =new Node(10);
		list.addLast(first);
		
		Node second = new Node(20);
		list.addLast(second);
		
		Node third = new Node(30);
		list.addLast(third);
		
		Iterator iterator = list.iterator();
		//[first->second]
		assertEquals(first,iterator.next());
		assertEquals(second,iterator.next());
		assertEquals(third,iterator.next());
		
	}
	
	@Test
	public void testInsertLastAndIterate()
	{
		LinkedList list = new LinkedList();
		for(int i=0;i<10;i++)
		{
			list.addLast(new Node(i));
		}
		//[0-->9]
		int i=0;
		Iterator iterator = list.iterator();
		while(iterator.hasNext())
		{
			Node node = (Node)iterator.next();
			assertEquals(i++,node.getValue());
		}
	}
	@Test
	public void testAddFirstAddLastMixedCall()
	{
		LinkedList list = new LinkedList();
		list.addFirst(new Node(10));
		//[10]
		list.addFirst(new Node(20));
		//[20,10]
		list.addLast(new Node(30));
		//[20,10,30]
		
		list.addFirst(new Node(5));
		//[5,20,10,30]
		Iterator iterator = list.iterator();
		
		assertEquals(5,((Node)iterator.next()).getValue());
		assertEquals(20,((Node)iterator.next()).getValue());
		assertEquals(10,((Node)iterator.next()).getValue());
		assertEquals(30,((Node)iterator.next()).getValue());
	}
	
	
	@Test
	public void testSearch()
	{
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		
		Node item = list.find(10);
		//assertNotNull(item);
		assertEquals(10, item.getValue());
		assertEquals(20, ((Node)list.find(20)).getValue());
		assertEquals(30, ((Node)list.find(30)).getValue());
		assertEquals(40, ((Node)list.find(40)).getValue());
	}
	@Test
	public void testSearchNegativeCase()
	{
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		
		Node item = list.find(100);
		//assertNotNull(item);
		assertNull( item);
		assertNull( list.find(200));
	}
	@Test
	public void testDeleteFirstWhenOnlyOneItem()
	{
		LinkedList list = new LinkedList();
		list.addFirst(10);
	
		
		Node item = list.deleteItem(10);
		assertEquals(10, item.getValue());
		
		
	}
	@Test
	public void testDeleteFirstWhenMultipleItem()
	{
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		
		assertNotNull(list.find(10));
		Node item = list.deleteItem(10);
		assertEquals(10, item.getValue());
		
		
		Iterator iterator = list.iterator();
		assertEquals(20, ((Node)iterator.next()).getValue());
		assertEquals(30, ((Node)iterator.next()).getValue());
		assertEquals(40, ((Node)iterator.next()).getValue());
		assertFalse( iterator.hasNext());
		
	}
	@Test
	public void testDeleteMiddleNode()
	{
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		
	
		Node item = list.deleteItem(20);
		assertEquals(20, item.getValue());
		//[10,30,40]
		
		
		Iterator iterator = list.iterator();
		
		assertEquals(10, list.getFirst().getValue());
		
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertEquals(30, ((Node)iterator.next()).getValue());
		assertEquals(40, ((Node)iterator.next()).getValue());
		assertFalse( iterator.hasNext());
		
	}
	@Test
	public void testDeleteLastNode()
	{
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		
	
		Node item = list.deleteItem(40);
		assertEquals(40, item.getValue());
		//[10,30,40]
		
		
		Iterator iterator = list.iterator();
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertEquals(20, ((Node)iterator.next()).getValue());
		assertEquals(30, ((Node)iterator.next()).getValue());
		
		assertEquals(30, list.getLast().getValue());
		assertFalse( iterator.hasNext());
		
	}
	@Test
	public void testMultipleDeleteNode()
	{
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		
		//[10,20,30,40]
		list.deleteItem(30);
		
		//[10,20,40]
		list.deleteItem(40);
		//[10,20]
		list.deleteItem(10);
		
		//[20]
		
		Iterator iterator = list.iterator();
		assertEquals(20, ((Node)iterator.next()).getValue());
		assertFalse( iterator.hasNext());
		
		assertEquals(20, list.getFirst().getValue());
		assertEquals(20, list.getLast().getValue());
		
		
	}
}
