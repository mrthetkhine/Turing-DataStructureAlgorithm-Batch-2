package com.turing.dsa.datastructure.tree.binary.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryTreeWithArrayTest {

	BinaryTreeWithArray tree = new BinaryTreeWithArray();
	BinaryTreeWithArrayTest()
	{
		
		tree.insert(17); //0
		tree.insert(15); //0
		tree.insert(30);
		tree.insert(13); //0
		tree.insert(16);
		tree.insert(18);
		tree.insert(19);
		tree.insert(35);
		
	}
	@Test
	public void testInsertRoot()
	{
		BinaryTreeWithArray tree = new BinaryTreeWithArray();
		int index = tree.insert(17); //0
		//tree.insert(15);//1
		//tree.insert(30);//2
	
		assertEquals(0,index);
		
		/*
		index = tree.indexOf(15);
		assertEquals(1,index);
		
		index = tree.indexOf(30);
		assertEquals(2,index);
		*/
	}
	@Test
	public void testInserLeft()
	{
		BinaryTreeWithArray tree = new BinaryTreeWithArray();
		int index = tree.insert(17); //0
		assertEquals(0,index);
		
		
		index = tree.insert(15);//1
		assertEquals(1,index);
		
		//index = tree.insert(30);
		//assertEquals(2,index);
		
	}
	@Test
	public void testInserRight()
	{
		BinaryTreeWithArray tree = new BinaryTreeWithArray();
		tree.insert(17); //0
		
		int index = tree.insert(30);//1
		assertEquals(2,index);
		
		
	}
	@Test
	public void testInserDepthTwo()
	{
		BinaryTreeWithArray tree = new BinaryTreeWithArray();
		tree.insert(17); //0
		
		int index = tree.insert(15);//1
		tree.insert(30);
		
		index = tree.insert(13);
		assertEquals(3,index);
		
		index = tree.insert(16);
		assertEquals(4,index);
		
		index = tree.insert(18);
		assertEquals(5,index);
		
		index = tree.insert(35);
		assertEquals(6,index);
		
		index = tree.insert(19);
		assertEquals(12,index);
	}
	@Test
	public void testSearch()
	{
		assertEquals(0,tree.search(17));
		assertEquals(1,tree.search(15));
		assertEquals(3,tree.search(13));
		assertEquals(4,tree.search(16));
		assertEquals(5,tree.search(18));
		assertEquals(6,tree.search(35));
		
		assertEquals(12,tree.search(19));
		assertEquals(-1,tree.search(28));
	}
}
