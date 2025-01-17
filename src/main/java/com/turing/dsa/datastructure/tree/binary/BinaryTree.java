package com.turing.dsa.datastructure.tree.binary;

import java.util.Iterator;

public class BinaryTree{
	Node root;
	
	public BinaryTree(Node root)
	{
		this.root = root;
	}

	/*
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
	}*/
	public Node search(int item) {
		return this.searchRecursive(item, root);
				
	}
	public Node searchRecursive(int item,Node current)
	{
		if(current == null)
		{
			return null;
		}
		if(current.getValue() == item)
		{
			return current;
		}
		if(current.getValue() < item)
		{
			//go to right
			return this.searchRecursive(item, current.getRightChild());
		}
		else if(current.getValue()> item)
		{
			return this.searchRecursive(item, current.getLeftChild());
		}
		return null;
	
	}
	public Node insert(int item) {
		
		Node insertedNode = new Node(item);
		
		Node current = this.root;
		Node parent = null;
		while( current!= null)
		{
			parent = current;
			if(current.getValue() < item)
			{
				current = current.getRightChild();
			}
			else if(current.getValue() > item)
			{
				current = current.getLeftChild();
			}
		}
		//current null node 
		if(parent.getValue() < item)
		{
			parent.setRightChild(insertedNode);
		}
		if(parent.getValue() > item)
		{
			parent.setLeftChild(insertedNode);
		}
		return insertedNode;
	}
	

	
}
