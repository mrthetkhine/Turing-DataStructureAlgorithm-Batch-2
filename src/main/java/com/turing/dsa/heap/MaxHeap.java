package com.turing.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
	List<Integer> data = new ArrayList<>();

	public void insert(Integer item)
	{
		this.data.add(item);
		this.heapify();
	}
	Integer peek()
	{
		return this.data.get(0);
	}
	public void delete(Integer item)
	{
		System.out.println("Delete "+item);
		int indexToDelete =this.data.indexOf(item);
		System.out.println("index to delete "+ indexToDelete);
		if(indexToDelete != -1)
		{
			if(isLeaf(indexToDelete))
			{
				System.out.println("Remove leaf "+item);
				this.data.remove(indexToDelete);
			}
			else
			{
				System.out.println("Non Leaf node "+item);
				int lastIndex = this.data.size()-1;
				Integer lastItem= this.data.get(lastIndex);
				this.data.set(indexToDelete,lastItem);
				
				this.data.remove(lastIndex);
			}
			this.heapify();
		}
	}
	public boolean isLeaf(int nodeIndex)
	{
		int n = this.data.size();
		int internalNode = n/2 - 1;
		
		return nodeIndex > internalNode;
		/*
		int leftIndex = nodeIndex* 2+ 1;
		int rightIndex = nodeIndex * 2 + 2;
		
		Integer leftChild = null;
		Integer rightChild = null;
		if(leftIndex < data.size())
		{
			leftChild = data.get(leftIndex);
			
		}
		if(rightIndex < data.size())
		{
			rightChild = data.get(rightIndex);
		}
		return leftChild ==null && rightChild == null;
		*/
	}
	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}
	void heapify()
	{
		int n = this.data.size();
		int currentIndex = n/2 - 1;
		while(currentIndex >= 0)
		{
			Integer parent = this.data.get(currentIndex);
			int largestIndex = currentIndex;
			int leftIndex = currentIndex* 2+ 1;
			int rightIndex = currentIndex * 2 + 2;
			
			Integer leftChild = null;
			Integer rightChild = null;
			if(leftIndex < data.size())
			{
				leftChild = data.get(leftIndex);
				if(leftChild > parent)
				{
					largestIndex = leftIndex;
				}
			}
			if(rightIndex < data.size())
			{
				rightChild = data.get(rightIndex);
				if(rightChild > parent)
				{
					largestIndex = rightIndex;
				}
			}
			//swap currentindex, largestindex
			Integer temp =this.data.get(currentIndex);
			Integer largest = this.data.get(largestIndex);
			
			this.data.set(currentIndex, largest);
			this.data.set(largestIndex, temp);
			
			currentIndex --;
		}
	}
	
	
}
