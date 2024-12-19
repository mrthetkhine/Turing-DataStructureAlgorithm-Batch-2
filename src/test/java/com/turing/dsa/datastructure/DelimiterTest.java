package com.turing.dsa.datastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DelimiterTest {
	Delimiter delimiter = new Delimiter();
	

    @ParameterizedTest
    @CsvSource(value = {
    					"'',true", 
    					"c[d],true", 
    					"a{bd}e,true", 
    					"c[d,false", 
    					"a[b{c}d]e},false", 
    					"a{b(c),false", 
    					
                        })
    public void testDelimiter(String input, boolean expected) {
        System.out.println("Input "+input+ " Expected "+expected);
        
        boolean result = delimiter.isValid(input);
        assertEquals(expected,result);
    }
	
}
