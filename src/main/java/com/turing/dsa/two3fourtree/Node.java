package com.turing.dsa.two3fourtree;

import java.util.ArrayList;

public class Node {
	public Node parent;
	public Integer keys[] = new Integer[3];
	public ArrayList<Node> children = new ArrayList<Node>();
	static int ORDER = 4;
	public int noOfNode = 1;//2,3 or 4
	
	
	public Node insert(int value,TwoThreeFourTree tree)
	{
		if(noOfNode != 4)//Normal insert
		{
			return simpleInsert(value);
		}
		else
		{
			//split case
			Node splitParent =this.splitNode(this,tree);
			//We need to find leave node to insert
			return splitParent;
		}

	}
	private Node simpleInsert(int value) {
		int index = 0;
		while( index< keys.length && keys[index]!=null )
		{
			if(keys[index]>value)
			{
				break;
			}
			index ++;
		}
		for(int i = keys.length-1; i> index;i--)
		{
			keys[i] =keys[i-1];
		}
		keys[index] = value;
		this.noOfNode++;
		return this;
	}
	
	
	public Node search(int value)
	{
		//System.out.println("SearchNode ==> "+this);
		Node current = this;
		int index = 0;
		while( index< current.keys.length && current.keys[index]!=null )
		{
			if(current.keys[index]==value)
			{
				return current;
			}
			else if(current.keys[index]>value)
			{
				break;
			}
			index ++;
		}
		
		if(current.children.size()>0)
		{
			//go to children
			//System.out.println("Index "+index);
			Node node = current.children.get(index);
			if(node != null)
			{
				return node.search(value);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
		
	}
	
	Node splitNode(Node node,TwoThreeFourTree tree)
	{
		//simple case no parent case
		if(node.parent ==null)
		{
			System.out.println("splitNode parent null case");
			Node parent = splitWhenNoParent(node,tree);
			tree.root = parent;
			return parent;
		}
		else
		{
			System.out.println("This is our case==");
			return this.splitWithParent(node,tree);
		}
	
	}
	public Node splitWhenNoParent(Node node,TwoThreeFourTree tree) {
		Node parent =new Node();
		parent.insert(node.keys[1],tree);
		
		//split into child
		Node child0 = new Node();
		child0.parent = parent;
		
		child0.insert( node.keys[0],tree);
		
		Node child1 = new Node();
		child1.parent = parent;
		child1.insert( node.keys[2],tree);
		
		parent.children.add(child0);
		parent.children.add(child1);
		
		
		return parent;
	}
	public Node splitWithParent(Node node,TwoThreeFourTree tree)
	{
		Node parent = node.parent;
		//Parent can also be four node
		parent.insert(node.keys[1],tree);
		
		int childIndex = this.insertedIndex(parent,node.keys[1]);
		Node child0 = new Node();
		child0.parent = parent;
		
		child0.insert( node.keys[0],tree);
		
		Node child1 = new Node();
		child1.parent = parent;
		child1.insert( node.keys[2],tree);
		
		//Remove first
		parent.children.remove(childIndex);
		
		parent.children.add(childIndex,child1);
		parent.children.add(childIndex,child0);
		
		
		return parent;
		
	}
	public Node searchForInsert(int value,TwoThreeFourTree tree)
	{
		//System.out.println("searchForInsert ==> "+this);
		Node current = this;
		if(current.noOfNode == 4)//Split
		{
			System.out.println(">>Current node need to split "+current);
			Node parent = this.splitNode(current,tree);
			System.out.println(">>split after parent "+parent);
			return parent.searchForInsert(value,tree);
		}
		/*
		 * TODO we need to fix logic eg
		 *      		[120,200]-
    			[100]   [150] [201,203] 
		 * 	
		 * in above case, we should return search node for 204 as [201,203] not [120,200]
		 * */
		int index = 0;
		while( index< current.keys.length && current.keys[index]!=null )
		{
			if(current.keys[index]==value)
			{
				return current;
			}
			else if(current.keys[index]>value)
			{
				break;
			}
			index ++;
		}
		
		if(current.children.size()>0)
		{
			//go to children
			//System.out.println("Index "+index);
			Node node = current.children.get(index);
			
			
			if(node != null)
			{
				System.out.println("Goes down to from "+current);
				System.out.println("Goes down to child "+node);
				return node.searchForInsert(value,tree);
			}
			else
			{
				return null;
			}
		}
		else//no child
		{
			return current;
		}
		
	}
	
	int insertedIndex(Node node,int value)
	{
		for(int i=0; i< node.keys.length;i++)
		{
			if(node.keys[i]==value)
			{
				return i;
			}
		}
		return -1;
	}
	int getChildIndex(Node node)
	{
		int childSize = node.parent.children.size();
		for(int i=0;i<childSize;i++)
		{
			Node child = node.parent.children.get(i);
			if(child==node)
			{
				return i;
			}
		}
		return -1;
	}
	@Override
	public String toString()
	{
		String str = "[";
		for(Integer key :keys)
		{
			str +=key +",";
		}
		str += "] child=> "+this.children.size();
		return str;
		
	}
	public boolean isLeaf()
	{
		return this.children.size()==0;
	}
}
