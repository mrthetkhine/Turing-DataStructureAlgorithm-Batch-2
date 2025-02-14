package com.turing.dsa.twothreefour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.two3fourtree.Node;

public class SearchTwoThreeFourTest {
	@Test
	public void testSearchNode()
	{
		Node node = new Node();
		node.insert(120);
		
		Node searchNode = node.search(120);
		assertEquals(node,searchNode);
	}
	@Test
	public void testSearchNodeBaseCase()
	{
		Node node = new Node();
		node.insert(120);
		node.insert(150);
		node.insert(90);
		
		Node searchNode = node.search(90);
		assertEquals(node,searchNode);
	}
	@Test
	public void testSearchNodeBaseCaseNegativeCase()
	{
		Node node = new Node();
		node.insert(100);
		node.insert(120);
		node.insert(150);
		
		Node searchNode = node.search(90);
		assertEquals(null,searchNode);
	}
	
	@Test 
	public void testSearchLevel1Depth()
	{
		/*
		 * 		[120]
			[100]   [150]
		 * */
		Node parent = new Node();
		parent.insert(120);
		
		Node child0 = new Node();
		child0.insert(100);
		child0.parent = parent;
		
		Node child1 = new Node();
		child1.insert(150);
		child1.parent = parent;
		
		parent.children.add(child0);
		parent.children.add(child1);
		
		Node searchNode = parent.search(150);
		assertEquals(child1,searchNode);
	}
	@Test 
	public void testSearchLevel1DepthLeftSide()
	{
		/*
		 * 		[120]
			[100]   [150]
		 * */
		Node parent = new Node();
		parent.insert(120);
		
		Node child0 = new Node();
		child0.insert(100);
		child0.parent = parent;
		
		Node child1 = new Node();
		child1.insert(150);
		child1.parent = parent;
		
		parent.children.add(child0);
		parent.children.add(child1);
		
		Node searchNode = parent.search(100);
		assertEquals(child0,searchNode);
	}
	@Test 
	public void testSearchLevel1ThreeTree()
	{
		/*
		 * 		[120,150]
			[100] [125] [151]	
				
		 * */
		Node parent = new Node();
		parent.insert(120);
		parent.insert(150);
		
		Node child0 = new Node();
		child0.insert(100);
		child0.parent = parent;
		
		Node child1 = new Node();
		child1.insert(125);
		child1.parent = parent;
		
		Node child2 = new Node();
		child2.insert(151);
		child2.parent = parent;
		
		parent.children.add(child0);
		parent.children.add(child1);
		parent.children.add(child2);
		
		Node searchNode = parent.search(100);
		assertEquals(child0,searchNode);
		
		searchNode = parent.search(125);
		assertEquals(child1,searchNode);
		
		searchNode = parent.search(151);
		assertEquals(child2,searchNode);
	}
	@Test 
	public void testSearchLevel1FourTree()
	{
		/*
		 * 		[120,150,200]
			[100] [125] [151] [205]	
				
		 * */
		Node parent = new Node();
		parent.insert(120);
		parent.insert(150);
		parent.insert(200);
		
		Node child0 = new Node();
		child0.insert(100);
		child0.parent = parent;
		
		Node child1 = new Node();
		child1.insert(125);
		child1.parent = parent;
		
		Node child2 = new Node();
		child2.insert(151);
		child2.parent = parent;
		
		Node child3 = new Node();
		child3.insert(205);
		child3.parent = parent;
		
		parent.children.add(child0);
		parent.children.add(child1);
		parent.children.add(child2);
		parent.children.add(child3);
		
		Node searchNode = parent.search(100);
		assertEquals(child0,searchNode);
		
		searchNode = parent.search(125);
		assertEquals(child1,searchNode);
		
		searchNode = parent.search(151);
		assertEquals(child2,searchNode);
		
		searchNode = parent.search(205);
		assertEquals(child3,searchNode);
	}
}
