package com.turing.dsa.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PreorderTraversalIterative implements BinaryTreeTraversal {
	BinaryTree tree;
	
	ArrayList<Node> list;
	public PreorderTraversalIterative(BinaryTree tree)
	{
		this.tree = tree;
		
	}
	@Override
	public Iterator<Node> iterator() {
		return new TreeIterator();
	}
	public void traversePreorder()
	{
		Node current = this.tree.root;
		this.traversePreorder(current);
	}
	void traversePreorder(Node node)
	{
		Node current = node;
		Stack<Node> stack = new Stack<>();
		while(current != null)
		{
			this.list.add(current);
			System.out.println("Node "+current.getValue());
			
			if(current.rightChild != null)
			{
				stack.push(current.rightChild);
			}
			if(current.leftChild != null)
			{
				current = current.leftChild;
			}
			else if( !stack.isEmpty())
			{
				current = stack.pop();
			}
			else
			{
				break;
			}
		}
	}
	 class TreeIterator implements Iterator<Node>
	 {

		 int currentIndex =0;
		 TreeIterator()
		 {
			 list = new ArrayList<Node>();
			 traversePreorder();
				
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
