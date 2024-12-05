/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.dsa.search;

import com.turing.dsa.LinearSearch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author macbook
 */
public class LinearTestSearch {
    @Test
    public void testSearch()
    {
        LinearSearch lsAlgo = new LinearSearch();
        int[]input = {1,2,3,4,10};
        
        int index = lsAlgo.search(input, 1);
        assertEquals(0,index);
    }
    @Test
    public void testUnhappyCase()
    {
        LinearSearch lsAlgo = new LinearSearch();
        int[]input = {1,2,3,4,10};
        
        int index = lsAlgo.search(input, 120);
        assertEquals(-1,index);
    }
    @Test
    public void testEdgeCase()
    {
        LinearSearch lsAlgo = new LinearSearch();
        int[]input = {1,2,3,4,10,-1};
        
        int index = lsAlgo.search(input, -1);
        assertEquals(5,index);
    }
}
