package com.turing.dsa.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PostOrderTraversalIterative implements BinaryTreeTraversal {
	BinaryTree tree;
	
	ArrayList<Node> list;
	public PostOrderTraversalIterative(BinaryTree tree)
	{
		this.tree = tree;
		
	}
	@Override
	public Iterator<Node> iterator() {
		return new TreeIterator();
	}
	public void traversePostOrder()
	{
		Node current = this.tree.root;
		this.traversePostorder(current);
	}
	void traversePostorder(Node node)
	{
		Stack<Node> recursiveStack =new Stack<>();
		Stack<Node> reverseResultStack =new Stack<>();
		
		Node current= node;
		recursiveStack.push(current);
		
		while( !recursiveStack.empty())
		{
			Node item = recursiveStack.pop();
			reverseResultStack.push(item);
			
			if(item.leftChild !=null)
			{
				recursiveStack.push(item.leftChild);
			}
			if(item.rightChild !=null)
			{
				recursiveStack.push(item.rightChild);
			}
		}
		while(!reverseResultStack.empty())
		{
			list.add(reverseResultStack.pop());
		}
	}
	 class TreeIterator implements Iterator<Node>
	 {

		 int currentIndex =0;
		 TreeIterator()
		 {
			 list = new ArrayList<Node>();
			 traversePostOrder();
				
		 }
		@Override
		public boolean hasNext() {
			
			return currentIndex <= list.size()-1;
		}

		@Override
		public Node next() {
			return list.get(currentIndex++);
		}
		 
	 }

}
