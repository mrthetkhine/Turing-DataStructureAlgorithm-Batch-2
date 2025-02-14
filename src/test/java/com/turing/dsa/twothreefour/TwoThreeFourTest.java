package com.turing.dsa.twothreefour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.two3fourtree.Node;
import com.turing.dsa.two3fourtree.TwoThreeFourTree;

public class TwoThreeFourTest {
	@Test
	public void testInsertBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		
		Node root =tree.getRoot();
		assertEquals(100,root.keys[0]);
		assertEquals(2,root.noOfNode);
	}
	@Test
	public void testInsertSmallBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(90);
		
		Node root =tree.getRoot();//[90,100]
		assertEquals(90,root.keys[0]);
		assertEquals(100,root.keys[1]);
		assertEquals(3,root.noOfNode);
	}
	@Test
	public void testInsertLargeBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		Node insertedNode = null;
		tree.insert(100);
		insertedNode = tree.insert(120);
		
		Node root =tree.getRoot();//[100,120]
		assertEquals(100,root.keys[0]);
		assertEquals(120,root.keys[1]);
		assertEquals(3,root.noOfNode);
	}
	@Test
	public void testInsertSmallBaseCaseFourNode()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		Node insertedNode = tree.insert(120);
		
		//Node root =tree.getRoot();//[100,120,150]
		assertEquals(100,insertedNode.keys[0]);
		assertEquals(120,insertedNode.keys[1]);
		assertEquals(150,insertedNode.keys[2]);
		assertEquals(4,insertedNode.noOfNode);
	}
	
	@Test
	public void testSplitBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		
		////[100,120,150]
		
		Node insertedNode = tree.insert(200);
		
		/*	
		 * 			[120]
		 * 		[100] [150]
		 * */
		Node parent = insertedNode.splitWhenNoParent(insertedNode);
		assertEquals(2,parent.noOfNode);
		assertEquals(120,parent.keys[0]);
		assertEquals(2,parent.children.size());
		
		Node child0 =parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 =parent.children.get(1);
		assertEquals(150,child1.keys[0]);
	
	}
	@Test
	public void testInsertSplitBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		
		////[100,120,150]
		
		Node insertedNode = tree.insert(200);
		
		/*
		 * 		
		 * 			 [120]
		 * 		[100] [150,200]
		 * */
		Node parent = insertedNode.parent;
		assertEquals(120,parent.keys[0]);
		
		Node child0 = parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 = parent.children.get(1);
		assertEquals(150,child1.keys[0]);
		assertEquals(200,child1.keys[1]);
	
	}
}
