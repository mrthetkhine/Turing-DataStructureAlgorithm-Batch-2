package com.turing.dsa.datastructure.tree.binary.array;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTreeArrayPreOrderTraversal implements Iterable<Integer> {
	BinaryTreeWithArray binaryTree;
	
	ArrayList<Integer> list;
	public BinaryTreeArrayPreOrderTraversal(BinaryTreeWithArray tree)
	{
		this.binaryTree = tree;
		
	}
	@Override
	public Iterator<Integer> iterator() {
		return new TreeIterator();
	}
	public void traversePreOrder()
	{
		int rootIndex = 0;
		this.traversePreOrder(rootIndex);
	}
	void traversePreOrder(int nodeIndex)
	{
		Integer current = this.binaryTree.tree[nodeIndex];
		if(current !=null)
		{
			list.add(current);
		}
		else
		{
			return;
		}
		int leftIndex = nodeIndex * 2+1;
		this.traversePreOrder(leftIndex);
		
		int rightIndex = nodeIndex * 2 + 2;
		this.traversePreOrder(rightIndex);
		
	}
	 class TreeIterator implements Iterator<Integer>
	 {

		 int currentIndex =0;
		 TreeIterator()
		 {
			 list = new ArrayList<Integer>();
			 traversePreOrder();
				
		 }
		@Override
		public boolean hasNext() {
			
			return currentIndex <= list.size()-1;
		}

		@Override
		public Integer next() {
			return list.get(currentIndex++);
		}
		 
	 }

}
