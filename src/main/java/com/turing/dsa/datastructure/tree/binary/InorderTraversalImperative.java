package com.turing.dsa.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class InorderTraversalImperative implements BinaryTreeTraversal {
	BinaryTree tree;
	
	ArrayList<Node> list;
	public InorderTraversalImperative(BinaryTree tree)
	{
		this.tree = tree;
		
	}
	@Override
	public Iterator<Node> iterator() {
		return new TreeIterator();
	}
	public void traverseInorder()
	{
		Node current = this.tree.root;
		this.traverseInorder(current);
	}
	void traverseInorder(Node node)
	{
		Node current = node;
		Stack<Node> stack = new Stack<>();
		while(current != null)
		{
			
			while(current.leftChild != null)
			{
				stack.push(current);
				current = current.leftChild;
			}
			//Left
			System.out.println("Node "+current.value);
			list.add(current);
			if( current.rightChild != null)
			{
				//Node have no left child but it have right child
				//so it is root, then we need to call right 
				current = current.rightChild;
			}
			else if( ! stack.isEmpty())
			{
				//Root
				current = stack.pop();
				System.out.println("Node "+current.value);
				list.add(current);
				if(current.rightChild != null)
				{
					current = current.rightChild;
				}
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
			 traverseInorder();
				
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
