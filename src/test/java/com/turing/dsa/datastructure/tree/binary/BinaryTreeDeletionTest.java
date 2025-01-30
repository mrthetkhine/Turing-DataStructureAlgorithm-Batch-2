package com.turing.dsa.datastructure.tree.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryTreeDeletionTest {

	BinaryTree tree;
	public BinaryTreeDeletionTest()
	{
		Node root = new Node(17);
		tree = new BinaryTree(root);
		tree.insert(15);
		tree.insert(30);
		tree.insert(13);
		tree.insert(16);
		tree.insert(18);
		tree.insert(35);
		tree.insert(19);
	}
	@Test
	void testSuccessor()
	{
		//17 ->successor 18
		Node successor = this.tree.getSuccessorOf(17);
		assertEquals(18,successor.getValue());
		
		successor = this.tree.getSuccessorOf(30);
		assertEquals(35,successor.getValue());
		
		successor = this.tree.getSuccessorOf(15);
		assertEquals(16,successor.getValue());
	}
	
	@Test
	void testSuccessorTwo()
	{
		Node root = new Node(50);
		tree = new BinaryTree(root);
	
		tree.insert(75);
		tree.insert(62);
		tree.insert(87);
		tree.insert(93);
		
		Node successor = this.tree.getSuccessorOf(75);
		assertEquals(87,successor.getValue());
		
		
	}
	@Test
	public void testIsBinarySearchTree()
	{
		assertEquals(true, TreeUtil.isBinarySearchTree(tree));
	}
	
	@Test 
	public void testDeleteLeaf()
	{
		//Leaf node 13,16,19,35?

		Node deletedNode = this.tree.deleteNode(13);
		assertEquals(13,deletedNode.getValue());
		assertEquals(true, TreeUtil.isBinarySearchTree(tree));
		
		Node node = this.tree.search(13);
		assertEquals(null,node);
		
		deletedNode = this.tree.deleteNode(16);
		assertEquals(16,deletedNode.getValue());
		assertEquals(true, TreeUtil.isBinarySearchTree(tree));
		
		node = this.tree.search(16);
		assertEquals(null,node);
		
		deletedNode = this.tree.deleteNode(19);
		assertEquals(19,deletedNode.getValue());
		assertEquals(true, TreeUtil.isBinarySearchTree(tree));
		
		node = this.tree.search(19);
		assertEquals(null,node);
		
		
	}
	@Test 
	public void testDeleteLeafTwo()
	{
		Node deletedNode = this.tree.deleteNode(35);
		assertEquals(35,deletedNode.getValue());
		assertEquals(true, TreeUtil.isBinarySearchTree(tree));
		
		Node node = this.tree.search(35);
		assertEquals(null,node);
	}
	
	@Test 
	public void testDeleteNodeWithOnlyLeftChildInRoot()
	{
		Node root = new Node(17);
		tree = new BinaryTree(root);
		tree.insert(15);
		
		/*
		 * 		17
		 * 		/
		 * 	15	
		 * */
		Node deletedNode = this.tree.deleteNode(17);
		assertEquals(17,deletedNode.getValue());
		assertEquals(true, TreeUtil.isBinarySearchTree(tree));
		
		Node node = this.tree.search(17);
		assertEquals(null,node);
	}
	@Test 
	public void testDeleteNodeWithOnlyRightChildInRoot()
	{
		Node root = new Node(17);
		tree = new BinaryTree(root);
		tree.insert(35);
		
		/*
		 * 		17
		 * 		  \
		 * 		   35
		 * */
		Node deletedNode = this.tree.deleteNode(17);
		assertEquals(17,deletedNode.getValue());
		assertEquals(true, TreeUtil.isBinarySearchTree(tree));
		
		Node node = this.tree.search(17);
		assertEquals(null,node);
		
		assertEquals(35,this.tree.root.getValue());
	}
}
