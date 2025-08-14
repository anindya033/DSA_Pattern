package com.crafter.patterns.twopointer;

/*
 	Easy :
 		Input: s = "A man, a plan, a canal: Panama"
		Output: true
		Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class A10_ValidPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "A man, a plan, a canal: Panama";
		String str1 = "race a car";
		if(isPalindrome(str1)) {
			System.out.println("Palindrom");
		}else {

			System.out.println("Not Palindrom");
		}
	}
	
	public static boolean isPalindrome(String s) {

        String result = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		int start = 0;
		int end = result.length() - 1;
		
		while (start < end) {
	        if (result.charAt(start) != result.charAt(end)) {
	            return false;  // Found a mismatch, no need to continue
	        }
	        start++;
	        end--;
	    }
		return true;
    }

}
