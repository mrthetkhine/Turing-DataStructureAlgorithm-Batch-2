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
		Stack<Node> stack =new Stack<>();
		ArrayList<Node> visited = new ArrayList<Node>();
		Node current= node;
		while( current != null)
		{
			while( current.leftChild != null)
			{
				System.out.println("push "+current.value);
				stack.push(current);
				current =current.leftChild;
			}
			if( current.rightChild !=null)
			{
				System.out.println("Right child case");
			}
			System.out.println("Node "+current.value);
			list.add(current);
			
			
			if(! stack.empty())//left deadend or right deadend
			{
				Node backtrackNode = stack.pop();
				
				if(!visited.contains(backtrackNode))
				{
					System.out.println("Not visited, push "+backtrackNode.value);
					stack.push(backtrackNode);
					visited.add(backtrackNode);
				}
				else //process root
				{
					list.add(backtrackNode);
					System.out.println("Backtrack node");
					System.out.println("Node "+backtrackNode.value);
					if(! stack.empty())
					{
						current = stack.pop();
						continue;
					}
					else
					{
						break;
					}
					
				}
				
				
				if( backtrackNode.rightChild != null  )
				{
					
					System.out.println("Go to right child of "+backtrackNode.value);
					
					current = backtrackNode.rightChild;
					visited.add(backtrackNode.rightChild);
				}
				else //no right child process root
				{
					System.out.println("This case "+backtrackNode.value);
					//current = backtrackNode;
					System.out.println("Node "+backtrackNode.value);
					list.add(backtrackNode);
					break;
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
