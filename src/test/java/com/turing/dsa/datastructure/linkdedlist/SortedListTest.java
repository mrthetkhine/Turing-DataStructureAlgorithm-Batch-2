package com.turing.dsa.datastructure.linkdedlist;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class SortedListTest {

	SortedList list = new SortedList();
	
	@Test
	public void testSortedListBaseCaseLargeFirst()
	{
		list.add(10);
		list.add(5); //[5,10]
		
		Iterator iterator = list.iterator();
		assertEquals(5, ((Node)iterator.next()).getValue());
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testSortedListBaseCaseSmallFirst()
	{
		list.add(5);
		list.add(10); //[5,10]
		
		Iterator iterator = list.iterator();
		assertEquals(5, ((Node)iterator.next()).getValue());
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testManyItemFirstInsert()
	{
		list.add(5);
		list.add(10); 
		list.add(2);//[2,5,10]
		
		Iterator iterator = list.iterator();
		assertEquals(2, ((Node)iterator.next()).getValue());
		assertEquals(5, ((Node)iterator.next()).getValue());
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testManyItemLastInsert()
	{
		list.add(5);
		list.add(10); 
		list.add(20);//[5,10,20]
		
		Iterator iterator = list.iterator();
		assertEquals(5, ((Node)iterator.next()).getValue());
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertEquals(20, ((Node)iterator.next()).getValue());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testEqual()
	{
		list.add(5);
		list.add(10); 
		list.add(10); 
		list.add(5); 
		list.add(6);//[5,5,6,10]
		
		Iterator iterator = list.iterator();
		assertEquals(5, ((Node)iterator.next()).getValue());
		assertEquals(5, ((Node)iterator.next()).getValue());
		assertEquals(6, ((Node)iterator.next()).getValue());
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testManyItemMiddleInsert()
	{
		list.add(5);
		list.add(10); 
		list.add(6);//[5,6,10]
		
		Iterator iterator = list.iterator();
		assertEquals(5, ((Node)iterator.next()).getValue());
		assertEquals(6, ((Node)iterator.next()).getValue());
		assertEquals(10, ((Node)iterator.next()).getValue());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testWithRandom()
	{
		Random random = new Random();
		for(int i=0;i<20;i++)
		{
			int item = random.nextInt(100);
			list.add(item);
		}
		Iterator iterator = list.iterator();
		int previous = Integer.MIN_VALUE;
		while(iterator.hasNext())
		{
			Node node =(Node)iterator.next();
			assertTrue(previous<= node.getValue());
			previous = node.getValue();
		}
	}
}
