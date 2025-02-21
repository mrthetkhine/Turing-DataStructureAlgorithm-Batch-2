package com.turing.dsa.two3fourtree;

public class TwoThreeFourTree {
	Node root;

	public Node insert(int item) {
	
		System.out.println("To insert item "+item);
		if(root == null)
		{
			root = this.createTwoNode(null, item);
			return root;
		}
		else
		{
			Node node = this.root.searchForInsert(item,this);
			System.out.println("Node search for interest ==> "+node);
			if(node.noOfNode != 4)
			{
				return node.insert(item,this);
			}
			else //We need to split
			{
				System.out.println("Need to split ==> "+node);
				Node splitParent = node.splitNode(node,this);
				
				if(node.parent == null )//Node is root
				{
					this.root = splitParent;
				}
				System.out.println("Split parent "+splitParent);
				node = this.root.searchForInsert(item,this);
				System.out.println("After split ==> "+node);
				return node.insert(item,this);
				
			}
			
		}
	}
	public Node search(int value)
	{
		return this.root.search(value);
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
