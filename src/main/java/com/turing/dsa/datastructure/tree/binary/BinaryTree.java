package com.turing.dsa.datastructure.tree.binary;

public class BinaryTree {
	Node root;
	
	public BinaryTree(Node root)
	{
		this.root = root;
	}

	public Node search(int item) {
		Node current = this.root;
		
		while(current != null)
		{
			if(current.getValue() == item)
			{
				return current;
			}
			if(current.getValue() < item)
			{
				//go to right
				current = current.getRightChild();
			}
			else if(current.getValue()> item)
			{
				current = current.getLeftChild();
			}
		}
		return null;
	}
}
