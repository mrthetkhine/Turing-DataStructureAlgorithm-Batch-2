package com.turing.dsa.datastructure.tree.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class PostOrderTraversalTest {
	
	//@Test
	public void testBaseCase()
	{
		BinaryTree tree;
		Node root = new Node(17);
		tree = new BinaryTree(root);
		tree.insert(15);
		tree.insert(30);
		/*
		 * 	     17
		 * 		/  \
		 * 	    15	30	
		 * */
		//15,30,17
		BinaryTreeTraversal traversal = new PostOrderTraversalIterative(tree);
		Iterator<Node> iterator = traversal.iterator();
		//15,30,17
		assertEquals(15,iterator.next().value);
		assertEquals(30,iterator.next().value);
		assertEquals(17,iterator.next().value);
		assertEquals(false,iterator.hasNext());
	}
	//@Test
	public void testBaseCaseTwo()
	{
		BinaryTree tree;
		Node root = new Node(17);
		tree = new BinaryTree(root);
		tree.insert(15);
		
		/*
		 * 	     17
		 * 		/  
		 * 	    15	
		 * */
		//15,17
		BinaryTreeTraversal traversal = new PostOrderTraversalIterative(tree);
		Iterator<Node> iterator = traversal.iterator();
		//15,17
		assertEquals(15,iterator.next().value);
		assertEquals(17,iterator.next().value);
		assertEquals(false,iterator.hasNext());
	}
	@Test
	public void testBaseCaseThree()
	{
		BinaryTree tree;
		Node root = new Node(17);
		tree = new BinaryTree(root);
		tree.insert(30);
		
		/*
		 * 	     17
		 * 		/  \
		 * 	     	30
		 * */
		//30,17
		BinaryTreeTraversal traversal = new PostOrderTraversalIterative(tree);
		Iterator<Node> iterator = traversal.iterator();
		
		assertEquals(30,iterator.next().value);
		assertEquals(17,iterator.next().value);
		assertEquals(false,iterator.hasNext());
	}
}
