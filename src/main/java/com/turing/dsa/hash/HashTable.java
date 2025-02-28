package com.turing.dsa.hash;

import java.util.LinkedList;

public class HashTable {

	LinkedList[] data = new LinkedList[10];
	
	public HashTable()
	{
		for(int i=0;i<data.length;i++)
		{
			data[i] = new LinkedList();
		}
	}
	public void insert(String word)
	{
		int index = HashTable.hash(word,10);
		LinkedList list = data[index];
		list.add(word);
	}
	public boolean contains(String word)
	{
		int index = HashTable.hash(word,10);
		LinkedList list = data[index];
		return list.contains(word);
	}
	public static int hash(String word,int bucketSize)
	{
		int total = 0;
		for(int i=0;i<word.length();i++)
		{
			total += word.codePointAt(i);
		}
		return total % bucketSize;
	}
}
