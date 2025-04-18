package com.turing.dsa.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;

public class PreorderTraversal implements BinaryTreeTraversal {
	BinaryTree tree;
	
	ArrayList<Node> list;
	public PreorderTraversal(BinaryTree tree)
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
		if(node!=null)
		{
			System.out.println("Node "+node.getValue());
			this.list.add(node);
		}
		//left child
		if( node.getLeftChild()!=null)
		{
			this.traversePreorder(node.getLeftChild());
		}
		//right child
		if(node.getRightChild()!=null)
		{
			this.traversePreorder(node.getRightChild());
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
