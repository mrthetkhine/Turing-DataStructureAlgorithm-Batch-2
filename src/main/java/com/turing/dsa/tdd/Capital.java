/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.dsa.tdd;

/**
 *
 * @author macbook
 */
public class Capital {
    public String toCapital(String input)
    {
        if(input == null || "".equals(input))
        {
            return "";
        }
        else
        {
            String words[] = input.split(" ");
            String result= "";
            for(int i=0;i< words.length;i++)
            {
                result+=toCapitalForWord(words[i])+" ";
            }
            return result.trim();
        }
        
    }

    String toCapitalForWord(String input) {
        String word = ( input.charAt(0) +"").toUpperCase()+ input.substring(1);
        return word;
    }
}
