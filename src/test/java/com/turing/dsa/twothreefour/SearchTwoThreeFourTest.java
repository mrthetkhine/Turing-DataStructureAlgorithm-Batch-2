package com.turing.dsa.twothreefour;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	@Test
	public void testDepth3()
	{
		/*
		 * 	            [205]
			    [150]        	[215,300]->level1
			[120] [200]    [210] [250] [310,350] ->level2
		 * */
		Node parent = new Node();
		parent.insert(205);
		
		Node level1Child0 = new Node();
		level1Child0.insert(150);
		level1Child0.parent = parent;
		
		Node level1Child1 = new Node();
		level1Child1.insert(215);
		level1Child1.insert(300);
		level1Child1.parent = parent;
		
		parent.children.add(level1Child0);
		parent.children.add(level1Child1);
		
		Node level2Child0 = new Node();
		level2Child0.insert(120);
		level2Child0.parent = level1Child0;
		
		Node level2Child1= new Node();
		level2Child1.insert(200);
		level2Child1.parent = level1Child0;
		
		level1Child0.children.add(level2Child0);
		level1Child0.children.add(level2Child1);
		
		
		//========
		Node rightLevel1Child0 = level1Child1;
		
		Node rightLevel2Child0 = new Node();
		rightLevel2Child0.insert(210);
		rightLevel2Child0.parent = rightLevel1Child0;
		
		Node rightLevel2Child1 = new Node();
		rightLevel2Child1.insert(250);
		rightLevel2Child1.parent =rightLevel1Child0;
		
		Node rightLevel2Child2 = new Node();
		rightLevel2Child2.insert(310);
		rightLevel2Child2.insert(350);
		rightLevel2Child2.parent =rightLevel1Child0;

		rightLevel1Child0.children.add(rightLevel2Child0);
		rightLevel1Child0.children.add(rightLevel2Child1);
		rightLevel1Child0.children.add(rightLevel2Child2);
		
		Node searchNode = parent.search(350);
		//System.out.println("SearchNode "+searchNode);
		assertEquals(rightLevel2Child2,searchNode);
		
		searchNode = parent.search(310);
		assertEquals(rightLevel2Child2,searchNode);
		
		searchNode = parent.search(120);
		assertEquals(level2Child0,searchNode);
		
		searchNode = parent.search(210);
		assertEquals(rightLevel2Child0,searchNode);
		
		searchNode = parent.searchForInsert(351);
		System.out.println("SearchNode for insert--> "+searchNode);
		assertEquals(rightLevel2Child2,searchNode);
		assertTrue(searchNode.isLeaf());
		
		searchNode = parent.searchForInsert(214);
		System.out.println("SearchNode for insert--> "+searchNode);
		assertEquals(rightLevel2Child0,searchNode);
		assertTrue(searchNode.isLeaf());
	}
}
