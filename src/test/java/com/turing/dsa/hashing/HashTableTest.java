package com.turing.dsa.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.hash.HashTable;

public class HashTableTest {

	@Test
	public void testHashingWord()
	{
		HashTable ht =new HashTable();
		int hash = HashTable.hash("hello",10);
		assertEquals(2,hash);
		
		
		ht.insert("hello");
		assertEquals(true, ht.contains("hello"));
		
	}
}
