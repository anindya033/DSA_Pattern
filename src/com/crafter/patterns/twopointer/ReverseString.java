package com.crafter.patterns.twopointer;

import java.util.Arrays;

// problem : Write a function that reverses a string. The input string is given as an array of characters s.

/*
 	Easy
 		Input: s = ["h","e","l","l","o"]
		Output: ["o","l","l","e","h"]
 */
public class ReverseString {
	
	public static void main(String [] args) {
		
		char [] arr = new char[] {'h','e','l','l','o'};
		
		int start = 0;
		int end = arr.length-1;
		
		while(end > start) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
		
		for(char c : arr){
			System.out.println(c);
		}
	}

}
