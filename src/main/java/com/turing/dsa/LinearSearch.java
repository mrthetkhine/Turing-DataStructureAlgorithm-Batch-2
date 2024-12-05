/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.dsa;

/**
 *
 * @author macbook
 */
public class LinearSearch {
    public int search(int[]array,int item)
    {
        for (int i = 0; i < array.length; i++) {
            if(array[i]==item)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[]args)
    {
        int[] input = {1,2,3,4,10};
        LinearSearch ls = new LinearSearch();
        System.out.println("Search "+ ls.search(input, 100));
    }
}
