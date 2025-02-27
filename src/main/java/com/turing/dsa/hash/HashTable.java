package com.turing.dsa.hash;

import java.util.LinkedList;

public class HashTable {

	String[] data = new String[10];
	
	public HashTable()
	{
		
	}
	public void insert(String word)
	{
		int index = HashTable.hash(word,10);
		data[index ]= word;
	}
	public boolean contains(String word)
	{
		int index = HashTable.hash(word,10);
		return data[index] != null;
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
