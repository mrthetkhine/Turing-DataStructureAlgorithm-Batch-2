package com.turing.dsa.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.turing.dsa.util.Util;

public class HeapTest {
	
	MaxHeap heap = new MaxHeap();
	
	@Test
	public void testIsMaxHeapBaseCase()
	{
		Integer[] data = {10};
		
		heap.setData(Arrays.asList(data));
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testIsMaxHeapRoot()
	{
		Integer[] data = {10,9,8};
		heap.setData(Arrays.asList(data));
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testIsMaxHeapLevel1()
	{
		Integer[] data = {10,9,8,7,5,7,6};
		heap.setData(Arrays.asList(data));
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testIsMaxHeapLevel1NegativeCase()
	{
		Integer[] data = {10,11,8,7,5,7,6};

		heap.setData(Arrays.asList(data));
		assertFalse( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testIsMaxHeapLevel1NegativeCase2()
	{
		Integer[] data = {10,9,8,7,5,7,10};
		
		heap.setData(Arrays.asList(data));
		assertFalse( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testHeapifyBaseCase()
	{
		heap.insert(9);
		//heap.insert(10);
		//heap.insert(15); //15
		
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testHeapifyBaseCaseWithChild()
	{
		heap.insert(9);
		heap.insert(10);
		//heap.insert(15); //15
		
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testHeapifyBaseCaseWithBothChild()
	{
		heap.insert(9);
		heap.insert(10);
		heap.insert(15); //15
		
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testHeapifyComplexCase()
	{
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testHeapifyComplexCaseWithRandom()
	{
		Util util = new Util();
		int arr[] = util.createRandomArray(15);
		
		for(int item :arr)
		{
			heap.insert(item);
		}
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testHeapDeleteLeaf()
	{
		heap.insert(10);
		heap.insert(9);
		heap.insert(8);
		
		heap.delete(9);
		heap.delete(8);
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testHeapDeleteNonLeaf()
	{
		heap.insert(10);
		heap.insert(9);
		heap.insert(8);
		
		heap.delete(10);
		assertTrue( HeapUtil.isMaxHeap(heap));
	}
	@Test
	public void testPeek()
	{
		heap.insert(10);
		heap.insert(9);
		heap.insert(8);
		
		heap.delete(10);
		assertEquals(9,heap.peek());
	}
}
