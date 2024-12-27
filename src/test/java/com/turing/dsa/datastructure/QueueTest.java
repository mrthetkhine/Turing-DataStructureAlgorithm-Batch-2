package com.turing.dsa.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class QueueTest {
	
	//Queue queue = new Queue();
	QueueByLinkedList queue = new QueueByLinkedList();
	
	@Test
	public void testEnqueue()
	{
		
		queue.enqueue(100);
		
		assertEquals(1,queue.size());
		assertEquals(100,queue.peek());
	}
	
	@Test
	public void testEnqueueTwo()
	{
		queue.enqueue(200);
		
		assertEquals(1,queue.size());
		assertEquals(200,queue.peek());
	}
	
	@Test
	public void testEnqueueMultipleItem()
	{
		
		queue.enqueue(200);
		queue.enqueue(300);
		
		assertEquals(2,queue.size());
		assertEquals(200,queue.peek());
	}
	
	@Test
	public void testSize()
	{

		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(400);
		
		assertEquals(3,queue.size());
		assertEquals(200,queue.peek());
	}
	
	@Test
	public void testDeuque()
	{
	
		queue.enqueue(200);
		
		int item = queue.dequeue();
		assertEquals(200,item);	
	}
	
	@Test
	public void testDeuqueTwo()
	{
		queue.enqueue(300);
		queue.enqueue(200);
		
		int item = queue.dequeue();
		assertEquals(300,item);	
	}
	
	@Test
	public void testQueueBoundary()
	{

		for(int i=0;i<10;i++)
		{
			queue.enqueue(i);
		}
		assertEquals(10,queue.size());
		for(int i=0;i<10;i++)
		{
			int item = queue.dequeue();
			assertEquals(i,item);
		}
	}
	/*
	@Test
	public void testTailLessThanHead()
	{
		queue.enqueue(300);
		queue.enqueue(200);
		
		int item = queue.dequeue();
		queue.dequeue();
		
		RuntimeException excep = assertThrows(RuntimeException.class, ()->{
			queue.dequeue();
		});
		assertEquals("Queue is empty",excep.getMessage());
		assertEquals(300,item);	
	}
	/*
	@Test
	public void testNormaldQueueLimitation()
	{
	
		for(int i=0;i<10;i++)
		{
			queue.enqueue(i);
		}
		assertEquals(10,queue.size());
		for(int i=0;i<10;i++)
		{
			int item = queue.dequeue();
			assertEquals(i,item);
		}
		RuntimeException excep = assertThrows(RuntimeException.class, ()->{
			queue.enqueue(100);
		});
		assertEquals("Queue is full",excep.getMessage());
		
	}
	*/
}
