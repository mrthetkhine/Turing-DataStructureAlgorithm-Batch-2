/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.dsa.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author macbook
 */
public class CapitalTest {
    @Test
    public void testEmpty()
    {
        Capital cap = new Capital();
        String output = cap.toCapital("");
        
        assertEquals("",output);
        
    }
    @Test
    public void testNull()
    {
        Capital cap = new Capital();
        String output = cap.toCapital(null);
        
        assertEquals("",output);
        
    }
    @Test
    public void testSingleWord()
    {
        Capital cap = new Capital();
        String output = cap.toCapital("apple");
        
        assertEquals("Apple",output);
        
        output = cap.toCapital("Apple");
        assertEquals("Apple",output);
        
    }
    @Test
    public void testMulipleWord()
    {
        Capital cap = new Capital();
        String output = cap.toCapital("apple orange");
        
        assertEquals("Apple Orange",output);
        
        output = cap.toCapital("Apple Orange");
        assertEquals("Apple Orange",output);
        
    }
}
