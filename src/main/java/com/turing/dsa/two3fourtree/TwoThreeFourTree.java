package com.turing.dsa.two3fourtree;

public class TwoThreeFourTree {
	Node root;

	public void insert(int item) {
		if(root == null)
		{
			root = this.createTwoNode(null, item);
		}
		else
		{
			Node node = this.root;
			node.insert(item);
		}
	}
	public Node createTwoNode(Node parent,int value)
	{
		Node node = new Node();
		node.keys[0] = value;
		node.parent = parent;
		node.noOfNode ++;
		return node;
	}

	public Node getRoot() {
		return this.root;
	}
}
