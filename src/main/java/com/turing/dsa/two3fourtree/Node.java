package com.turing.dsa.two3fourtree;

import java.util.ArrayList;

public class Node {
	public Node parent;
	public Integer keys[] = new Integer[3];
	public ArrayList<Node> children = new ArrayList<Node>();
	static int ORDER = 4;
	public int noOfNode = 1;//2,3 or 4
	
	
	public Node insert(int value)
	{
		if(noOfNode != 4)//Normal insert
		{
			return simpleInsert(value);
		}
		else
		{
			//split case
			Node splitParent =this.splitNode(this);
			//We need to find leave node to insert
		}
		
		return this;
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
	Node splitNode(Node node)
	{
		//simple case no parent case
		if(node.parent ==null)
		{
			return splitWhenNoParent(node);
		}
		return node;
	}
	public Node splitWhenNoParent(Node node) {
		Node parent =new Node();
		parent.insert(node.keys[1]);
		
		//split into child
		Node child0 = new Node();
		child0.parent = parent;
		
		child0.insert( node.keys[0]);
		
		Node child1 = new Node();
		child1.parent = parent;
		child1.insert( node.keys[2]);
		
		parent.children.add(child0);
		parent.children.add(child1);
		
		return parent;
	}
	public Node search(int value)
	{
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
			System.out.println("Index "+index);
			if(index==current.keys.length)
			{
				return current.children.get(index);
			}
			else if(current.keys[index]==null)
			{
				return current.children.get(index);
			}
			else
			{
				return current.children.get(index);
			}
		}
		else
		{
			return null;
		}
		
	}
}
