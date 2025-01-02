package com.turing.dsa.search;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.turing.dsa.LinearSearch;
import com.turing.dsa.searching.SearchAlgorithm;
public class RecursiveBinarySearchTest {
	RecursiveBinarySearchAlgorithm algo = new RecursiveBinarySearchAlgorithm();
    int[]input = {1,4,6,13,21,50};
    
   
   
    @ParameterizedTest
    @CsvSource(value = {
    					"11,-1",
    					"6,2", 
    					"4,1", 
    					"21,4",
    					"50,5",
                        "100,-1",
                        "5,-1",
                        "0,-1",
                       
                        })
    public void testSearchWithParamerizedTest(int item, int expected) {
        System.out.println("Item "+item+ " Expected "+expected);
        
        int index = algo.search(input, item,0, input.length-1);
        assertEquals(expected,index);
    }
}
