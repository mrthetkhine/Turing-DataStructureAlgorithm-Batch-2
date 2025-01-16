package com.turing.dsa.datastructure.tree.binary;

public class Node {
	int value;
	Node leftChild;
	Node rightChild;
	
	public Node(int value)
	{
		this.value= value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public int getValue() {
		return value;
	}
	
}
