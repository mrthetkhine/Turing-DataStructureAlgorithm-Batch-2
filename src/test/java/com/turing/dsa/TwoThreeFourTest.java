package com.turing.dsa;

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
		tree.insert(100);
		tree.insert(120);
		
		Node root =tree.getRoot();//[100,120]
		assertEquals(100,root.keys[0]);
		assertEquals(120,root.keys[1]);
		assertEquals(3,root.noOfNode);
	}
}
