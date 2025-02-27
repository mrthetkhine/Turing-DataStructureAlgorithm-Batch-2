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
				Node temp = node.insert(item,this);
				System.out.println("After inserted "+temp);
				return temp;
			}
			else //We need to split
			{
				System.out.println("Need to split $$$==> "+node);
				Node splitParent = node.splitNode(node,this);
				
				if(node.parent == null )//Node is root
				{
					this.root = splitParent;
				}
				System.out.println("Split parent "+splitParent);
				node = this.root.searchForInsert(item,this);
				System.out.println("After split ==> "+node);
				Node temp = node.insert(item,this);
				System.out.println("After inserted "+temp);
				return temp;
				
			}
			
		}
	}
	public Node search(int value)
	{
		return this.root.search(value);
	}
	public Node searchForInsert(int value)
	{
		return this.root.searchForInsert(value, this);
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
	
	//Deletion algorithm
	//https://azrael.digipen.edu/~mmead/www/Courses/CS280/Trees-2-3-4-delete.html
}
