package com.crafter.patterns.twopointer;

// or popular as Two Sum 
// Problem: Given a sorted array, find two numbers that add up to a target value.
/*
 Logic -- Opposite End direction
	Place one pointer (left) at the start and another pointer (right) at the end of the array.
	Compute the sum of elements at these pointers.
	If sum == target > Found the pair!
	If sum < target > Move the left pointer to increase the sum.
	If sum > target > Move the right pointer to decrease the sum.
 */
public class TwoSumArray {
	
	public static void main(String [] args) {
		
		int [] arr = new int [] {10,25,28,35,38,61};
		int target = 60;
		twoSumOnSortedArray(arr, target);
		
	}
	
	public static void twoSumOnSortedArray(int [] arr , int target) {
		
		int start = 0;
		int end = arr.length -1;
		int sum = 0;
		for(int i = 0; i < arr.length ; i++) {
			sum = arr[start] + arr[end];
			if(sum == target) {
				System.out.println("Target numbers : "+arr[start]+ " and "+arr[end]);
				return;
			}
			
			else if(sum > target) {
				// Need to reduce the sum; move right pointer as this is a sorted array
				end --;
				
			}else if(sum < target) {
				// Need to reduce the sum; move right pointer as this is a sorted array
				start ++;
			}
			
			
			
		}
		
	}
	
	

}
