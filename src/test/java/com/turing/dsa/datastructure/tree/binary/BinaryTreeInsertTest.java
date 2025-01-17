package com.turing.dsa.datastructure.tree.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinaryTreeInsertTest {
	@Test
	public void testInsertRoot()
	{
		Node root = new Node(17);
		BinaryTree tree = new BinaryTree(root);
		
		Node insertedNode = tree.insert(15);
		assertEquals(root, insertedNode.getParent());
		assertEquals(insertedNode,root.getLeftChild());
	}
	@Test
	public void testInsertRootRight()
	{
		Node root = new Node(17);
		BinaryTree tree = new BinaryTree(root);
		
		Node insertedNode = tree.insert(30);
		assertEquals(root, insertedNode.getParent());
		assertEquals(insertedNode,root.getRightChild());
	}
	@Test
	public void tesInsertLevel2()
	{
		Node root = new Node(17);
		BinaryTree tree = new BinaryTree(root);
		
		Node firstChild = tree.insert(15);
		Node insertedNode= tree.insert(16);
		
		assertEquals(insertedNode, firstChild.getRightChild());
	
	}
	@Test
	public void tesInsertLevel2LeftChild()
	{
		Node root = new Node(17);
		BinaryTree tree = new BinaryTree(root);
		
		Node firstChild = tree.insert(15);
		Node insertedNode= tree.insert(13);
		
		assertEquals(insertedNode, firstChild.getLeftChild());
	
	}
}
