package com.turing.dsa.datastructure.tree.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
	
	BinaryTree getBinaryTree()
	{
		Node root= new Node(17);
		Node left =new Node(15);
		Node right = new Node(30);
		
		root.setLeftChild(left);
		root.setRightChild(right);
		
		left.setLeftChild(new Node(13));
		left.setRightChild(new Node(16));
		
		BinaryTree tree = new BinaryTree(root);
		return tree;
	}
	
	@Test
	public void testTreeCreation()
	{
		BinaryTree tree = getBinaryTree();
		assertEquals(17,tree.root.getValue());
		assertEquals(15,tree.root.getLeftChild().getValue());
		assertEquals(30,tree.root.getRightChild().getValue());
	}
	
	@Test 
	public void testSearchRootNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(17);
		assertEquals(17,resultNode.getValue());
	}
	@Test 
	public void testSearchRightNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(15);
		assertEquals(15,resultNode.getValue());
	}
	@Test 
	public void testSearchLeftNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(30);
		assertEquals(30,resultNode.getValue());
	}
	
	@Test 
	public void testSearchNonExistingNode()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(11);
		assertEquals(null,resultNode);
	}
	@Test 
	public void testSearchMultipleDepth()
	{
		BinaryTree tree = getBinaryTree();
		
		Node resultNode = tree.search(16);
		assertEquals(16,resultNode.getValue());
	}
}
