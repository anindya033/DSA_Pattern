package com.crafter.patterns.hashmap;

import java.util.HashMap;
import java.util.TreeMap;

public class ValidAnagram {
    
    public static void main(String [] args){
        String sActual = "anagram";
        String sAnagram = "nagrama";

        /*
            Intution : 
                Use one data structure to increase occurence of first string.
                Use the same data structure to decrease occurence of the second string.
                So ultimately it will make each other out

            While reducing counts using the second string:
                -   If a character count goes below zero, it means:
                -   The character appears more times in the second string than in the first.
                    -   Or the character never existed in the first string at all.
         */

        if(sActual.length() != sAnagram.length()){
            System.out.println("Invalid anagram");
            return;
        }
        
        int [] freq  = new int[26];

        for(int i =0; i < sActual.length(); i++ ){
            char ch = sActual.charAt(i);
            int index = ch - 'a';
            freq [index] = freq [index]+1;
            

        }

        for(int i =0; i < sAnagram.length(); i++ ){
            char ch = sAnagram.charAt(i);
            int index = ch - 'a';
            freq[index] = freq[index] - 1;
            if (freq[index] < 0) {
                return ; // early exit
                
            }

        }

        for (int count : freq) {
            if (count != 0) {
                return ;
            }
        }

        System.out.println("Valid anagram");
        
    }
}
