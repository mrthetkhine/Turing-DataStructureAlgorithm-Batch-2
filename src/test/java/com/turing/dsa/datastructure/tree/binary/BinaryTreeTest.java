package com.turing.dsa.datastructure.tree.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
	
	BinaryTree getBinaryTree()
	{
		Node root= new Node(7);
		Node left =new Node(6);
		Node right = new Node(8);
		
		root.setLeftChild(left);
		root.setRightChild(right);
		
		BinaryTree tree = new BinaryTree(root);
		return tree;
	}
	
	@Test
	public void testTreeCreation()
	{
		BinaryTree tree = getBinaryTree();
		assertEquals(7,tree.root.getValue());
		assertEquals(6,tree.root.getLeftChild().getValue());
		assertEquals(8,tree.root.getRightChild().getValue());
	}
	
	@Test 
	public void testSearchRootNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(7);
		assertEquals(7,resultNode.getValue());
	}
	@Test 
	public void testSearchRightNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(8);
		assertEquals(8,resultNode.getValue());
	}
	@Test 
	public void testSearchLeftNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(6);
		assertEquals(6,resultNode.getValue());
	}
	@Test 
	public void testSearchNonExistingNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(16);
		assertEquals(null,resultNode);
	}
	
}
