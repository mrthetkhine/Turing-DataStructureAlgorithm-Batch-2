package com.turing.dsa.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;

public class PostOrderTraversal implements BinaryTreeTraversal {
	BinaryTree tree;
	
	ArrayList<Node> list;
	public PostOrderTraversal(BinaryTree tree)
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
		
		//left child
		if( node.getLeftChild()!=null)
		{
			this.traversePostorder(node.getLeftChild());
		}
		//right child
		if(node.getRightChild()!=null)
		{
			this.traversePostorder(node.getRightChild());
		}
		if(node!=null)
		{
			System.out.println("Node "+node.getValue());
			this.list.add(node);
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
