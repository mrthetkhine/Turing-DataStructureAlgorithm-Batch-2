package com.turing.dsa.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeUtil {

	public static boolean isBinarySearchTree(BinaryTree tree)
	{
		BinaryTreeTraversal traversal = new InorderTraversal(tree);
		Iterator<Node> iterator = traversal.iterator();
		ArrayList<Node> items = new ArrayList<Node>();
		while(iterator.hasNext())
		{
			items.add(iterator.next());
		}
		Node first = items.get(0);
		for(int i=1;i< items.size();i++)
		{
			Node next = items.get(i);
			if(first.getValue()< next.getValue())
			{
				first = next;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
}
