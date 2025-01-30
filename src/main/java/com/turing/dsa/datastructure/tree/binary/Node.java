package com.turing.dsa.datastructure.tree.binary;

public class Node {
	int value;
	Node parent;
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

	public void setLeftChild(Node child) {
		child.setParent(this);
		this.leftChild = child;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node child) {
		child.setParent(this);
		this.rightChild = child;
	}

	public int getValue() {
		return value;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public boolean isSubTree()
	{
		return this.leftChild != null   || this.rightChild!=null;
	}
	public boolean isLeaf()
	{
		return this.leftChild == null  && this.rightChild ==null;
	}
	public boolean haveOnlyOneChild()
	{
		return (this.leftChild==null && this.rightChild!=null) || (this.leftChild!=null && this.rightChild==null);
	}
}
