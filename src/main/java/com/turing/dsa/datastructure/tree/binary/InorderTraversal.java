package com.turing.dsa.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;

public class InorderTraversal implements BinaryTreeTraversal {
	BinaryTree tree;
	
	ArrayList<Node> list;
	public InorderTraversal(BinaryTree tree)
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
		
		//left child
		if( node.getLeftChild()!=null)
		{
			this.traverseInorder(node.getLeftChild());
		}
		if(node!=null)
		{
			System.out.println("Node "+node.getValue());
			this.list.add(node);
		}
		//right child
		if(node.getRightChild()!=null)
		{
			this.traverseInorder(node.getRightChild());
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
