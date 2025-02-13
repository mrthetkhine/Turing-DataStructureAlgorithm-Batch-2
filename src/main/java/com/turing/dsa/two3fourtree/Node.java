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
		}
		
		return this;
	}
}
