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
	public Node getMinNode()
	{
		Node current = this.root;
		while(current.leftChild !=null)
		{
			current = current.leftChild;
		}
		return current;
	}
	public Node getMaxNode()
	{
		Node current = this.root;
		while(current.rightChild !=null)
		{
			current = current.rightChild;
		}
		return current;
	}

	public Node getSuccessorOf(int item) {
		Node node =this.search(item);
		
		if(node.rightChild ==null)//Problem
		{
			return null;
		}
		else
		{
			//successor is next max, leftmost child of right subtree
			Node current = node.rightChild;
			while(current.leftChild !=null)
			{
				current = current.leftChild;
			}
			return current;
		}
	
	}

	public Node deleteNode(int item) {
		Node nodeToDelete = this.search(item);
		
		if(nodeToDelete.isLeaf())
		{
			deleteLeaf(nodeToDelete);
		}
		else if(nodeToDelete.haveOnlyOneChild())
		{
			if(nodeToDelete.getParent() == null)//Root
			{
				deleteOnlyChildRoot(nodeToDelete);
			}
			else
			{
				//Non root case
				nodeToDelete = deleteOnlyChildNonRoot(nodeToDelete);
			}
			
		}
		else
		{
			nodeToDelete = deleteWithSuccessor(nodeToDelete);
		}
		return nodeToDelete;
	}

	private Node deleteWithSuccessor(Node nodeToDelete) {
		Node toReturn = new Node(nodeToDelete.getValue());
		
		Node successor = this.getSuccessorOf(nodeToDelete.getValue());
		int succesorValue = successor.getValue();
		this.deleteNode(succesorValue);
		
		nodeToDelete.value = succesorValue;
		
		nodeToDelete = toReturn;
		return nodeToDelete;
	}

	private Node deleteOnlyChildNonRoot(Node nodeToDelete) {
		if(nodeToDelete.leftChild != null)
		{
			Node toReturn = new Node(nodeToDelete.getValue());
					
			nodeToDelete.setValue(nodeToDelete.getLeftChild().value);
			nodeToDelete.leftChild = null;
			
			nodeToDelete = toReturn;
		}
		else if(nodeToDelete.rightChild != null)
		{
			Node toReturn = new Node(nodeToDelete.getValue());
			
			nodeToDelete.setValue(nodeToDelete.getRightChild().value);
			nodeToDelete.rightChild = null;
			
			nodeToDelete = toReturn;
		}
		return nodeToDelete;
	}

	private void deleteOnlyChildRoot(Node nodeToDelete) {
		if(nodeToDelete.leftChild !=null)
		{
			this.root = nodeToDelete.getLeftChild();
		}
		if(nodeToDelete.getRightChild() != null)
		{
			this.root = nodeToDelete.getRightChild();
		}
	}

	private void deleteLeaf(Node nodeToDelete) {
		Node parentNode = nodeToDelete.getParent();
		if(parentNode.leftChild == nodeToDelete)//left child
		{
			parentNode.leftChild = null;
		}
		else if(parentNode.rightChild == nodeToDelete)
		{
			parentNode.rightChild = null;
		}
	}
	
}
