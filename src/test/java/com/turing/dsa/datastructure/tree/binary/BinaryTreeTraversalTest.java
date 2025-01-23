package com.turing.dsa.datastructure.tree.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class BinaryTreeTraversalTest {
	BinaryTree tree;
	public BinaryTreeTraversalTest()
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
	
	//@Test
	public void testPreOrderTraversal()
	{
		BinaryTreeTraversal traversal = new PreorderTraversalWithLoop(tree);
		Iterator<Node> iterator = traversal.iterator();
		//17, 15,13,16,30,18,19,35
		assertEquals(17,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(13,iterator.next().value);
		assertEquals(16,iterator.next().value);
		assertEquals(30,iterator.next().value);
		assertEquals(18,iterator.next().value);
		assertEquals(19,iterator.next().value);
		assertEquals(35,iterator.next().value);
	}
	@Test
	public void testInOrderTraversal()
	{
		BinaryTreeTraversal traversal = new InorderTraversalImperative(tree);
		Iterator<Node> iterator = traversal.iterator();
		// 13,15,16,17,18,19,30,35
		assertEquals(13,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(16,iterator.next().value);
		assertEquals(17,iterator.next().value);
		assertEquals(18,iterator.next().value);
		assertEquals(19,iterator.next().value);
		assertEquals(30,iterator.next().value);
		assertEquals(35,iterator.next().value);
	}
	//@Test
	public void testPostOrderTraversal()
	{
		BinaryTreeTraversal traversal = new PostOrderTraversal(tree);
		Iterator<Node> iterator = traversal.iterator();
		//  13,16,15,19,18,35,30,17
		assertEquals(13,iterator.next().value);
		assertEquals(16,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(19,iterator.next().value);
		assertEquals(18,iterator.next().value);
		assertEquals(35,iterator.next().value);
		assertEquals(30,iterator.next().value);
		assertEquals(17,iterator.next().value);
	}
}
